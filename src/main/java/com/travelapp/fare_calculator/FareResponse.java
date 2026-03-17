package com.travelapp.fare_calculator;

public class FareResponse {
    private String route;
    private double estimatedFare;
    private String currency;

    public FareResponse(String route, double estimatedFare, String currency) {
        this.route = route;
        this.estimatedFare = estimatedFare;
        this.currency = currency;
    }

    // Getters
    public String getRoute() { return route; }
    public double getEstimatedFare() { return estimatedFare; }
    public String getCurrency() { return currency; }
}