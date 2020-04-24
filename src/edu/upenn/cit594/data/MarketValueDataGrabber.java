package edu.upenn.cit594.data;

public class MarketValueDataGrabber implements PropertyDataAverager {


    @Override
    public double getPropertyDataOfInterest(Property p1) {

        return p1.getMarketValue();
    }
}
