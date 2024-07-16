package org.example.heritagebackend.service.Impl;

import lombok.RequiredArgsConstructor;
import org.example.heritagebackend.Entity.orderItems;
import org.example.heritagebackend.pojo.OrderItems_pojo;
import org.example.heritagebackend.repository.OrderItem_repo;
import org.example.heritagebackend.service.orderItem_service;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class orderItem_serviceImpl implements orderItem_service {
    private final OrderItem_repo orderItemRepo;

    @Override
    public List<orderItems> getOrderItem() {
        return orderItemRepo.findAll();
    }

    @Override
    public Optional<orderItems> getOrderItemById(Long id) {
        return orderItemRepo.findById(id);
    }

    @Override
    public orderItems addCartItem(OrderItems_pojo orderItemPojo) {
        orderItems newOrderItem = new orderItems();
        mapPojoToEntity(newOrderItem, orderItemPojo);
        return orderItemRepo.save(newOrderItem);
    }

    @Override
    public orderItems OrderItemUpdate(OrderItems_pojo orderItemPojo, Long id) {
        Optional<orderItems> orderItemsOptional = orderItemRepo.findById(id);
        if (orderItemsOptional.isPresent()) {
            orderItems existingOrderItem = orderItemsOptional.get();
            mapPojoToEntity(existingOrderItem, orderItemPojo);
            return orderItemRepo.save(existingOrderItem);
        }
        return null;
    }

    @Override
    public void deleteOrderItem(Long id) {
        orderItemRepo.deleteById(id);
    }

    private void mapPojoToEntity(orderItems orderItem, OrderItems_pojo orderItemPojo) {
        orderItem.setQuantity(orderItemPojo.getQuantity());
        orderItem.setUnitPrice(orderItemPojo.getUnitPrice());
        orderItem.setOrder(orderItemPojo.getOrder());
        orderItem.setProduct(orderItemPojo.getProduct());
    }
}
