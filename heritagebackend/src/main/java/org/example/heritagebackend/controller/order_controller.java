package org.example.heritagebackend.controller;

import lombok.RequiredArgsConstructor;
import org.example.heritagebackend.Entity.Orders;
import org.example.heritagebackend.pojo.Orders_pojo;
import org.example.heritagebackend.service.order_service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class order_controller {

    private final order_service orderService;

    @PostMapping
    public Orders addOrder(@RequestBody Orders_pojo ordersPojo) {
        return orderService.addOrders(ordersPojo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrders(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public List<Orders> getAllOrders() {
        return orderService.getOrders();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Orders> getOrder(@PathVariable Long id) {
        Optional<Orders> orderOptional = orderService.getOrdersById(id);
        return orderOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Orders> updateOrder(@PathVariable Long id, @RequestBody Orders_pojo ordersPojo) {
        Orders updatedOrder = orderService.updateOrders(ordersPojo, id);
        if (updatedOrder != null) {
            return ResponseEntity.ok(updatedOrder);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
