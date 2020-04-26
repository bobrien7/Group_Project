package edu.upenn.cit594.data;

public class MarketValueDataGrabber implements PropertyDataAverager {  //This class is a part of the strategy design pattern for calculating average value of Market Value for a list of properties


    @Override
    public double getPropertyDataOfInterest(Property p1) {

        return p1.getMarketValue();
    }
}
