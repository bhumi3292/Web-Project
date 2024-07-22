package org.example.heritagebackend.controller;

import lombok.RequiredArgsConstructor;
import org.example.heritagebackend.Entity.Products;
import org.example.heritagebackend.pojo.Products_pojo;
import org.example.heritagebackend.service.products_service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class products_controller {

    private final products_service productsService;

    @PostMapping
    public ResponseEntity<Products> addProduct(@RequestBody Products_pojo productsPojo) {
        try {
            Products product = productsService.addProducts(productsPojo);
            return ResponseEntity.ok(product);
        } catch (IOException e) {
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productsService.deleteProducts(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public List<Products> getAllProducts() {
        return productsService.getProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Products> getProduct(@PathVariable Long id) {
        Optional<Products> productOptional = productsService.getProductsById(id);
        return productOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Products> updateProduct(@PathVariable Long id, @RequestBody Products_pojo productsPojo) {
        try {
            Products updatedProduct = productsService.updateProducts(productsPojo, id);
            if (updatedProduct != null) {
                return ResponseEntity.ok(updatedProduct);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (IOException e) {
            return ResponseEntity.status(500).build();
        }
    }
}
