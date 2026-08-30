package com.example.tracker.dto;

import com.example.tracker.entity.OrdersRouteEnum;
import com.example.tracker.entity.OrdersStepEnum;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ActiveStepViewResponse {
    private UUID ordersId;
    private String poNumbers;
    private String clientName;
    private UUID ordersRouteId;
    private OrdersRouteEnum routeLabel;
    private int sequence;
    private OrdersStepEnum stepLabel;
}
