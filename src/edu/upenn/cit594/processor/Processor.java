package edu.upenn.cit594.processor;

import edu.upenn.cit594.data.ParkingViolation;
import edu.upenn.cit594.data.Property;
import edu.upenn.cit594.data.ZipCode;
import edu.upenn.cit594.datamanagement.ParkingViolationCSVReader;
import edu.upenn.cit594.datamanagement.ParkingViolationReader;
import edu.upenn.cit594.datamanagement.PopulationDataReader;
import edu.upenn.cit594.datamanagement.PropertyValueCSVReader;

import java.io.Reader;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Processor {

    private ParkingViolationReader parkingReader;
    private PopulationDataReader populationDataReader;
    private PropertyValueCSVReader propertyReader;

    private ArrayList<ParkingViolation> parkingViolations; //TBD what data structure we're gonna use for this
    private ArrayList<ZipCode> populationData; //TBD what data structure we're gonna use for this
    private ArrayList<Property> properties; //TBD what data structure we're gonna use for this

    //these are our memoization hashmaps
    private HashMap<String, Integer> method1Memo = new HashMap<>();
    HashMap<Integer, Double> method2Memo = new HashMap<>();


    HashMap<Integer, Double> method5Memo = new HashMap<>();


    public Processor(ParkingViolationReader parkingReader, PopulationDataReader populationReader, PropertyValueCSVReader propertyReader) {

        this.parkingReader = parkingReader;
        this.populationDataReader = populationReader;
        this.propertyReader = propertyReader;

        parkingViolations = parkingReader.readParkingViolations();
        populationData = populationReader.read();
        properties = propertyReader.read();

    }


    public int getTotalPopulationForAllZipCodes() {

        if (method1Memo.containsKey("answer")) {    //memoization

            return method1Memo.get("answer");

        } else {

            //this method corresponds to requirement 1 in the spec
            int sum = 0;

            for (ZipCode populationData : populationData) {
                sum += populationData.getPopulation();
            }
            //Incorporate memoization
            method1Memo.put("answer", sum);
            return sum;    //method should return the sum of populations from each zip code
        }


    }

    public HashMap<Integer, Double> getTotalFinesPerCapita() {

        //This method will return a collection of ZipCodes with the associated total fine per capita for that zip code
        //The User Interface will take this output, and do the required printing.
        //This method goes along with Requirement #2 in the spec

        //Incorporate memoization
        if (!method2Memo.isEmpty()) {

            return method2Memo;
        } else {
            double fineSum = 0;
            for (ParkingViolation pv : parkingViolations) {

                if (pv.getVehicleState().equals("PA")) {

                    for (ZipCode zipCode : populationData) {

                        if (zipCode.getZipcode() == pv.getViolationZipCode()) {

                            fineSum = pv.getFineAmount();
                            zipCode.setTotalParkingFinesAmount(zipCode.getTotalParkingFinesAmount() + fineSum);

                        }

                    }
                }
            }


            for (ZipCode zipCode : populationData) {
                double totalSum = zipCode.getTotalParkingFinesAmount();
                double finesPerCapita = totalSum / zipCode.getPopulation();
                zipCode.setFinesPerCapita(finesPerCapita);

                if (zipCode.getFinesPerCapita() != 0 && zipCode.getPopulation() != 0) {

                    method2Memo.put(zipCode.getZipcode(), zipCode.getFinesPerCapita());
                }

            }

            return method2Memo;
        }
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

    public double getResidentialMarketValuePerCapita(int zipcode) {

        //This method goes along with Requirement #5 in the spec
        //This method will return a double that is the total residential market value per capita for the given zip code

        //You also have to LOG the current time and the given zipcode that was entered to the log file

        //Incorporate memoization

        if (zipcode < 9999) {

            return 0.0;
        }

        if (method5Memo.containsKey(zipcode)) {

            System.out.println("Memoization");
            return method5Memo.get(zipcode);

        } else {
            double marketValueSum = 0;

            for (Property property : properties) {

                for (ZipCode zipCode : populationData) {

                    if (zipCode.getZipcode() == property.getZipCode()) {

                        marketValueSum = property.getMarketValue();

                        zipCode.setTotalMarketValueAmount(zipCode.getTotalMarketValueAmount() + marketValueSum);

                    }

                }
            }


            for (ZipCode zipCode : populationData) {

                double totalSum = zipCode.getTotalMarketValueAmount();
                double marketValuePerCapita = totalSum / zipCode.getPopulation();
                zipCode.setMarketValuePerCapita(marketValuePerCapita);

                if (zipCode.getPopulation() != 0) {

                    method5Memo.put(zipCode.getZipcode(), marketValuePerCapita);
                } else {
                    method5Memo.put(zipCode.getZipcode(), 0.0);
                }

            }

            if (!method5Memo.containsKey(zipcode)) {

                return 0;
            }

            return method5Memo.get(zipcode);
        }

    }

    public double performCustomOperation(int parameter) {     //mostSpaceForThePrice We'll return thee best house in philly aka most livable area for the least cost in a given zipcod

        //This method goes along with requirement #6 in the spec
        //This method will perform some custom operation that we decide on

        //Incorporate memoization


        //create arraylist of properties
        //cycle through ALL of our properties and add all the ones in the given zip code to that arraylist
        //for each property in that arraylist...
        //calculate the value ratio aka             maximize livable area/marketvalue
        //if that ratio is greater than the our current highest...
        // then this one is the current highest
        //

        // or give average ratio for a given zip code

        return 0;
    }


    public ArrayList<ZipCode> getPopulationData() {
        return populationData;
    }


    public static void main(String[] args) {

//        ZipCode zipCode1 = new ZipCode(11111, 10);
//        ZipCode zipCode2 = new ZipCode(22222, 50);
//        ZipCode zipCode3 = new ZipCode(33333, 100);
//
//        ParkingViolation ticket1 = new ParkingViolation("timestamp", 100, "speeding", 0, "NJ",
//                1, 11111);
//
//        ParkingViolation ticket2 = new ParkingViolation("timestamp", 100, "speeding", 0, "NJ",
//                1, 11111);
//
//        ParkingViolation ticket3 = new ParkingViolation("timestamp", 0, "speeding", 0, "NJ",
//                1, 22222);
//
//        ParkingViolation ticket4 = new ParkingViolation("timestamp", 100, "speeding", 0, "NJ",
//                1, 22222);
//
//
//        HashMap<ZipCode, Double> zipCodes = new HashMap<>();
//        zipCodes.put(zipCode1, 11111.0);
//        zipCodes.put(zipCode2, 22222.0);
//        zipCodes.put(zipCode3, 33333.0);
//
//        ArrayList<ZipCode> theZipCodes = new ArrayList<>();
//        theZipCodes.add(zipCode1);
//        theZipCodes.add(zipCode2);
//        theZipCodes.add(zipCode3);
//
//        ArrayList<ParkingViolation> parkingViolation = new ArrayList<>();
//        parkingViolation.add(ticket1);
//        parkingViolation.add(ticket2);
//        parkingViolation.add(ticket3);
//        parkingViolation.add(ticket4);
//
//        getTotalFinesPerCapita(parkingViolation, theZipCodes);

        PopulationDataReader populationReader = new PopulationDataReader("population.txt");
        ParkingViolationReader parkingReader = new ParkingViolationCSVReader("parking.csv");
        PropertyValueCSVReader propertyReader = new PropertyValueCSVReader("properties.csv");

        Processor theProcessor = new Processor(parkingReader, populationReader, propertyReader);
        //System.out.println(theProcessor.getTotalPopulationForAllZipCodes());
        //System.out.println(theProcessor.getTotalPopulationForAllZipCodes());

        HashMap<Integer, Double> testingMethod2 = theProcessor.getTotalFinesPerCapita();
        testingMethod2 = theProcessor.getTotalFinesPerCapita();
        //testingMethod2 = theProcessor.getTotalFinesPerCapita();
        //System.out.println(testingMethod2.size());


        for (ZipCode zipcode : theProcessor.populationData) {      //ADD THIS TYPE OF THING TO UI CLASS
            if (testingMethod2.containsKey(zipcode.getZipcode())) {

                String pattern = "###0.0000";
                double number = testingMethod2.get(zipcode.getZipcode());

                DecimalFormat nF = new DecimalFormat(pattern);

                //System.out.println(zipcode.getZipcode() + " " + nF.format(number));
            }
        }


        double answer = theProcessor.getResidentialMarketValuePerCapita(11115);

        System.out.println(answer);


    }


}
