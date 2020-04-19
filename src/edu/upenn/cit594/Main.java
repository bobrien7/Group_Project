package edu.upenn.cit594;

import edu.upenn.cit594.datamanagement.ParkingViolationCSVReader;
import edu.upenn.cit594.datamanagement.PopulationDataReader;
import edu.upenn.cit594.datamanagement.PropertyValueCSVReader;

public class Main {

    public static String loggerFileName;

    public static void main(String[] args){

        String parkingFileName = "parking.csv";
        String populationFileName = "population.txt";
        String propertyFileName = "properties.csv";

        ParkingViolationCSVReader parkingFileReader = new ParkingViolationCSVReader(parkingFileName);

        PopulationDataReader populationReader = new PopulationDataReader(populationFileName);

        PropertyValueCSVReader propertyReader = new PropertyValueCSVReader(propertyFileName);





    }



}
