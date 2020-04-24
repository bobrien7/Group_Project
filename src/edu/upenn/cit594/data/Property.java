package edu.upenn.cit594.data;

public class Property {

    private double marketValue;
    private int zipCode;
    private double totalLivableArea;

    public Property(double marketValue, int zipCode, double totalLivableArea) {

        this.marketValue = marketValue;
        this.zipCode = zipCode;
        this.totalLivableArea = totalLivableArea;
    }

    public double getMarketValue() {
        return marketValue;
    }

    public int getZipCode() {
        return zipCode;
    }

    public double getTotalLivableArea() {
        return totalLivableArea;
    }
}
