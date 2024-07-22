package org.example.heritagebackend.service;

import org.example.heritagebackend.Entity.Categories;
import org.example.heritagebackend.pojo.Categories_pojo;

import java.util.List;
import java.util.Optional;

public interface categories_service {
    List<Categories> getCategories();
    Optional<Categories> getCategoriesById(Long Id);
    Categories addCategories(Categories_pojo categoriesPojo);
    Categories updateCategories(Categories_pojo categoriesPojo, Long id);
    void deleteCategories(Long id);

}
