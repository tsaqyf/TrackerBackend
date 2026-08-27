package com.example.tracker.state.orders_state;

import com.example.tracker.entity.ConfirmationEvent;
import com.example.tracker.entity.Orders;
import com.example.tracker.entity.OrdersEnum;
import com.example.tracker.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachineFactory;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.guard.Guard;

import java.util.EnumSet;

@Configuration
@EnableStateMachineFactory
public class OrdersStateMachineConfig extends StateMachineConfigurerAdapter<OrdersEnum, ConfirmationEvent> {
    @Autowired
    private OrdersRepository ordersRepository;

    public static final String HEADER_PONUMBER = "HEADER_PONUMBER";
    public static final String HEADER_CODE = "HEADER_CODEE";

    @Override
    public void configure(StateMachineStateConfigurer<OrdersEnum,ConfirmationEvent> States) throws Exception{
        States
                .withStates()
                .initial(OrdersEnum.ORDERS)
                .states(EnumSet.allOf(OrdersEnum.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<OrdersEnum, ConfirmationEvent> Transaction) throws Exception{
        Transaction
                .withExternal()
                .source(OrdersEnum.ORDERS)
                .target(OrdersEnum.SCHEDULE)
                .event(ConfirmationEvent.VERIFY_STATIONS)
                .guard(confimFunction());
    }

    private Guard<OrdersEnum, ConfirmationEvent> confimFunction() {
        return stateContext -> {
            String poNumber = stateContext.getMessageHeaders().get(HEADER_PONUMBER,String.class);
            String code = stateContext.getMessageHeaders().get(HEADER_CODE,String.class);

            if(poNumber == null || code == null){
                return false;
            }

            Orders orders = ordersRepository.findByPoNumber(poNumber).orElse(null);
            if (orders == null){
                return false;
            }

            boolean isMatched;
            if (code.equals(orders.getStationsId().getCode())) isMatched = true;
            else isMatched = false;

            return isMatched;
        };
    }
}
