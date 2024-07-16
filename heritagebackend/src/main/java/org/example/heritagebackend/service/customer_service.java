package org.example.heritagebackend.service;

import org.example.heritagebackend.Entity.customers;
import org.example.heritagebackend.pojo.Customers_pojo;

import java.util.List;
import java.util.Optional;

public interface customer_service {
    List<customers> getCustomers();
    Optional<customers> getCustomersById(Long Id);
    customers addCustomers(Customers_pojo CustomersPojo);
    customers updateCustomers(Customers_pojo CustomersPojo, Long id);
    void deleteCustomers(Long id);
}
