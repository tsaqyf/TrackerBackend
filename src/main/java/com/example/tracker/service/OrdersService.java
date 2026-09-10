package com.example.tracker.service;

import com.example.tracker.builder.OrdersBuilder;
import com.example.tracker.builder.OrdersRouteBuilder;
import com.example.tracker.dto.CreateOrdersRequest;
import com.example.tracker.dto.ProductionStep;
import com.example.tracker.entity.*;
import com.example.tracker.exception.ForbiddenException;
import com.example.tracker.exception.InvalidException;
import com.example.tracker.exception.NotFoundException;
import com.example.tracker.repository.OrdersRepository;
import com.example.tracker.repository.OrdersRouteRepository;
import com.example.tracker.repository.StationsRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;
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
        for (String code: requestStationsCode){
            if (!StationsCode.containsKey(code)){
                throw new NotFoundException("No Station Found with this code: " + code);
            }
        }
        List<Stations> orderedStations = request.getProductionSteps()
                .stream()
                .map(input -> StationsCode.get(input.getStationsCode()))
                .toList();
        Stations qcStations = stationsRepository
                .findByCode(Stations_QC)
                .orElseThrow(() -> new NotFoundException("QC Station Not Found"));
        List<OrdersRoute> routes = new OrdersRouteBuilder()
                .addProduction(orderedStations)
                .addTrial(qcStations)
                .addFinished()
                .build();
        Orders orders = new OrdersBuilder().buildPoNumber(request)
                .buildClientName(request)
                .buildClientCompany(request)
                .buildPhase()
                .buildRoute(routes)
                .buildFullOrders();
        return ordersRepository.save(orders);
    }

    @Transactional
    public OrdersRoute StartRoute(UUID OrdersId, UUID OrdersRouteId, String StationsCode, UUID usersId){

        return null;
    }

    @Transactional
    public OrdersRoute FinishRoute(UUID OrdersId, UUID OrdersRouteId, String StationsCode, UUID usersId){

        OrdersRoute step = ordersRouteRepository.findByOrdersId_IdAndId(OrdersId,OrdersRouteId).orElseThrow();
        return null;
    }

    @Transactional
    public void cancelRoute(UUID OrdersId, String UserStationsCode){
        Stations adminStations = stationsRepository
                .findByCode(Stations_Admin)
                .orElseThrow(() -> new NotFoundException("Admin Not Found"));

        if (!adminStations.getCode().equals(UserStationsCode)){
            throw new ForbiddenException("Don't have access to this function");
        }

        Orders orders = ordersRepository.findById(OrdersId)
                .orElseThrow(() -> new NotFoundException("Orders Not Found"));

        if (orders.getCurrentPhase() != OrdersPhaseEnum.IN_ROUTE){
            throw new InvalidException("Phase Either in Finished or Already Canceled");
        }

        orders.changePhase(OrdersPhaseEnum.CANCELLED);
        ordersRepository.save(orders);
        ordersRouteRepository.findByOrdersIdAndStepLabelNot(orders, OrdersStepEnum.DONE)
                .forEach(step -> step.ChangeStep(OrdersStepEnum.CANCELLED));
    }
}
