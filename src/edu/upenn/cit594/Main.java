package edu.upenn.cit594;

import edu.upenn.cit594.data.FileAuthenticator;
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

        int numberOfArguments = args.length;

        if (numberOfArguments != 5) {

            System.out.println("Error Occurred: Terminating Program");
            System.exit(0);
        }

        parkingFileFormat = args[0];         //"parking.csv";
        parkingFileName = args[1];
        propertyFileName = args[2];
        populationFileName = args[3];
        loggerFileName = args[4];

        FileAuthenticator fileAuthenticator = new FileAuthenticator(parkingFileFormat, parkingFileName, propertyFileName, populationFileName, loggerFileName);
        Boolean fileCheckIndicator = fileAuthenticator.authenticate();

        if (!fileCheckIndicator) {

            System.out.println("Error Occurred: Terminating Program");

        } else {

            ParkingViolationReader parkingViolationReader;

            if (parkingFileFormat.equalsIgnoreCase("CSV")) {

                parkingViolationReader = new ParkingViolationCSVReader(parkingFileName);

            } else {

                parkingViolationReader = new ParkingViolationJSONReader(parkingFileName);

            }

            PopulationDataReader populationReader = new PopulationDataReader(populationFileName);
            PropertyValueCSVReader propertyReader = new PropertyValueCSVReader(propertyFileName);

            Logger.getInstance().log(Main.parkingFileFormat + " " + Main.parkingFileName + " " + Main.propertyFileName + " " + Main.populationFileName + " " + Main.loggerFileName);
            //First thing we should do is log the current time and the runtime arguments

            Processor processor = new Processor(parkingViolationReader, populationReader, propertyReader);

            UserInterface ui = new UserInterface(processor);

            ui.start();

        }

    }

}
