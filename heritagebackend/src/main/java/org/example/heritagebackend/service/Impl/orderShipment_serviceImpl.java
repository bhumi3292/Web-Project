package org.example.heritagebackend.service.Impl;

import lombok.RequiredArgsConstructor;
import org.example.heritagebackend.Entity.orderShipments;
import org.example.heritagebackend.pojo.OrderShipments_pojo;
import org.example.heritagebackend.repository.OrderShipments_repo;
import org.example.heritagebackend.service.orderShipments_service;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class orderShipment_serviceImpl implements orderShipments_service {

    private final OrderShipments_repo orderShipments_repo;

    @Override
    public List<orderShipments> getOrderShipments() {
        return orderShipments_repo.findAll();
    }

    @Override
    public Optional<orderShipments> getOrderShipmentsById(Long Id) {
        return orderShipments_repo.findById(Id);
    }

    @Override
    public orderShipments addOrderShipments(OrderShipments_pojo OrderShipmentsPojo) {
        orderShipments orderShipment = new orderShipments();
        orderShipment.setShipmentDate(new Date());
        orderShipment.setShipmentStatus(OrderShipmentsPojo.getShipmentStatus());

        return orderShipments_repo.save(orderShipment);
    }

    @Override
    public orderShipments updateOrderShipments(OrderShipments_pojo OrderShipmentsPojo, Long id) {
        Optional<orderShipments> orderShipmentsOptional = orderShipments_repo.findById(id);
        if (orderShipmentsOptional.isPresent()) {
            orderShipments orderShipment = orderShipmentsOptional.get();
            orderShipment.setShipmentDate(new Date());
            orderShipment.setShipmentStatus(OrderShipmentsPojo.getShipmentStatus());
            return orderShipments_repo.save(orderShipment);
        }
        return null;
    }

    @Override
    public void deleteOrderShipments(Long id) {
        orderShipments_repo.deleteById(id);
    }
}
