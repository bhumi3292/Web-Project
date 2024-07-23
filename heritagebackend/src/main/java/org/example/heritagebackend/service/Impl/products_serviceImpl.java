package org.example.heritagebackend.service.Impl;

import lombok.RequiredArgsConstructor;
import org.example.heritagebackend.Entity.Products;
import org.example.heritagebackend.pojo.Products_pojo;
import org.example.heritagebackend.repository.Products_repo;
import org.example.heritagebackend.service.products_service;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class products_serviceImpl implements products_service {

    private final Products_repo products_repo;

    @Override
    public List<Products> getProducts() {

        List<Products> products = products_repo.findAll();
        return products;


    }

    @Override
    public Optional<Products> getProductsById(Long id) {
Optional<Products> products = products_repo.findById(id);
return products;
    }

    @Override
    public Products addProducts(Products_pojo productsPojo) throws IOException {
        Products product = new Products();
        product.setName(productsPojo.getName());
        product.setDescription(productsPojo.getDescription());
        product.setPrice(productsPojo.getPrice());
        product.setStockQuantity(productsPojo.getStockQuantity());
//        product.setProfile(productsPojo.getProfile().getOriginalFilename());
        product.setAvailability(productsPojo.isAvailability());
        product.setImage(productsPojo.getImageBytes());



        return products_repo.save(product);
    }

    @Override
    public Products updateProducts(Products_pojo productsPojo, Long id) throws IOException {
        Optional<Products> productsOptional = products_repo.findById(id);

        if (productsOptional.isPresent()) {
            Products product = productsOptional.get();
            product.setName(productsPojo.getName());
            product.setDescription(productsPojo.getDescription());
            product.setPrice(productsPojo.getPrice());
            product.setStockQuantity(productsPojo.getStockQuantity());
            product.setAvailability(productsPojo.isAvailability());

           product.setImage(productsPojo.getImageBytes());

            return products_repo.save(product);
        }

        return null;
    }

    @Override
    public void deleteProducts(Long id) {
        products_repo.deleteById(id);
    }

}
