package com.example.api_payment.controller;

import com.example.api_payment.api.initialiseTransaction.InitialiseTransactionResponse;
import com.example.api_payment.api.verifyTransaction.VerifyTransactionResponse;
import com.example.api_payment.dto.InitialisePaymentRequest;
import com.example.api_payment.services.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/payment")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping("/initialise-transaction")
    public ResponseEntity<InitialiseTransactionResponse> initialiseTransaction(@RequestBody
            InitialisePaymentRequest initialisePaymentRequest){
        return paymentService.initialiseTransaction(initialisePaymentRequest);
    }

    @GetMapping("/verify")
    public ResponseEntity<VerifyTransactionResponse> verifyTransaction(@RequestParam ("trxref") String reference){
        return paymentService.verifyTransaction(reference);

    }

}
