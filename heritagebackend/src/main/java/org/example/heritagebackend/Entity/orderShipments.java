package org.example.heritagebackend.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Entity
@Table
@Setter
@Getter
public class orderShipments {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_shipments_id_seq")
    @SequenceGenerator(name = "order_shipments_id_seq", sequenceName = "order_shipments_seq", allocationSize = 1)
    private Long orderShipmentId;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date shipmentDate;

    @Column(nullable = false)
    private String shipmentStatus;

//    @OneToOne
//    @JoinColumn(name = "order_id", referencedColumnName = "orderId", foreignKey = @ForeignKey(name = "fk_order_id"))
//    private Orders order; // Added reference to orders entit
}
