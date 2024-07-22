package org.example.heritagebackend.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payments_pojo {
    private Long paymentId;
    private Date paymentDate;
    private Double paymentAmount;
    private String paymentMethod;
    private  Long orderId;
}
