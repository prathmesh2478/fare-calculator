package com.travelapp.fare_calculator;

import org.springframework.stereotype.Service;

@Service // This tells Spring Boot to manage this class
public class FareService {

    private static final double BASE_FARE = 50.00;
    private static final double RATE_PER_KM = 0.15;
    private static final double PEAK_MULTIPLIER = 1.25;

    public FareResponse calculateFare(FareRequest request) {
        // 1. Calculate the raw distance cost
        double distanceCost = request.getDistanceInKm() * RATE_PER_KM;

        // 2. Add the base fare
        double totalFare = BASE_FARE + distanceCost;

        // 3. Apply peak season surge pricing if applicable
        if (request.isPeakSeason()) {
            totalFare = totalFare * PEAK_MULTIPLIER
        }

        // 4. Format the route name nicely
        String routeName = request.getOrigin() + " to " + request.getDestination();

        // 5. Return the final packaged response
        return new FareResponse(routeName, Math.round(totalFare * 100.0) / 100.0, "USD");
    }
}