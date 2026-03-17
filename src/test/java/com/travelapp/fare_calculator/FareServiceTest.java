package com.travelapp.fare_calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FareServiceTest {

    // Instantiate the service we want to test
    private final FareService fareService = new FareService();

    @Test
    void testStandardFareCalculation() {
        // 1. Arrange: Set up our test data
        FareRequest request = new FareRequest();
        request.setOrigin("New York");
        request.setDestination("Boston");
        request.setDistanceInKm(350.0);
        request.setPeakSeason(false);

        // 2. Act: Run the method
        FareResponse response = fareService.calculateFare(request);

        // 3. Assert: Verify the results
        // Base (50) + Distance (350 * 0.15 = 52.5) = 102.5
        assertEquals(102.50, response.getEstimatedFare(), "Standard fare calculation failed");
        assertEquals("New York to Boston", response.getRoute());
    }

    @Test
    void testPeakSeasonSurgePricing() {
        FareRequest request = new FareRequest();
        request.setOrigin("London");
        request.setDestination("Paris");
        request.setDistanceInKm(470.0);
        request.setPeakSeason(true); // Peak season is ON

        FareResponse response = fareService.calculateFare(request);

        // Base (50) + Distance (470 * 0.15 = 70.5) = 120.5
        // Peak Multiplier: 120.5 * 1.25 = 150.625 (Rounds to 150.63)
        assertEquals(150.63, response.getEstimatedFare(), "Peak season surge calculation failed");
    }

    @Test
    void testZeroDistance() {
        FareRequest request = new FareRequest();
        request.setOrigin("Same City");
        request.setDestination("Same City");
        request.setDistanceInKm(0.0);
        request.setPeakSeason(false);

        FareResponse response = fareService.calculateFare(request);

        // Should just be the base fare of 50.0
        assertEquals(50.00, response.getEstimatedFare(), "Zero distance calculation failed");
    }
}