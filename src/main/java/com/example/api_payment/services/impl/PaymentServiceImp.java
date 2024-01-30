package com.example.api_payment.services.impl;

import com.example.api_payment.api.initialiseTransaction.InitialiseTransactionResponse;
import com.example.api_payment.api.verifyTransaction.VerifyTransactionResponse;
import com.example.api_payment.dto.InitialisePaymentRequest;
import com.example.api_payment.model.Payment;
import com.example.api_payment.repository.PaymentRepository;
import com.example.api_payment.services.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentServiceImp implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final WebClient webClient = WebClient.builder()
            .baseUrl("https://api.paystack.co")
            .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer sk_test_fc363169701d5d7f77c1b83b7a0bdfdd7d008497")
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .build();


    @Override
    public ResponseEntity<InitialiseTransactionResponse> initialiseTransaction(InitialisePaymentRequest initialisePaymentRequest) {
        String reference = UUID.randomUUID().toString();
        Payment payment = mapInitialisePaymentRequestToPayment(initialisePaymentRequest);
        payment.setReference(reference);
        payment.setCurrency("NGN");

        InitialiseTransactionResponse initialiseTransactionResponse = webClient.post()
                .uri("/transaction/initialize")
                .bodyValue(initialisePaymentRequest)
                .retrieve()
                .bodyToMono(InitialiseTransactionResponse.class)
                .block();

        if (initialiseTransactionResponse != null){
            paymentRepository.save(payment);
            return new ResponseEntity<>(initialiseTransactionResponse, HttpStatus.OK);
        }

        return null;
    }

    @Override
    public ResponseEntity<VerifyTransactionResponse> verifyTransaction(String reference) {

        Payment payment = paymentRepository.findByReference(reference) .orElseThrow();

        VerifyTransactionResponse verifyTransactionResponse = webClient.get()
                .uri("/transaction/verify/" + reference)
                .retrieve()
                .bodyToMono(VerifyTransactionResponse.class)
                .block();

        if (verifyTransactionResponse != null)
            return new ResponseEntity<>(verifyTransactionResponse, HttpStatus.OK);


        return null;
    }

    public Payment mapInitialisePaymentRequestToPayment(InitialisePaymentRequest initialisePaymentRequest){
        return Payment.builder()
                .amount(initialisePaymentRequest.getAmount())
                .email(initialisePaymentRequest.getEmail())
                .build();
    }
}
