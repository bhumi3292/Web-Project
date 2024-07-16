package org.example.heritagebackend.service;

import org.example.heritagebackend.Entity.orders;

import org.example.heritagebackend.pojo.Orders_pojo;

import java.util.List;
import java.util.Optional;

public interface order_service {
    List<orders> getOrders();
    Optional<orders> getOrdersById(Long Id);
    orders addOrders(Orders_pojo OrdersPojo);
    orders updateOrders(Orders_pojo OrdersPojo, Long id);
    void deleteOrders(Long id);
}
