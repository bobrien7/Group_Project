package edu.upenn.cit594.datamanagement;

import edu.upenn.cit594.data.ParkingViolation;

import java.util.ArrayList;
import java.util.Collection;

public interface ParkingViolationReader {

    ArrayList<ParkingViolation> readParkingViolations();

    void logTimeAndFileName();

}
