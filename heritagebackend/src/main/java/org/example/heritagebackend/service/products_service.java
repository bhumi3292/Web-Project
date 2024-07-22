

package org.example.heritagebackend.service;

import org.example.heritagebackend.Entity.Products;
import org.example.heritagebackend.pojo.Products_pojo;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface products_service {
    List<Products> getProducts();
    Optional<Products> getProductsById(Long id);
    Products addProducts(Products_pojo productsPojo) throws IOException;
    Products updateProducts(Products_pojo ProductsPojo, Long id) throws IOException;
    void deleteProducts(Long id);
}
