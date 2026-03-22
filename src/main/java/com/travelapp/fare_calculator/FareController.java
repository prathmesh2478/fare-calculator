package com.travelapp.fare_calculator;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/fares")
public class FareController {

    private final FareService fareService

    // Spring automatically injects the FareService here
    public FareController(FareService fareService) {
        this.fareService = fareService;
    }

    @PostMapping("/estimate")
    public FareResponse getFareEstimate(@RequestBody FareRequest request) {
        // We receive the JSON request, hand it to our Service layer, and return the result
        return fareService.calculateFare(request);
    }
}