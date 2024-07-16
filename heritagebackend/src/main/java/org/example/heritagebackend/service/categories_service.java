package org.example.heritagebackend.service;

import org.example.heritagebackend.Entity.categories;
import org.example.heritagebackend.pojo.Categories_pojo;

import java.util.List;
import java.util.Optional;

public interface categories_service {
    List<categories> getCategories();
    Optional<categories> getCategoriesById(Long Id);
    categories addCategories(Categories_pojo categoriesPojo);
    categories updateCategories(Categories_pojo categoriesPojo, Long id);
    void deleteCategories(Long id);

}
