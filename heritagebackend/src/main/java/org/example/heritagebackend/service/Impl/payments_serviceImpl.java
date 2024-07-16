package org.example.heritagebackend.service.Impl;

import lombok.RequiredArgsConstructor;
import org.example.heritagebackend.Entity.payments;
import org.example.heritagebackend.pojo.Payments_pojo;
import org.example.heritagebackend.repository.Payments_repo;
import org.example.heritagebackend.service.payments_service;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor

public class payments_serviceImpl implements payments_service {
    private final Payments_repo payments_repo;
    @Override
    public List<payments> getPayments() {
        return payments_repo.findAll();
    }

    @Override
    public Optional<payments> getPaymentsById(Long Id) {

        return payments_repo.findById(Id);
    }

    @Override
    public payments addPayments(Payments_pojo PaymentsPojo) {
        payments payments=new payments();
        payments.setPaymentAmount(PaymentsPojo.getPaymentAmount());
        payments.setPaymentDate(new Date());
        payments.setPaymentMethod(PaymentsPojo.getPaymentMethod());

        return payments_repo.save(payments);
    }

    @Override
    public payments updatePayments(Payments_pojo PaymentsPojo, Long id) {
        Optional<payments> paymentsOptional=payments_repo.findById(id);
        if(paymentsOptional.isPresent()){
            payments payment=paymentsOptional.get();
            payment.setPaymentAmount(PaymentsPojo.getPaymentAmount());
            payment.setPaymentDate(new Date());
            payment.setPaymentMethod(PaymentsPojo.getPaymentMethod());
            return payments_repo.save(payment);
        }
       return null;


    }

    @Override
    public void deletePayments(Long id) {
        payments_repo.deleteById(id);

    }
}
