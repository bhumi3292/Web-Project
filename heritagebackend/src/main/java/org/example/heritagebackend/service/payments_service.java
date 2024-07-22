package org.example.heritagebackend.service;

import org.example.heritagebackend.Entity.Payments;
import org.example.heritagebackend.pojo.Payments_pojo;

import java.util.List;
import java.util.Optional;

public interface payments_service {
    List<Payments> getPayments();
    Optional<Payments> getPaymentsById(Long Id);
    Payments addPayments(Payments_pojo PaymentsPojo);
    Payments updatePayments(Payments_pojo PaymentsPojo, Long id);
    void deletePayments(Long id);
}
