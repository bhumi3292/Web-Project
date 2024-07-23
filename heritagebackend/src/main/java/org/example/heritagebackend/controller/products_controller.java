package org.example.heritagebackend.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.heritagebackend.Entity.Products;
import org.example.heritagebackend.pojo.Products_pojo;
import org.example.heritagebackend.service.products_service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class products_controller {

    private final products_service productsService;

    @PostMapping(consumes = {"multipart/form-data"})
    public ResponseEntity<Products> addProduct(@RequestBody @Valid @ModelAttribute Products_pojo productsPojo,@RequestParam("image") MultipartFile image) throws IOException {
        byte[] imageBytes=productsPojo.getImageBytes();
        if(imageBytes!=null) {
            productsPojo.setImageBytes(imageBytes);
        }
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
    @Transactional
    public List<Products> getAllProducts() {
        return productsService.getProducts();
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<Products> getProduct(@PathVariable Long id) {
        Optional<Products> productOptional = productsService.getProductsById(id);
        return productOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping(value = "/{id}",consumes = {"multipart/form-data"})
    public ResponseEntity<Products> updateProduct(@PathVariable Long id, @RequestBody @ModelAttribute Products_pojo productsPojo,@RequestParam("image") MultipartFile image) throws IOException {
        byte[] imageBytes = image.getBytes();
        if (imageBytes != null) {
            productsPojo.setImageBytes(imageBytes);
        }
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
