package org.example.heritagebackend.service;

import org.example.heritagebackend.Entity.orderShipments;
import org.example.heritagebackend.pojo.OrderShipments_pojo;

import java.util.List;
import java.util.Optional;

public interface orderShipments_service {
    List<orderShipments> getOrderShipments();
    Optional<orderShipments> getOrderShipmentsById(Long Id);
    orderShipments addOrderShipments(OrderShipments_pojo OrderShipmentsPojo);
    orderShipments updateOrderShipments(OrderShipments_pojo OrderShipmentsPojo, Long id);
    void deleteOrderShipments(Long id);
}
