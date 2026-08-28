package com.example.tracker.controller;

import com.example.tracker.dto.OrdersNextStepRequest;
import com.example.tracker.services.OrdersVerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/next_orders")
public class ChangeStateOrdersController {
    @Autowired
    private OrdersVerificationService verificationService;

    @PostMapping("/verify_station_code")
    public ResponseEntity<String> verifyStationCode(@RequestBody OrdersNextStepRequest nextStepRequest){
        boolean isSuccess = verificationService.verifyStations(nextStepRequest);

        if (isSuccess) {
            return ResponseEntity.ok("VERIFIED.");
        } else {
            return ResponseEntity.badRequest().body("DENIED");
        }
    }
}
