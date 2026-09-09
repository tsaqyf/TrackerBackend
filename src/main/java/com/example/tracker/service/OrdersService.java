package com.example.tracker.service;

import com.example.tracker.builder.OrdersBuilder;
import com.example.tracker.builder.OrdersRouteBuilder;
import com.example.tracker.dto.CreateOrdersRequest;
import com.example.tracker.dto.ProductionStep;
import com.example.tracker.entity.Orders;
import com.example.tracker.entity.OrdersRoute;
import com.example.tracker.entity.Stations;
import com.example.tracker.repository.OrdersRepository;
import com.example.tracker.repository.OrdersRouteRepository;
import com.example.tracker.repository.StationsRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrdersService {
    public static final String Stations_Admin = "ST_ADM";
    public static final String Stations_QC = "ST_QC";

    private final OrdersRepository ordersRepository;
    private final OrdersRouteRepository ordersRouteRepository;
    private final StationsRepository stationsRepository;

    @Transactional
    public Orders CreateOrders (CreateOrdersRequest request){
        List<String> requestStationsCode = request.getProductionSteps()
                .stream()
                .map(ProductionStep::getStationsCode)
                .toList();
        Map<String, Stations> StationsCode = stationsRepository.findAllByCodeIn(requestStationsCode)
                .stream()
                .collect(Collectors.toMap(Stations::getCode, s -> s));
        //add validate
        List<Stations> orderedStations = request.getProductionSteps()
                .stream()
                .map(input -> StationsCode.get(input.getStationsCode()))
                .toList();
        Stations qcStations = stationsRepository.findByCode(Stations_QC).orElseThrow();
        List<OrdersRoute> routes = new OrdersRouteBuilder()
                .addProduction(orderedStations)
                .addTrial(qcStations)
                .addFinished()
                .build();
        Orders orders = new OrdersBuilder().buildPoNumber(request)
                .buildClientName(request)
                .buildClientCompany(request)
                .buildPhase()
                .buildRoute(request, routes)
                .buildFullOrders();
        return ordersRepository.save(orders);
    }

    @Transactional
    public OrdersRoute StartRoute(){

        return null;
    }
}
