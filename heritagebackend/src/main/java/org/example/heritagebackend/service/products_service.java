

package org.example.heritagebackend.service;

import org.example.heritagebackend.Entity.products;
import org.example.heritagebackend.pojo.Products_pojo;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface products_service {
    List<products> getProducts();
    Optional<products> getProductsById(Long id);
    products addProducts(Products_pojo productsPojo) throws IOException;
    products updateProducts(Products_pojo ProductsPojo, Long id) throws IOException;
    void deleteProducts(Long id);
}
