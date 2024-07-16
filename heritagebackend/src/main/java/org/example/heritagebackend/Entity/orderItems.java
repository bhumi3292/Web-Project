package org.example.heritagebackend.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Setter
@Getter
public class orderItems {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_item_id_seq")
    @SequenceGenerator(name = "order_item_id_seq",sequenceName = "order_item_seq", allocationSize = 1)
    private Long orderItemId;


    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private Double unitPrice;


    @ManyToOne
    @JoinColumn(name = "orderId", referencedColumnName = "orderId", foreignKey = @ForeignKey(name = "fk_order_id"))
    private orders order;

    @ManyToOne
    @JoinColumn(name = "productId", referencedColumnName = "productId", foreignKey = @ForeignKey(name = "fk_product_id"))
    private products product;
}
