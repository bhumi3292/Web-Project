package org.example.heritagebackend.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.heritagebackend.Entity.products;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Categories_pojo {
    private Long categoryId;
    private String categoryName;
    private products product;
}
