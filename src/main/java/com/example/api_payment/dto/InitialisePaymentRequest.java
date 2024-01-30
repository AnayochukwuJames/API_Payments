package com.example.api_payment.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class InitialisePaymentRequest {
    private String amount;
    private String email;
    private String reference;
    private String currency;
}
