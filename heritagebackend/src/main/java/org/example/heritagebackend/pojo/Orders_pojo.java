package org.example.heritagebackend.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.heritagebackend.Entity.Customers;
import org.example.heritagebackend.Entity.orderShipments;
import org.example.heritagebackend.Entity.Payments;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Orders_pojo {
    private Long orderId;
    private Customers customer;
    private Date orderDate;
    private Double totalAmount;
    private String shippingAddress;
    private String orderStatus;
    private Payments payment;
    private List<OrderItems_pojo> orderItemPojos;

    public List<OrderItems_pojo> getOrderItemPojos() {
        return orderItemPojos;
    }


}
