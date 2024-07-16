package org.example.heritagebackend.service.Impl;

import lombok.RequiredArgsConstructor;
import org.example.heritagebackend.Entity.orders;
import org.example.heritagebackend.pojo.Orders_pojo;
import org.example.heritagebackend.repository.Orders_repo;
import org.example.heritagebackend.service.order_service;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class order_serviceImpl implements order_service {
    private final Orders_repo ordersRepo;

    @Override
    public List<orders> getOrders() {
        return ordersRepo.findAll();
    }

    @Override
    public Optional<orders> getOrdersById(Long id) {
        return ordersRepo.findById(id);
    }

    @Override
    public orders addOrders(Orders_pojo ordersPojo) {
        orders newOrder = new orders();
        mapPojoToEntity(newOrder, ordersPojo);
        return ordersRepo.save(newOrder);
    }

    @Override
    public orders updateOrders(Orders_pojo ordersPojo, Long id) {
        Optional<orders> ordersOptional = ordersRepo.findById(id);
        if (ordersOptional.isPresent()) {
            orders existingOrder = ordersOptional.get();
            mapPojoToEntity(existingOrder, ordersPojo);
            return ordersRepo.save(existingOrder);
        }
        return null;
    }

    @Override
    public void deleteOrders(Long id) {
        ordersRepo.deleteById(id);
    }

    private void mapPojoToEntity(orders order, Orders_pojo ordersPojo) {
        order.setCustomer(ordersPojo.getCustomer());
        order.setOrderDate(new Date());
        order.setTotalAmount(ordersPojo.getTotalAmount());
        order.setShippingAddress(ordersPojo.getShippingAddress());
        order.setOrderStatus(ordersPojo.getOrderStatus());
        order.setPayment(ordersPojo.getPayment());
        order.setOrderShipment(ordersPojo.getOrderShipment());
    }
}
