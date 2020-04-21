package edu.upenn.cit594.data;

public class ParkingViolation {

    private String timestamp;
    private double fineAmount;
    private String violationDescription;
    private int vehicleID;
    private String vehicleState;
    private int violationNumber;
    private int violationZipCode;

    public ParkingViolation(String timestamp, double fineAmount, String violationDescription, int vehicleID, String vehicleState,
                            int violationNumber, int violationZipCode){

        this.timestamp = timestamp;
        this.fineAmount = fineAmount;
        this.violationDescription = violationDescription;
        this.vehicleID = vehicleID;
        this.vehicleState = vehicleState;
        this.violationNumber = violationNumber;
        this.violationZipCode = violationZipCode;

    }


    public String getTimestamp() {
        return timestamp;
    }

    public double getFineAmount() {
        return fineAmount;
    }

    public String getViolationDescription() {
        return violationDescription;
    }

    public int getVehicleID() {
        return vehicleID;
    }

    public String getVehicleState() {
        return vehicleState;
    }

    public int getViolationNumber() {
        return violationNumber;
    }

    public int getViolationZipCode() {
        return violationZipCode;
    }

}
