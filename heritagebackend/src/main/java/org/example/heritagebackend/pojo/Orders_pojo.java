package org.example.heritagebackend.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.heritagebackend.Entity.customers;
import org.example.heritagebackend.Entity.orderShipments;
import org.example.heritagebackend.Entity.payments;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Orders_pojo {

    private customers customer;
    private Date orderDate;
    private Double totalAmount;
    private String shippingAddress;
    private String orderStatus;
    private payments payment;
    private orderShipments orderShipment;

}
