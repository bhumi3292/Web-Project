package org.example.heritagebackend.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Entity
@Table
@Setter
@Getter
public class reviews {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reviews_id_seq")
    @SequenceGenerator(name = "reviews_id_seq",sequenceName = "reviews_seq", allocationSize = 1)
    private Long reviewId;

    @Column(nullable = false)
    private Integer rating;

    @Column(nullable = true)
    private String comment;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date reviewDate;
//
//    @ManyToOne
//    @JoinColumn(name = "productId", referencedColumnName = "productId", foreignKey = @ForeignKey(name = "fk_product_id"))
//    private products product;
//
//    @ManyToOne
//    @JoinColumn(name = "customerId", referencedColumnName = "customerId", foreignKey = @ForeignKey(name = "fk_customer_id"))
//    private customers customer;
}
