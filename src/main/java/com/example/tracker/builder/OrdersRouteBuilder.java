package com.example.tracker.builder;

import com.example.tracker.dto.ProductionStep;
import com.example.tracker.entity.OrdersRoute;
import com.example.tracker.entity.OrdersRouteEnum;
import com.example.tracker.entity.Stations;
import com.example.tracker.repository.StationsRepository;

import java.util.ArrayList;
import java.util.List;

public class OrdersRouteBuilder {
    public static final String Station_Testing = "ST-TEST";

    private final List<OrdersRoute> routes = new ArrayList<>();
    private int sequence = 1;

    private StationsRepository stationsRepository;

    public OrdersRouteBuilder addProduction(List<Stations> list){
        for (Stations step : list){
            routes.add(new OrdersRoute(sequence++, OrdersRouteEnum.PRODUCTION,step));
        }
        return this;
    }

    public OrdersRouteBuilder addTrial(Stations QcStations){
        routes.add(new OrdersRoute(sequence++, OrdersRouteEnum.TRIAL,QcStations));
        return this;
    }

    public OrdersRouteBuilder addFinished(){
        routes.add(new OrdersRoute(sequence++, OrdersRouteEnum.FINISHED,null));
        return this;
    }

    public List<OrdersRoute> build(){
        return routes;
    }
}
