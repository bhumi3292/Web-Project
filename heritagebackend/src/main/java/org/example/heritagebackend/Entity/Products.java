package org.example.heritagebackend.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Setter
@Getter
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "products_id_seq")
    @SequenceGenerator(name = "products_id_seq", sequenceName = "products_seq", allocationSize = 1)
    private Long productId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Integer stockQuantity;

    @Column(nullable = false)
    private boolean availability;

    @Lob
    private byte[] image;

    @ManyToOne
    @JoinColumn(name = "categoryId", referencedColumnName = "categoryId", foreignKey = @ForeignKey(name = "fk_categoryId"))
    private Categories categories;
}
