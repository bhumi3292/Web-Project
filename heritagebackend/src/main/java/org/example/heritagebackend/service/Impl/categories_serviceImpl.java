package org.example.heritagebackend.service.Impl;

import lombok.RequiredArgsConstructor;
import org.example.heritagebackend.Entity.Categories;
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
    public List<Categories> getCategories() {
        return categoriesRepo.findAll();
    }

    @Override
    public Optional<Categories> getCategoriesById(Long id) {
        return categoriesRepo.findById(id);
    }

    @Override
    public Categories addCategories(Categories_pojo categoriesPojo) {
        Categories newCategory = new Categories();
        mapPojoToEntity(newCategory, categoriesPojo);
        return categoriesRepo.save(newCategory);
    }

    @Override
    public Categories updateCategories(Categories_pojo categoriesPojo, Long id) {
        Optional<Categories> categoriesOptional = categoriesRepo.findById(id);
        if (categoriesOptional.isPresent()) {
            Categories existingCategory = categoriesOptional.get();
            mapPojoToEntity(existingCategory, categoriesPojo);
            return categoriesRepo.save(existingCategory);
        }
        return null;
    }

    @Override
    public void deleteCategories(Long id) {
        categoriesRepo.deleteById(id);
    }

    private void mapPojoToEntity(Categories category, Categories_pojo categoriesPojo) {
        category.setCategoryName(categoriesPojo.getCategoryName());
    }
}
