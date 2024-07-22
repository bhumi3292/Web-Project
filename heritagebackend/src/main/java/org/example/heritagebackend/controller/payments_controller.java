package org.example.heritagebackend.controller;

import lombok.RequiredArgsConstructor;
import org.example.heritagebackend.Entity.Payments;
import org.example.heritagebackend.pojo.Payments_pojo;
import org.example.heritagebackend.service.payments_service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class payments_controller {

    private final payments_service paymentsService;

    @PostMapping
    public Payments addPayment(@RequestBody Payments_pojo paymentsPojo) {
        return paymentsService.addPayments(paymentsPojo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable Long id) {
        paymentsService.deletePayments(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public List<Payments> getAllPayments() {
        return paymentsService.getPayments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payments> getPayment(@PathVariable Long id) {
        Optional<Payments> paymentOptional = paymentsService.getPaymentsById(id);
        return paymentOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Payments> updatePayment(@PathVariable Long id, @RequestBody Payments_pojo paymentsPojo) {
        Payments updatedPayment = paymentsService.updatePayments(paymentsPojo, id);
        if (updatedPayment != null) {
            return ResponseEntity.ok(updatedPayment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
