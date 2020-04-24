package edu.upenn.cit594.data;

public class TotalLivableAreaDataGrabber implements PropertyDataAverager {
    @Override
    public double getPropertyDataOfInterest(Property p1) {
        return p1.getTotalLivableArea();
    }
}
