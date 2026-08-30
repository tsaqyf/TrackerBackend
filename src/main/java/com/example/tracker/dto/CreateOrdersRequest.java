package com.example.tracker.dto;

import java.util.List;

public class CreateOrdersRequest {
    private String poNumber;
    private String clientName;
    private String clientCompany;
    private List<ProductionStep> productionSteps;
}
