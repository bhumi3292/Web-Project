package org.example.heritagebackend.repository;

import org.example.heritagebackend.Entity.orderShipments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderShipments_repo extends JpaRepository<orderShipments,Long> {
}
