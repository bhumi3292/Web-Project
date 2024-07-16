package org.example.heritagebackend.service;

import org.example.heritagebackend.Entity.payments;
import org.example.heritagebackend.pojo.Payments_pojo;

import java.util.List;
import java.util.Optional;

public interface payments_service {
    List<payments> getPayments();
    Optional<payments> getPaymentsById(Long Id);
    payments addPayments(Payments_pojo PaymentsPojo);
    payments updatePayments(Payments_pojo PaymentsPojo, Long id);
    void deletePayments(Long id);
}
