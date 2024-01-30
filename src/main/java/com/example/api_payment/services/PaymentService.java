package com.example.api_payment.services;

import com.example.api_payment.api.initialiseTransaction.InitialiseTransactionResponse;
import com.example.api_payment.api.verifyTransaction.VerifyTransactionResponse;
import com.example.api_payment.dto.InitialisePaymentRequest;
import org.springframework.http.ResponseEntity;

public interface PaymentService {
    ResponseEntity<InitialiseTransactionResponse> initialiseTransaction (InitialisePaymentRequest initialisePaymentRequest);
    ResponseEntity<VerifyTransactionResponse> verifyTransaction(String reference);
}
