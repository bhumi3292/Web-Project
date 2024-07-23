package org.example.heritagebackend.service.Impl;

import lombok.RequiredArgsConstructor;
import org.example.heritagebackend.Entity.Orders;
import org.example.heritagebackend.Entity.Payments;
import org.example.heritagebackend.pojo.Payments_pojo;
import org.example.heritagebackend.repository.Orders_repo;
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
    private  final Orders_repo orders_repo;
    @Override
    public List<Payments> getPayments() {
        return payments_repo.findAll();
    }

    @Override
    public Optional<Payments> getPaymentsById(Long Id) {

        return payments_repo.findById(Id);
    }

    @Override
    public Payments addPayments(Payments_pojo PaymentsPojo) {
        Payments payments=new Payments();
        payments.setPaymentAmount(PaymentsPojo.getPaymentAmount());
        payments.setPaymentDate(new Date());
        payments.setPaymentMethod(PaymentsPojo.getPaymentMethod());
        Optional<Orders> ordersOptional=orders_repo.findById(PaymentsPojo.getOrderId());
        if(ordersOptional.isPresent()){
            Orders orders=ordersOptional.get();
            orders.setOrderStatus("paid");
            payments.setOrder(orders);
            orders_repo.save(orders);
        }


        return payments_repo.save(payments);
    }

    @Override
    public Payments updatePayments(Payments_pojo PaymentsPojo, Long id) {
        Optional<Payments> paymentsOptional=payments_repo.findById(id);
        if(paymentsOptional.isPresent()){
            Payments payment=paymentsOptional.get();
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
