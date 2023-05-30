package com.orderProcessingSystem.orderAcknowledgement.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
@Data
public class Order implements Serializable {
    @Id
    private int id;
    private String customerName;
    @Email(message = "Should be in email format")
    @NotNull(message = "Email should not be null")
    private String emailId;
    private String shippingAddress;
    private List<OrderItem> orderItems;
    private Integer totalAmount;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate orderDate;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

}