package edu.upenn.cit594.datamanagement;

import edu.upenn.cit594.data.ParkingViolation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class ParkingViolationCSVReader implements ParkingViolationReader{

    private String filename;

    public ParkingViolationCSVReader(String filename){
        this.filename = filename;
    }




    @Override
    public List<ParkingViolation> readParkingViolations() {
        ArrayList<ParkingViolation> parkingViolation = new ArrayList<ParkingViolation>();
        try {
            Scanner scanner = new Scanner(new File(filename));

            while(scanner.hasNextLine()) {

                String violation = scanner.nextLine();
                String[] violationData = violation.split(",");
                String timestamp = violationData[0];
                int fineAmount = Integer.parseInt(violationData[1]);
                String violationDescription = violationData[2];
                int vehicleID = Integer.parseInt(violationData[3]);
                String vehicleState = violationData[4];
                int violationNumber =Integer.parseInt(violationData[5]);
                int violationZipCode =Integer.parseInt(violationData[6]);

                parkingViolation.add(new ParkingViolation( timestamp, fineAmount, violationDescription, vehicleID, vehicleState, violationNumber, violationZipCode));
            }
            scanner.close();
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }
        for(ParkingViolation pv : parkingViolation){
            System.out.println(pv.getTimestamp());
        }

        return parkingViolation;
    }

    @Override
    public void logTimeAndFileName() {

    }
    public static void main(String[] args) {
        ParkingViolationCSVReader pvcsv = new ParkingViolationCSVReader("parking.csv");
        pvcsv.readParkingViolations();

    }


}
