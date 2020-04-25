package edu.upenn.cit594;

import edu.upenn.cit594.datamanagement.*;
import edu.upenn.cit594.logging.Logger;
import edu.upenn.cit594.processor.Processor;
import edu.upenn.cit594.ui.UserInterface;

public class Main {
    public static String parkingFileFormat;
    public static String parkingFileName;
    public static String propertyFileName;
    public static String populationFileName;
    public static String loggerFileName;

    public static void main(String[] args) {

        parkingFileFormat = args[0];         //"parking.csv";
        parkingFileName = args[1];
        propertyFileName = args[2];
        populationFileName = args[3];
        loggerFileName = args[4];

        Logger.getInstance().log(Main.parkingFileFormat + " " + Main.parkingFileName + " " + Main.propertyFileName + " " + Main.populationFileName + " " + Main.loggerFileName);
        //First thing we should do is log the current time and the runtime arguments 

        ParkingViolationCSVReader parkingFileReader = new ParkingViolationCSVReader(parkingFileName);

        PopulationDataReader populationReader = new PopulationDataReader(populationFileName);

        PropertyValueCSVReader propertyReader = new PropertyValueCSVReader(propertyFileName);

        Processor processor = new Processor(parkingFileReader, populationReader, propertyReader);

        UserInterface ui = new UserInterface(processor);

        ui.start();

    }



}
