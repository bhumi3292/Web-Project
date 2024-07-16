package org.example.heritagebackend.controller;

import lombok.RequiredArgsConstructor;
import org.example.heritagebackend.Entity.orderShipments;
import org.example.heritagebackend.pojo.OrderShipments_pojo;
import org.example.heritagebackend.service.orderShipments_service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/order-shipments")
@RequiredArgsConstructor
public class orderShipments_controller {

    private final orderShipments_service orderShipmentsService;

    @PostMapping
    public orderShipments addOrderShipment(@RequestBody OrderShipments_pojo orderShipmentsPojo) {
        return orderShipmentsService.addOrderShipments(orderShipmentsPojo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderShipment(@PathVariable Long id) {
        orderShipmentsService.deleteOrderShipments(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public List<orderShipments> getAllOrderShipments() {
        return orderShipmentsService.getOrderShipments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<orderShipments> getOrderShipment(@PathVariable Long id) {
        Optional<orderShipments> orderShipmentOptional = orderShipmentsService.getOrderShipmentsById(id);
        return orderShipmentOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<orderShipments> updateOrderShipment(@PathVariable Long id, @RequestBody OrderShipments_pojo orderShipmentsPojo) {
        orderShipments updatedOrderShipment = orderShipmentsService.updateOrderShipments(orderShipmentsPojo, id);
        if (updatedOrderShipment != null) {
            return ResponseEntity.ok(updatedOrderShipment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
