package com.example.tracker.controller;

import com.example.tracker.dto.CreateOrdersRequest;
import com.example.tracker.entity.Orders;
import com.example.tracker.service.OrdersService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrdersController {
    private final OrdersService ordersService;
    @PostMapping
    public ResponseEntity<Orders> createOrders(@Valid @RequestBody CreateOrdersRequest request){
        Orders orders = ordersService.CreateOrders(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(orders);
    }

}
