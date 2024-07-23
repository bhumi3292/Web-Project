package org.example.heritagebackend.service.Impl;

import lombok.RequiredArgsConstructor;
import org.example.heritagebackend.Entity.Customers;
import org.example.heritagebackend.Entity.Orders;
import org.example.heritagebackend.pojo.Orders_pojo;
import org.example.heritagebackend.repository.Customer_repo;
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
    private final Customer_repo customerRepo;

    @Override
    public List<Orders> getOrders() {
        return ordersRepo.findAll();
    }
 @Override
    public List<Orders> getOrdersbycustomer(Long customer_id) {
        return ordersRepo.findByCustomerCustomerId(customer_id);
    }

    @Override
    public Optional<Orders> getOrdersById(Long id) {
        return ordersRepo.findById(id);
    }

    @Override
    public Orders addOrders(Orders_pojo ordersPojo) {
        Orders newOrder = new Orders();
        mapPojoToEntity(newOrder, ordersPojo);
        return ordersRepo.save(newOrder);
    }

    @Override
    public Orders updateOrders(Orders_pojo ordersPojo, Long id) {
        Optional<Orders> ordersOptional = ordersRepo.findById(id);
        if (ordersOptional.isPresent()) {
            Orders existingOrder = ordersOptional.get();
            mapPojoToEntity(existingOrder, ordersPojo);
            return ordersRepo.save(existingOrder);
        }
        return null;
    }

    @Override
    public void deleteOrders(Long id) {
        ordersRepo.deleteById(id);
    }

    private void mapPojoToEntity(Orders order, Orders_pojo ordersPojo) {
        Optional<Customers> ordersOptional=customerRepo.findById(ordersPojo.getCustomerId());
        if (ordersOptional.isPresent()) {
            Customers customers = ordersOptional.get();
            order.setCustomer(customers);
            order.setShippingAddress(customers.getAddress());
        }
        order.setOrderDate(new Date());
        order.setTotalAmount(ordersPojo.getTotalAmount());

        order.setOrderStatus("pending");
//        order.setPayment(ordersPojo.getPayment());
//        order.setOrderShipment(ordersPojo.getOrder
//        Shipment());
    }
}
