package edu.upenn.cit594.datamanagement;

import edu.upenn.cit594.data.ParkingViolation;

import java.util.Collection;
import java.util.List;

public interface ParkingViolationReader {

    Collection<ParkingViolation> readParkingViolations();

}
