package edu.upenn.cit594.processor;

import edu.upenn.cit594.data.ParkingViolation;
import edu.upenn.cit594.data.Property;
import edu.upenn.cit594.data.ZipCode;
import edu.upenn.cit594.datamanagement.ParkingViolationReader;
import edu.upenn.cit594.datamanagement.PopulationDataReader;
import edu.upenn.cit594.datamanagement.PropertyValueCSVReader;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Processor {

    private ParkingViolationReader parkingReader;
    private PopulationDataReader populationDataReader;
    private PropertyValueCSVReader propertyReader;

    private Collection<ParkingViolation> parkingViolations; //TBD what data structure we're gonna use for this
    private ArrayList<ZipCode> populationData; //TBD what data structure we're gonna use for this
    private ArrayList<Property> properties; //TBD what data structure we're gonna use for this


    public Processor(ParkingViolationReader parkingReader, PopulationDataReader populationReader, PropertyValueCSVReader propertyReader) {

        this.parkingReader = parkingReader;
        this.populationDataReader = populationReader;
        this.propertyReader = propertyReader;

        parkingViolations = parkingReader.readParkingViolations();
        populationData = populationReader.read();
        properties = propertyReader.read();

    }


    public int getTotalPopulationForAllZipCodes(HashMap<Integer, Double> zipCodes){

        //this method corresponds to requirement 1 in the spec
        int sum=0;

            for( double populationData : zipCodes.values() ){
                sum+= populationData;
            }
        //Incorporate memoization

        return sum;     //method should return the sum of populations from each zip code


    }

    public static Collection<ZipCode> getTotalFinesPerCapita(ArrayList<ParkingViolation> parkingViolation, ArrayList<ZipCode> theZipCodes) {

        //This method will return a collection of ZipCodes with the associated total fine per capita for that zip code
        //The User Interface will take this output, and do the required printing.
        //This method goes along with Requirement #2 in the spec

        //Incorporate memoization


        double fineSum = 0;
        for (ParkingViolation pv : parkingViolation) {

            for (ZipCode zipCode : theZipCodes) {

                if (zipCode.getZipcode() == pv.getViolationZipCode()) {

                    fineSum = pv.getFineAmount();
                    zipCode.setTotalParkingFinesAmount(zipCode.getTotalParkingFinesAmount() + fineSum);

                }

            }
        }


        for (ZipCode zipCode : theZipCodes) {
            double totalSum = zipCode.getTotalParkingFinesAmount();
            double finesPerCapita = totalSum / zipCode.getPopulation();
            zipCode.setFinesPerCapita(finesPerCapita);
            System.out.println(zipCode.getZipcode());
            System.out.println(zipCode.getFinesPerCapita());

        }


        return theZipCodes;
    }

    public double getAverageMarketValue(int zipcode){
        //From the Spec we have to use the STRATEGY design pattern to link this method with method #4

        //This method goes along with Requirement #3 in the spec
        //This method will return a double that is the average market value for a home in the given zip code

        //You also have to LOG the current time and the given zipcode that was entered to the log file

        //Incorporate memoization

        return 0;
    }

    public double getAverageTotalLivableArea(int zipcode){
        //From the Spec we have to use the STRATEGY design pattern to link this method with method #3

        //This method goes along with Requirement #4 in the spec
        //This method will return a double that is the average total livable area for a home in the given zip code

        //You also have to LOG the current time and the given zipcode that was entered to the log file

        //Incorporate memoization

        return 0;
    }

    public double getResidentialMarketValuePerCapita(int zipcode){

        //This method goes along with Requirement #5 in the spec
        //This method will return a double that is the total residential market value per capita for the given zip code

        //You also have to LOG the current time and the given zipcode that was entered to the log file

        //Incorporate memoization

        return 0;
    }

    public double performCustomOperation(int parameter){

        //This method goes along with requirement #6 in the spec
        //This method will perform some custom operation that we decide on

        //Incorporate memoization

        return 0;
    }


    public static void main(String[] args) {

        ZipCode zipCode1 = new ZipCode(11111, 10);
        ZipCode zipCode2 = new ZipCode(22222, 50);
        ZipCode zipCode3 = new ZipCode(33333, 100);

        ParkingViolation ticket1 = new ParkingViolation("timestamp", 100, "speeding", 0, "NJ",
                1, 11111);

        ParkingViolation ticket2 = new ParkingViolation("timestamp", 100, "speeding", 0, "NJ",
                1, 11111);

        ParkingViolation ticket3 = new ParkingViolation("timestamp", 0, "speeding", 0, "NJ",
                1, 22222);

        ParkingViolation ticket4 = new ParkingViolation("timestamp", 100, "speeding", 0, "NJ",
                1, 22222);


        HashMap<ZipCode, Double> zipCodes = new HashMap<>();
        zipCodes.put(zipCode1, 11111.0);
        zipCodes.put(zipCode2, 22222.0);
        zipCodes.put(zipCode3, 33333.0);

        ArrayList<ZipCode> theZipCodes = new ArrayList<>();
        theZipCodes.add(zipCode1);
        theZipCodes.add(zipCode2);
        theZipCodes.add(zipCode3);

        ArrayList<ParkingViolation> parkingViolation = new ArrayList<>();
        parkingViolation.add(ticket1);
        parkingViolation.add(ticket2);
        parkingViolation.add(ticket3);
        parkingViolation.add(ticket4);

        getTotalFinesPerCapita(parkingViolation, theZipCodes);


    }


}
