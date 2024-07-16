package org.example.heritagebackend.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Setter
@Getter
public class cartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cart_item_id_seq")
    @SequenceGenerator(name = "cart_item_id_seq",sequenceName = "cart_item_seq", allocationSize = 1)
    private Long cartItemId;

    @Column(nullable = false)
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "cartId", referencedColumnName = "cartId", foreignKey = @ForeignKey(name = "fk_cart_id"))
    private org.example.heritagebackend.Entity.cart cart;

    @ManyToOne
    @JoinColumn(name = "productId", referencedColumnName = "productId", foreignKey = @ForeignKey(name = "fk_product_id"))
    private products product;



}
