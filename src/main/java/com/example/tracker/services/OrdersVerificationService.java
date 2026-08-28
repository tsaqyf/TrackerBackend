package com.example.tracker.services;

import com.example.tracker.dto.OrdersNextStepRequest;
import com.example.tracker.entity.ConfirmationEvent;
import com.example.tracker.entity.Orders;
import com.example.tracker.entity.OrdersEnum;
import com.example.tracker.repository.OrdersRepository;
import com.example.tracker.state.OrdersStateMachineConfig;
import com.example.tracker.state.OrdersStateMachineInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.StateMachineEventResult;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.statemachine.support.DefaultStateMachineContext;
import reactor.core.publisher.Mono;

public class OrdersVerificationService {
    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private StateMachineFactory<OrdersEnum, ConfirmationEvent> factory;

    @Autowired
    private OrdersStateMachineInterceptor interceptor;

    public boolean verifyStations(OrdersNextStepRequest nextStepRequest){
        Orders orders = ordersRepository.findByPoNumber(nextStepRequest.getPoNumber())
                .orElseThrow(() -> new IllegalArgumentException("Orders Not Found"));
        StateMachine<OrdersEnum, ConfirmationEvent> stateMachine = buildStateMachine(orders);

        var message = MessageBuilder.withPayload(ConfirmationEvent.VERIFY_STATIONS)
                .setHeader(OrdersStateMachineInterceptor.HEADER_PONUMBER, nextStepRequest.getPoNumber())
                .setHeader(OrdersStateMachineConfig.HEADER_CODE, nextStepRequest.getCode())
                .build();
        StateMachineEventResult<OrdersEnum, ConfirmationEvent> result = stateMachine
                .sendEvent(Mono.just(message))
                .blockLast();
        return result != null && result.getResultType() == StateMachineEventResult.ResultType.ACCEPTED;
    }

    private StateMachine<OrdersEnum, ConfirmationEvent> buildStateMachine(Orders orders) {
        StateMachine<OrdersEnum, ConfirmationEvent> stateMachine = factory.getStateMachine(orders.getPoNumber());
        stateMachine.stopReactively().block();
        stateMachine.getStateMachineAccessor().doWithAllRegions(stateMachines -> {
            stateMachines.addStateMachineInterceptor(interceptor);
            stateMachines.resetStateMachineReactively(new DefaultStateMachineContext<>(orders.getCurrentStage(), null, null, null))
                    .block();
        });
        stateMachine.startReactively().block();
        return stateMachine;
    }
}
