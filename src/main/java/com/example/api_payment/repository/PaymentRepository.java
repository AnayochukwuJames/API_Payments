package com.example.api_payment.repository;

import com.example.api_payment.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Optional<Payment> findByReference (String reference);



}
