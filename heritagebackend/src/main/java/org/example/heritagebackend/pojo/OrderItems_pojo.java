package org.example.heritagebackend.pojo;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.heritagebackend.Entity.Orders;
import org.example.heritagebackend.Entity.Products;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItems_pojo {
    private Long orderItemId;
    private Integer quantity;
    private Double unitPrice;
    private Long orderId;
    private Long productId;
}
