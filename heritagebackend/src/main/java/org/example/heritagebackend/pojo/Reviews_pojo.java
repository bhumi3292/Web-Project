package org.example.heritagebackend.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//import org.example.heritagebackend.Entity.customers;
//import org.example.heritagebackend.Entity.products;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reviews_pojo {
    private Long reviewId;
    private Integer rating;
    private String comment;
    private Date reviewDate;
//    private products product;
//    private customers customer;
}
