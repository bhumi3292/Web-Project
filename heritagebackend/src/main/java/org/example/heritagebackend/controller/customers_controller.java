package org.example.heritagebackend.controller;

import lombok.RequiredArgsConstructor;
import org.example.heritagebackend.Entity.Customers;
import org.example.heritagebackend.pojo.Customers_pojo;
import org.example.heritagebackend.service.customer_service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class customers_controller {

    private final customer_service customerService;

    @PostMapping
    public Customers addCustomer(@RequestBody Customers_pojo customersPojo) {
        return customerService.addCustomers(customersPojo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomers(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public List<Customers> getAllCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customers> getCustomerById(@PathVariable Long id) {
        Optional<Customers> customerOptional = customerService.getCustomersById(id);
        return customerOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customers> updateCustomer(@PathVariable Long id, @RequestBody Customers_pojo customersPojo) {
        Customers updatedCustomer = customerService.updateCustomers(customersPojo, id);
        if (updatedCustomer != null) {
            return ResponseEntity.ok(updatedCustomer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
