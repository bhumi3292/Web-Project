package org.example.heritagebackend.controller;

import lombok.RequiredArgsConstructor;
import org.example.heritagebackend.Entity.customers;
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
    public customers addCustomer(@RequestBody Customers_pojo customersPojo) {
        return customerService.addCustomers(customersPojo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomers(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public List<customers> getAllCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<customers> getCustomerById(@PathVariable Long id) {
        Optional<customers> customerOptional = customerService.getCustomersById(id);
        return customerOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<customers> updateCustomer(@PathVariable Long id, @RequestBody Customers_pojo customersPojo) {
        customers updatedCustomer = customerService.updateCustomers(customersPojo, id);
        if (updatedCustomer != null) {
            return ResponseEntity.ok(updatedCustomer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
