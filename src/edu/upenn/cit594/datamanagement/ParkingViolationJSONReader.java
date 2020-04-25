package edu.upenn.cit594.datamanagement;

import edu.upenn.cit594.data.ParkingViolation;
import edu.upenn.cit594.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ParkingViolationJSONReader implements ParkingViolationReader {

    private String filename;


    public ParkingViolationJSONReader(String filename){
        this.filename = filename;
    }

    @Override
    public ArrayList<ParkingViolation> readParkingViolations() {
        ArrayList<ParkingViolation> parkingViolation = new ArrayList<ParkingViolation>();
        int counter = 0;
        JSONParser pvParser = new JSONParser();
        JSONArray pvJson = null;
        try {
            pvJson = (JSONArray) pvParser.parse(new FileReader(filename));
            Logger.getInstance().log(filename);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Iterator iter = pvJson.iterator();
        while (iter.hasNext()) {
            JSONObject pv = (JSONObject) iter.next();
            if(!pv.get("zip_code").equals("")) {


                String timestamp = (String) pv.get("date");
                int fineAmount = Integer.parseInt(String.valueOf(pv.get("fine")));
                String violationDescription = (String) pv.get("violation");
                int vehicleID = Integer.parseInt((String) pv.get("plate_id"));
                String vehicleState = (String) pv.get("state");
                int violationNumber = Integer.parseInt(String.valueOf((pv.get("ticket_number"))));

                int violationZipCode = Integer.parseInt(String.valueOf(pv.get("zip_code")));

                parkingViolation.add(new ParkingViolation(timestamp, fineAmount, violationDescription, vehicleID, vehicleState, violationNumber, violationZipCode));

            }

            }
        for(ParkingViolation pv : parkingViolation){ // for testing
            counter++;
        }

        return parkingViolation;
    }

        @Override
        public void logTimeAndFileName () {

        }
    public static void main(String[] args) { // for testing
        ParkingViolationJSONReader pvcsv = new ParkingViolationJSONReader("parking.json");
        pvcsv.readParkingViolations();

    }

}
