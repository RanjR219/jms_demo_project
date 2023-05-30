package com.orderProcessingSystem.orderAcknowledgement.controller;

import com.orderProcessingSystem.orderAcknowledgement.exception.ApplicationException;
import com.orderProcessingSystem.orderAcknowledgement.model.Order;
import com.orderProcessingSystem.orderAcknowledgement.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.NamingException;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping(value="/orders")
    public ResponseEntity<String> placeOrder(@Valid @RequestBody Order order) throws NamingException, ApplicationException {
        orderService.processOrder(order);
        String successMessage = "INSERT_SUCCESS ";
        return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
    }

}
