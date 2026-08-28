package com.example.tracker.state;

import com.example.tracker.entity.ConfirmationEvent;
import com.example.tracker.entity.Orders;
import com.example.tracker.entity.OrdersEnum;
import com.example.tracker.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.state.State;
import org.springframework.statemachine.support.StateMachineInterceptorAdapter;
import org.springframework.statemachine.transition.Transition;
import org.springframework.stereotype.Component;

@Component
public class OrdersStateMachineInterceptor extends StateMachineInterceptorAdapter<OrdersEnum, ConfirmationEvent> {
    @Autowired
    private OrdersRepository ordersRepository;
    public static final String HEADER_PONUMBER = "HEADER_PONUMBER";

    @Override
    public void preStateChange(
        State<OrdersEnum, ConfirmationEvent> state,
        Message<ConfirmationEvent> message,
        Transition<OrdersEnum, ConfirmationEvent> transition,
        StateMachine<OrdersEnum, ConfirmationEvent> stateMachine,
        StateMachine<OrdersEnum, ConfirmationEvent> rootStateMachine
    ){
        if (message != null && message.getHeaders().containsKey(HEADER_PONUMBER)){
            String poNumber = message.getHeaders().get(HEADER_PONUMBER, String.class);
            Orders orders = ordersRepository.findByPoNumber(HEADER_PONUMBER)
                    .orElseThrow(() -> new IllegalArgumentException("Orders Not Found"));
            orders.setCurrentStage(state.getId());

            ordersRepository.save(orders);
        }
    }
}
