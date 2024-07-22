package org.example.heritagebackend.service;

import org.example.heritagebackend.Entity.OrderItems;
import org.example.heritagebackend.pojo.OrderItems_pojo;

import java.util.List;
import java.util.Optional;

public interface orderItem_service {
    List<OrderItems> getOrderItem();
    Optional<OrderItems> getOrderItemById(Long Id);
    OrderItems addCartItem(OrderItems_pojo OrderItemPojo);
   OrderItems OrderItemUpdate(OrderItems_pojo OrderItemPojo, Long id);
    void deleteOrderItem(Long id);
}
