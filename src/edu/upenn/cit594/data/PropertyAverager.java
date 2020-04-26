package edu.upenn.cit594.data;

import java.util.ArrayList;

public class PropertyAverager {  //This interface was created as a part of the strategy design pattern for calculating an average value of a given properties parameter

    public double getAverageValue(ArrayList<Property> properties, PropertyDataAverager theAverager) {

        double sum = 0;
        double count = 0;
        for (Property theProperty : properties) {

            double thisAdd = theAverager.getPropertyDataOfInterest(theProperty);

            sum = sum + thisAdd;
            count = count + 1;
        }

        if (sum == 0 || count == 0) {
            return 0;
        }
        return sum / count;
    }
}
