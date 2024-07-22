package org.example.heritagebackend.service.Impl;

import lombok.RequiredArgsConstructor;
import org.example.heritagebackend.Entity.Customers;
import org.example.heritagebackend.pojo.Customers_pojo;
import org.example.heritagebackend.repository.Customer_repo;
import org.example.heritagebackend.service.customer_service;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class customers_serviceImpl implements customer_service {
    private final Customer_repo customersRepo;

    @Override
    public List<Customers> getCustomers() {
        return customersRepo.findAll();
    }

    @Override
    public Optional<Customers> getCustomersById(Long id) {
        return customersRepo.findById(id);
    }

    @Override
    public Customers addCustomers(Customers_pojo customersPojo) {
        Customers newCustomer = new Customers();
        newCustomer.setFirstName(customersPojo.getFirstName());
        newCustomer.setLastName(customersPojo.getLastName());
        newCustomer.setEmail(customersPojo.getEmail());
        newCustomer.setPasswordHash(customersPojo.getPasswordHash());
        newCustomer.setPhoneNumber(customersPojo.getPhoneNumber());
        newCustomer.setAddress(customersPojo.getAddress());
        newCustomer.setCity(customersPojo.getCity());
        newCustomer.setState(customersPojo.getState());
        newCustomer.setZipCode(customersPojo.getZipCode());
        newCustomer.setCountry(customersPojo.getCountry());

        return customersRepo.save(newCustomer);
    }

    @Override
    public Customers updateCustomers(Customers_pojo customersPojo, Long id) {
        Optional<Customers> customersOptional = customersRepo.findById(id);
        if (customersOptional.isPresent()) {
            Customers existingCustomer = customersOptional.get();
            existingCustomer.setFirstName(customersPojo.getFirstName());
            existingCustomer.setLastName(customersPojo.getLastName());
            existingCustomer.setEmail(customersPojo.getEmail());
            existingCustomer.setPasswordHash(customersPojo.getPasswordHash());
            existingCustomer.setPhoneNumber(customersPojo.getPhoneNumber());
            existingCustomer.setAddress(customersPojo.getAddress());
            existingCustomer.setCity(customersPojo.getCity());
            existingCustomer.setState(customersPojo.getState());
            existingCustomer.setZipCode(customersPojo.getZipCode());
            existingCustomer.setCountry(customersPojo.getCountry());

            return customersRepo.save(existingCustomer);
        }
        return null;
    }

    @Override
    public void deleteCustomers(Long id) {
        customersRepo.deleteById(id);
    }
}
