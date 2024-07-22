package org.example.heritagebackend.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table
@Setter
@Getter
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orders_id_seq")
    @SequenceGenerator(name = "orders_id_seq", sequenceName = "orders_seq", allocationSize = 1)
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "customerId", referencedColumnName = "customerId", foreignKey = @ForeignKey(name = "fk_customer_id"))
    private Customers customer;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;

    @Column(nullable = false)
    private Double totalAmount;

    @Column(nullable = false)
    private String shippingAddress;

    @Column(nullable = false)
    private String orderStatus;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Payments payment;


    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL) // For automatic saving of order items
    @JsonIgnore
    private List<OrderItems> orderItems = new ArrayList<>();
}
