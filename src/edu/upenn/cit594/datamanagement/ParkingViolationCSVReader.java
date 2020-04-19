package edu.upenn.cit594.datamanagement;

import edu.upenn.cit594.data.ParkingViolation;

import java.util.Collection;
import java.util.List;

public class ParkingViolationCSVReader implements ParkingViolationReader{

    private String filename;

    public ParkingViolationCSVReader(String filename){
        this.filename = filename;
    }


    @Override
    public List<ParkingViolation> readParkingViolations() {
        return null;
    }

    @Override
    public void logTimeAndFileName() {

    }
}
