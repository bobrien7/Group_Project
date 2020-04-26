package edu.upenn.cit594.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileAuthenticator { //This class was created to verify that the input files passed to the program can be opened and read

    String parkingFileFormat;
    String parkingFileName;
    String propertyFileName;
    String populationFileName;
    String loggerFileName;
    int numberOfArguments;

    public FileAuthenticator(String parkingFileFormat, String parkingFileName, String propertyFileName, String populationFileName, String loggerFileName) {

        this.parkingFileFormat = parkingFileFormat;
        this.parkingFileName = parkingFileName;
        this.propertyFileName = propertyFileName;
        this.populationFileName = populationFileName;
        this.loggerFileName = loggerFileName;

    }

    public boolean authenticate() { //This method returns true if the input files are valid according to the project spec

        //this method will do all the checks to check the input files

        parkingFileFormat = parkingFileFormat.toUpperCase();

        if (parkingFileFormat.equals("CSV") || parkingFileFormat.equals("JSON")) {

            //do nothing
        } else {  //if this else statement is entered, that means file format wasn't text or json
            return false;
        }

        File parkingFile = new File(parkingFileName);
        File propertyFile = new File(propertyFileName);
        File populationFile = new File(populationFileName);

        if (!parkingFile.exists() || !propertyFile.exists() || !populationFile.exists()) {
            System.out.println("One of the given files doesn't exist");
            return false;
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader(parkingFile));
        } catch (FileNotFoundException e) {

            System.out.println("Couldn't open parking file");
            return false;
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader(propertyFile));
        } catch (FileNotFoundException e) {

            System.out.println("Couldn't open properties file");
            return false;
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader(populationFile));
        } catch (FileNotFoundException e) {

            System.out.println("Couldn't open population file");
            return false;
        }


        return true;  //if the arguments check all of our tests... return true


    }


}
