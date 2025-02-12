package org.example.heritagebackend.pojo;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderShipments_pojo {
    private Long orderShipmentId;
    private Date shipmentDate;
    private String shipmentStatus;
}
