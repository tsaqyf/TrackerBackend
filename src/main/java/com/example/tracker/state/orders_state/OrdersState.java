package com.example.tracker.state.orders_state;

import com.example.tracker.entity.Orders;
import com.example.tracker.entity.OrdersEnum;

public interface OrdersState {
    void next(Orders orders);
    OrdersEnum getStatus();
}
