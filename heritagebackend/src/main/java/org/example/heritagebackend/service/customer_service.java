package org.example.heritagebackend.service;

import org.example.heritagebackend.Entity.Customers;
import org.example.heritagebackend.pojo.Customers_pojo;

import java.util.List;
import java.util.Optional;

public interface customer_service {
    List<Customers> getCustomers();
    Optional<Customers> getCustomersById(Long Id);
    Customers addCustomers(Customers_pojo CustomersPojo);
    Customers updateCustomers(Customers_pojo CustomersPojo, Long id);
    void deleteCustomers(Long id);
}
