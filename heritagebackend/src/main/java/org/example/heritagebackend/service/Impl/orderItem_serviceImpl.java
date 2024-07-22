package org.example.heritagebackend.service.Impl;

import lombok.RequiredArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.heritagebackend.Entity.OrderItems;
import org.example.heritagebackend.Entity.Orders;
import org.example.heritagebackend.Entity.Products;
import org.example.heritagebackend.pojo.OrderItems_pojo;
import org.example.heritagebackend.repository.OrderItem_repo;
import org.example.heritagebackend.repository.Orders_repo;
import org.example.heritagebackend.repository.Products_repo;
import org.example.heritagebackend.service.orderItem_service;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class orderItem_serviceImpl implements orderItem_service {
    private final OrderItem_repo orderItemRepo;
    private final Orders_repo ordersRepo;
    private  final Products_repo productsRepo;

    @Override
    public List<OrderItems> getOrderItem() {
        return orderItemRepo.findAll();
    }

    @Override
    public Optional<OrderItems> getOrderItemById(Long id) {
        return orderItemRepo.findById(id);
    }

    @Override
    public OrderItems addCartItem(OrderItems_pojo orderItemPojo) {
        OrderItems newOrderItem = new OrderItems();
        mapPojoToEntity(newOrderItem, orderItemPojo);
        return orderItemRepo.save(newOrderItem);
    }

    @Override
    public OrderItems OrderItemUpdate(OrderItems_pojo orderItemPojo, Long id) {
        Optional<OrderItems> orderItemsOptional = orderItemRepo.findById(id);
        if (orderItemsOptional.isPresent()) {
            OrderItems existingOrderItem = orderItemsOptional.get();
            mapPojoToEntity(existingOrderItem, orderItemPojo);
            return orderItemRepo.save(existingOrderItem);
        }
        return null;
    }

    @Override
    public void deleteOrderItem(Long id) {
        orderItemRepo.deleteById(id);
    }

    private void mapPojoToEntity(OrderItems orderItem, OrderItems_pojo orderItemPojo) {
        orderItem.setQuantity(orderItemPojo.getQuantity());
        orderItem.setUnitPrice(orderItemPojo.getUnitPrice());
        Optional<Orders> ordersOptional=ordersRepo.findById(orderItemPojo.getOrderId());
        if (ordersOptional.isPresent()) {
            Orders orders = ordersOptional.get();
            orderItem.setOrder(orders);
        }
       Optional<Products> optionalProducts=productsRepo.findById(orderItemPojo.getProductId());
        if (optionalProducts.isPresent()) {
            Products products = optionalProducts.get();
            orderItem.setProduct(products);
        }
    }
}
