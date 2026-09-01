package com.example.tracker.builder;

import com.example.tracker.dto.ProductionStep;
import com.example.tracker.entity.OrdersRoute;
import com.example.tracker.entity.OrdersRouteEnum;

import java.util.ArrayList;
import java.util.List;

public class OrdersRouteBuilder {
    public static final String Station_Testing = "ST-TEST";

    private final List<OrdersRoute> routes = new ArrayList<>();
    private int sequence = 1;

    public OrdersRouteBuilder addProduction(List<ProductionStep> list){
        for (ProductionStep step : list){
            routes.add(new OrdersRoute(sequence++, OrdersRouteEnum.PRODUCTION,step.getStationsCode()));
        }
        return this;
    }

    public OrdersRouteBuilder addTrial(){
        routes.add(new OrdersRoute(sequence++, OrdersRouteEnum.TRIAL,Station_Testing));
        return this;
    }

    public OrdersRouteBuilder addFinished(){
        routes.add(new OrdersRoute(sequence++, OrdersRouteEnum.FINISHED,null));
        return this;
    }

    public List<OrdersRoute> build(){
        return routes;
    }

    public static List<OrdersRoute> buildFullRoute(List<ProductionStep> productionSteps){
        return new OrdersRouteBuilder()
                .addProduction(productionSteps)
                .addTrial()
                .addFinished()
                .build();
    }
}
