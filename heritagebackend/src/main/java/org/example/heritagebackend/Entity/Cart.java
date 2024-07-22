package org.example.heritagebackend.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Setter
@Getter
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cart_id_seq")
    @SequenceGenerator(name = "cart_id_seq", sequenceName = "cart_seq", allocationSize = 1)
    private Long cartId;

    @ManyToOne
    @JoinColumn(name = "customerId", referencedColumnName = "customerId", foreignKey = @ForeignKey(name = "fk_customer_id"))
    private Customers customer;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL) // For automatic saving of order items
    @JsonIgnore
    private List<CartItem> orderItems = new ArrayList<>();

}
