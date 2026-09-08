package com.example.tracker.service;

import com.example.tracker.builder.OrdersBuilder;
import com.example.tracker.builder.OrdersBuilderInterface;
import com.example.tracker.builder.OrdersRouteBuilder;
import com.example.tracker.dto.CreateOrdersRequest;
import com.example.tracker.entity.Orders;
import com.example.tracker.entity.OrdersRoute;
import com.example.tracker.repository.OrdersRepository;
import com.example.tracker.repository.OrdersRouteRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrdersService {
    public static final String Stations_Admin = "ST_ADM";

    private final OrdersRepository ordersRepository;
    private final OrdersRouteRepository ordersRouteRepository;

    @Transactional
    public Orders CreateOrders (CreateOrdersRequest request){
        OrdersBuilderInterface ordersBuilder = new OrdersBuilder();
        List<OrdersRoute> routes = OrdersRouteBuilder.buildFullRoute(request.getProductionSteps());
        Orders orders = ordersBuilder.buildPoNumber(request)
                .buildClientName(request)
                .buildClientCompany(request)
                .buildPhase()
                .buildRoute(request, routes)
                .buildFullOrders();
        return ordersRepository.save(orders);
    }

}
