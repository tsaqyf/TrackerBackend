package com.example.tracker.state.orders_state;

import com.example.tracker.entity.Orders;
import com.example.tracker.entity.OrdersEnum;

public class PoOrdersState implements OrdersState{
    @Override
    public void next(Orders orders) {

    }

    @Override
    public OrdersEnum getStatus() {
        return OrdersEnum.ORDERS;
    }
}
