package org.example.heritagebackend.controller;

import lombok.RequiredArgsConstructor;
import org.example.heritagebackend.Entity.orderItems;
import org.example.heritagebackend.pojo.OrderItems_pojo;
import org.example.heritagebackend.service.orderItem_service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orderItems")
@RequiredArgsConstructor
public class orderItems_controller {

    private final orderItem_service orderItemService;

    @PostMapping
    public orderItems addOrderItem(@RequestBody OrderItems_pojo orderItemsPojo) {
        return orderItemService.addCartItem(orderItemsPojo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderItem(@PathVariable Long id) {
        orderItemService.deleteOrderItem(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public List<orderItems> getAllOrderItems() {
        return orderItemService.getOrderItem();
    }

    @GetMapping("/{id}")
    public ResponseEntity<orderItems> getOrderItemById(@PathVariable Long id) {
        Optional<orderItems> orderItemOptional = orderItemService.getOrderItemById(id);
        return orderItemOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<orderItems> updateOrderItem(@PathVariable Long id, @RequestBody OrderItems_pojo orderItemsPojo) {
        orderItems updatedOrderItem = orderItemService.OrderItemUpdate(orderItemsPojo, id);
        if (updatedOrderItem != null) {
            return ResponseEntity.ok(updatedOrderItem);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
