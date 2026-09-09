package com.example.tracker.builder;

import com.example.tracker.dto.CreateOrdersRequest;
import com.example.tracker.entity.Orders;
import com.example.tracker.entity.OrdersPhaseEnum;
import com.example.tracker.entity.OrdersRoute;

import java.util.List;

public class OrdersBuilder{
    private final Orders orders = new Orders();


    public OrdersBuilder buildPoNumber(CreateOrdersRequest request){
        orders.setPoNumber(request.getPoNumber());
        return this;
    }
    public OrdersBuilder buildClientName(CreateOrdersRequest request){
        orders.setPoNumber(request.getClientName());
        return this;
    }
    public OrdersBuilder buildClientCompany(CreateOrdersRequest request){
        orders.setPoNumber(request.getClientCompany());
        return this;
    }

    public OrdersBuilder buildPhase(){
        orders.setCurrentPhase(OrdersPhaseEnum.IN_ROUTE);
        return this;
    }
    public OrdersBuilder buildRoute(List<OrdersRoute> routes){
        routes.forEach(orders::addRouteStep);
        return this;
    }
    public Orders buildFullOrders(){
        return orders;
    }
}
