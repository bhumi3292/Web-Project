package org.example.heritagebackend.service;

import org.example.heritagebackend.Entity.orderItems;
import org.example.heritagebackend.pojo.OrderItems_pojo;

import java.util.List;
import java.util.Optional;

public interface orderItem_service {
    List<orderItems> getOrderItem();
    Optional<orderItems> getOrderItemById(Long Id);
    orderItems addCartItem(OrderItems_pojo OrderItemPojo);
   orderItems OrderItemUpdate(OrderItems_pojo OrderItemPojo, Long id);
    void deleteOrderItem(Long id);
}
