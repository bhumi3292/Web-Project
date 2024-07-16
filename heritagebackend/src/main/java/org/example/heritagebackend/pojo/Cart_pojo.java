package org.example.heritagebackend.pojo;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.heritagebackend.Entity.customers;

@Getter
@Setter
@AllArgsConstructor
public class Cart_pojo {
    private int cartId;
    private customers customer;


}
