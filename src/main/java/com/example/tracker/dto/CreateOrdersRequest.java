package com.example.tracker.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateOrdersRequest {
    private String poNumber;
    private String clientName;
    private String clientCompany;
    private List<ProductionStep> productionSteps;
}
