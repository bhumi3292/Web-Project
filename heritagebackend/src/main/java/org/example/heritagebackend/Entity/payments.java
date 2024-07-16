package org.example.heritagebackend.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Entity
@Table
@Setter
@Getter
public class payments {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_id_seq")
    @SequenceGenerator(name = "payment_id_seq", sequenceName = "payment_seq", allocationSize = 1)
    private Long paymentId;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date paymentDate;

    @Column(nullable = false)
    private Double paymentAmount;

    @Column(nullable = false)
    private String paymentMethod;

    @OneToOne
    @JoinColumn(name = "order_id", referencedColumnName = "orderId", foreignKey = @ForeignKey(name = "fk_order_id"))
    private orders order; 
}
