package org.example.heritagebackend.service;

import org.example.heritagebackend.Entity.Orders;

import org.example.heritagebackend.pojo.Orders_pojo;

import java.util.List;
import java.util.Optional;

public interface order_service {
    List<Orders> getOrders();
    List<Orders> getOrdersbycustomer(Long customer_id);
    Optional<Orders> getOrdersById(Long Id);
    Orders addOrders(Orders_pojo OrdersPojo);
    Orders updateOrders(Orders_pojo OrdersPojo, Long id);
    void deleteOrders(Long id);
}
