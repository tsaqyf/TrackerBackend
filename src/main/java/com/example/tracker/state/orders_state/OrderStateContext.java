package com.example.tracker.state.orders_state;

import com.example.tracker.entity.OrdersEnum;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class OrderStateContext {
    private final Map<OrdersEnum, OrdersState> stateMap;

    public OrderStateContext(List<OrdersState> states){
        this.stateMap = states.stream().collect(Collectors.toMap(OrdersState::getStatus, Function.identity()));
    }


}
