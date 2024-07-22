package org.example.heritagebackend.controller;

import lombok.RequiredArgsConstructor;
import org.example.heritagebackend.Entity.Categories;
import org.example.heritagebackend.pojo.Categories_pojo;
import org.example.heritagebackend.service.categories_service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor

public class categories_controller {


    private final categories_service categoriesService;

    @PostMapping
    public Categories addCategory(@RequestBody Categories_pojo categoriesPojo) {
        return categoriesService.addCategories(categoriesPojo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoriesService.deleteCategories(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public List<Categories> getAllCategories() {
        return categoriesService.getCategories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categories> getCategoryById(@PathVariable Long id) {
        Optional<Categories> categoryOptional = categoriesService.getCategoriesById(id);
        return categoryOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categories> updateCategory(@PathVariable Long id, @RequestBody Categories_pojo categoriesPojo) {
        Categories updatedCategory = categoriesService.updateCategories(categoriesPojo, id);
        if (updatedCategory != null) {
            return ResponseEntity.ok(updatedCategory);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
