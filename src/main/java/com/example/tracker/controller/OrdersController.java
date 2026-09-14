package com.example.tracker.controller;

import com.example.tracker.dto.ActiveStepViewResponse;
import com.example.tracker.dto.CreateOrdersRequest;
import com.example.tracker.entity.Orders;
import com.example.tracker.entity.OrdersRoute;
import com.example.tracker.service.OrdersService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    @PatchMapping("/{ordersId}/ordersRoute/{ordersRouteId}/complete")
    public ResponseEntity<OrdersRoute> completeRoute(
            @PathVariable UUID ordersId,
            @PathVariable UUID ordersRouteId,
            @RequestHeader("X-Station-Code") String stationsCode,
            @RequestHeader("X-Users-Id") UUID usersId
    ){
        OrdersRoute ordersRoute = ordersService.FinishRoute(ordersId,ordersRouteId,stationsCode,usersId);
        return ResponseEntity.ok(ordersRoute);
    }

    @PatchMapping("/{ordersId}/cancel")
    public ResponseEntity<Void> cancel(
            @PathVariable UUID ordersId,
            @RequestHeader("X-Station-Code") String stationsCode
    ){
        ordersService.cancelRoute(ordersId,stationsCode);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/ordersRoute/active")
    public ResponseEntity<List<ActiveStepViewResponse>> getActiveViewStations(
            @RequestHeader("X-Stations-Code") String stationsCode
    ){
        return ResponseEntity.ok(ordersService.getActiveSteps(stationsCode));
    }
}
