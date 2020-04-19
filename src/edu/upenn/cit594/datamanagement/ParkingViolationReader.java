package edu.upenn.cit594.datamanagement;

import edu.upenn.cit594.data.ParkingViolation;

import java.util.Collection;

public interface ParkingViolationReader {

    Collection<ParkingViolation> readParkingViolations();

    void logTimeAndFileName();

}
