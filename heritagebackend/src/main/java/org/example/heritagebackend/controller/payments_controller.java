package org.example.heritagebackend.controller;

import lombok.RequiredArgsConstructor;
import org.example.heritagebackend.Entity.payments;
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
    public payments addPayment(@RequestBody Payments_pojo paymentsPojo) {
        return paymentsService.addPayments(paymentsPojo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable Long id) {
        paymentsService.deletePayments(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public List<payments> getAllPayments() {
        return paymentsService.getPayments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<payments> getPayment(@PathVariable Long id) {
        Optional<payments> paymentOptional = paymentsService.getPaymentsById(id);
        return paymentOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<payments> updatePayment(@PathVariable Long id, @RequestBody Payments_pojo paymentsPojo) {
        payments updatedPayment = paymentsService.updatePayments(paymentsPojo, id);
        if (updatedPayment != null) {
            return ResponseEntity.ok(updatedPayment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
