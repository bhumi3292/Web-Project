package org.example.heritagebackend.service.Impl;

import lombok.RequiredArgsConstructor;
import org.example.heritagebackend.Entity.categories;
import org.example.heritagebackend.pojo.Categories_pojo;
import org.example.heritagebackend.repository.Categories_repo;
import org.example.heritagebackend.service.categories_service;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class categories_serviceImpl implements categories_service {
    private final Categories_repo categoriesRepo;

    @Override
    public List<categories> getCategories() {
        return categoriesRepo.findAll();
    }

    @Override
    public Optional<categories> getCategoriesById(Long id) {
        return categoriesRepo.findById(id);
    }

    @Override
    public categories addCategories(Categories_pojo categoriesPojo) {
        categories newCategory = new categories();
        mapPojoToEntity(newCategory, categoriesPojo);
        return categoriesRepo.save(newCategory);
    }

    @Override
    public categories updateCategories(Categories_pojo categoriesPojo, Long id) {
        Optional<categories> categoriesOptional = categoriesRepo.findById(id);
        if (categoriesOptional.isPresent()) {
            categories existingCategory = categoriesOptional.get();
            mapPojoToEntity(existingCategory, categoriesPojo);
            return categoriesRepo.save(existingCategory);
        }
        return null;
    }

    @Override
    public void deleteCategories(Long id) {
        categoriesRepo.deleteById(id);
    }

    private void mapPojoToEntity(categories category, Categories_pojo categoriesPojo) {
        category.setCategoryName(categoriesPojo.getCategoryName());
        category.setProduct(categoriesPojo.getProduct());
    }
}
