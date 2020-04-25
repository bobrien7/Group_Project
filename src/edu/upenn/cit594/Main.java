package edu.upenn.cit594;

import edu.upenn.cit594.datamanagement.ParkingViolationCSVReader;
import edu.upenn.cit594.datamanagement.PopulationDataReader;
import edu.upenn.cit594.datamanagement.PropertyValueCSVReader;
import edu.upenn.cit594.processor.Processor;
import edu.upenn.cit594.ui.UserInterface;

public class Main {

    public static String loggerFileName;

    public static void main(String[] args){

        String parkingFileName = "parking.csv";
        String populationFileName = "population.txt";
        String propertyFileName = "properties.csv";
        loggerFileName = "logger.txt";
        System.out.println(Main.loggerFileName);

        //First thing we should do is log the current time and the runtime arguments 

        ParkingViolationCSVReader parkingFileReader = new ParkingViolationCSVReader(parkingFileName);

        PopulationDataReader populationReader = new PopulationDataReader(populationFileName);

        PropertyValueCSVReader propertyReader = new PropertyValueCSVReader(propertyFileName);

        Processor processor = new Processor(parkingFileReader, populationReader, propertyReader);

        UserInterface ui = new UserInterface(processor);

        ui.start();

    }



}
