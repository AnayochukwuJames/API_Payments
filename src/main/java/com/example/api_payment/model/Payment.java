package com.example.api_payment.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "payment")
@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "amount")
    private String amount;
    @Column(name = "email")
    private String email;
    @Column(name = "reference")
    private String reference;
    @Column(name = "currency")
    private String currency;
}
