package org.example.heritagebackend.pojo;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.heritagebackend.Entity.orders;
import org.example.heritagebackend.Entity.products;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItems_pojo {
    private Long orderItemId;
    private Integer quantity;
    private Double unitPrice;
    private orders order;
    private products product;
}
