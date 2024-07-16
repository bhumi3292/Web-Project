package org.example.heritagebackend.repository;

import org.example.heritagebackend.Entity.orderItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItem_repo extends JpaRepository<orderItems,Long>{
}
