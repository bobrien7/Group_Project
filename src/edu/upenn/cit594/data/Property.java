package edu.upenn.cit594.data;

public class Property {

    private double marketValue;
    private int zipCode;
    private int totalLivableArea;

    public Property(double marketValue, int zipCode, int totalLivableArea){

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

    public int getTotalLivableArea() {
        return totalLivableArea;
    }
}
