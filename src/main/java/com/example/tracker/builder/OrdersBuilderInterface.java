package com.example.tracker.builder;

import com.example.tracker.dto.CreateOrdersRequest;
import com.example.tracker.entity.Orders;
import com.example.tracker.entity.OrdersRoute;

import java.util.List;

public interface OrdersBuilderInterface {
    OrdersBuilderInterface buildPoNumber(CreateOrdersRequest request);
    OrdersBuilderInterface buildClientName(CreateOrdersRequest request);
    OrdersBuilderInterface buildClientCompany(CreateOrdersRequest request);
    OrdersBuilderInterface buildPhase();
    OrdersBuilderInterface buildRoute(CreateOrdersRequest request, List<OrdersRoute> routes);

    Orders buildFullOrders();
}
