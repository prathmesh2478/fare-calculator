package com.travelapp.fare_calculator;

public class FareRequest {
    private String origin;
    private String destination;
    private double distanceInKm;
    private boolean isPeakSeason;

    // Getters and Setters
    public String getOrigin() { return origin; }
    public void setOrigin(String origin) { this.origin = origin; }

    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }

    public double getDistanceInKm() { return distanceInKm; }
    public void setDistanceInKm(double distanceInKm) { this.distanceInKm = distanceInKm; }

    public boolean isPeakSeason() { return isPeakSeason; }
    public void setPeakSeason(boolean peakSeason) { this.isPeakSeason = peakSeason; }
}