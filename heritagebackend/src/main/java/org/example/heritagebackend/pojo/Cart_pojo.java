package org.example.heritagebackend.pojo;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.heritagebackend.Entity.Customers;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cart_pojo {
    private Long cartId;
    private Long customerId;


}
