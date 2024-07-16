package org.example.heritagebackend.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Setter
@Getter
public class categories {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Categories_id_seq")
    @SequenceGenerator(name = "Categories_id_seq",sequenceName = "Categories_seq", allocationSize = 1)
    private Long categoryId;

    @Column(nullable = false)
    private String categoryName;

    @ManyToOne
    @JoinColumn(name = "productId", referencedColumnName = "productId", foreignKey = @ForeignKey(name = "fk_product_id"))
    private products product;

}
