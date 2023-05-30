package com.orderProcessingSystem.orderAcknowledgement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderItem implements Serializable {
    @Id
    private int orderItemId;
    private Order order;
    private String productName;
    private Integer unitPrice;
    private Integer quantity;
    private Integer subtotal;
}
