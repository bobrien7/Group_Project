package edu.upenn.cit594.datamanagement;

import edu.upenn.cit594.data.ParkingViolation;
import edu.upenn.cit594.logging.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class ParkingViolationCSVReader implements ParkingViolationReader{ //

    private String filename;

    public ParkingViolationCSVReader(String filename){
        this.filename = filename;
    }


    @Override
    public ArrayList<ParkingViolation> readParkingViolations() {  //this method will return an ArrayList of ParkingViolation objects that are read in from a .csv file
        ArrayList<ParkingViolation> parkingViolation = new ArrayList<ParkingViolation>();
        int counter = 0;
        try {
            Scanner scanner = new Scanner(new File(filename));
            Logger.getInstance().log(filename);

            while (scanner.hasNextLine()) {

                String violation = scanner.nextLine();
                String[] violationData = violation.split(",");
                String timestamp = violationData[0];
                double fineAmount = Double.parseDouble(violationData[1]);
                String violationDescription = violationData[2];
                int vehicleID = Integer.parseInt(violationData[3]);
                String vehicleState = violationData[4];
                int violationNumber = Integer.parseInt(violationData[5]);
                if (violationData.length < 7) {
                    //do nothing
                } else {
                    int violationZipCode = Integer.parseInt(violationData[6]);


                    parkingViolation.add(new ParkingViolation(timestamp, fineAmount, violationDescription, vehicleID, vehicleState, violationNumber, violationZipCode));  //add the ParkingViolation to the ArrayList
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }

        for(ParkingViolation pv : parkingViolation){ // for testing
            counter++;

        }

        return parkingViolation;
    }




}
