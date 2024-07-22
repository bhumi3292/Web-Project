package org.example.heritagebackend.repository;


import org.example.heritagebackend.Entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Products_repo extends JpaRepository<Products, Long> {

}
