package edu.upenn.cit594.datamanagement;

import edu.upenn.cit594.data.ParkingViolation;
import edu.upenn.cit594.data.Property;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class PropertyValueCSVReader {

    private String filename;

    public PropertyValueCSVReader(String filename) {
        this.filename = filename;
    }

    public ArrayList<Property> read() {
        ArrayList<Property> property = new ArrayList<Property>();
        int totalLivableAreaColumnNumber = 0;
        int marketValueColumnNumber = 0;
        int zipCodeColumnNumber = 0;
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(filename));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (scanner.hasNextLine() == true) {

            String firstLine = scanner.nextLine();
            String[] firstLineCells = firstLine.split(",");
            int counter = 0;

            for (String cell : firstLineCells) {


                if (cell.equals("total_livable_area")) {

                    totalLivableAreaColumnNumber = counter;
                }

                if (cell.equals("market_value")) {

                    marketValueColumnNumber = counter;
                }

                if (cell.equals("zip_code")) {

                    zipCodeColumnNumber = counter;
                }

                counter++;
            }

//            System.out.println("Total Livable Area is in column: " + totalLivableAreaColumnNumber);
//            System.out.println("Market value is in column: " + marketValueColumnNumber);
//            System.out.println("ZipCode is in column: " + zipCodeColumnNumber);
//            System.out.println();

        }



        while (scanner.hasNextLine()) {
            ArrayList<String> words = new ArrayList<>();
            String thisLine = scanner.nextLine();
            String[] thisLineSplit = thisLine.split(",");

            boolean indicator = true;
            int count5 = 0;

            int extraWordCount = 0;
            for (String word : thisLineSplit) {

                if(extraWordCount != 0){

                    extraWordCount = extraWordCount - 1;

                }

                else if (word.equals("")) {

                    words.add(word);

                }

                else if (word.charAt(0) == '\"') {

                    if (word.charAt(word.length() - 1) == '\"') {

                        words.add(word);

                    } else {

                        int location = count5;
                        while (indicator) {
                            location++;

                            if (thisLineSplit[location].charAt(thisLineSplit[location].length() - 1) == '\"') {
                                extraWordCount++;
                                word = word + thisLineSplit[location];
                                words.add(word);
                                indicator = false;
                            }

                            else {
                                word = word + thisLineSplit[location];
                                extraWordCount++;
                            }

                        }
                    }

                } else if (word.charAt(word.length() - 1) == '\"') {
                    //do nothing
                } else {
                    words.add(word);
                }
                count5++;
            }

            //System.out.println(thisLine);
            String thisPropertiesMarketValueString = words.get(marketValueColumnNumber);
            String thisPropertiesZipCodeString = words.get(zipCodeColumnNumber);
            String thisPropertiesTotalAreaString = words.get(totalLivableAreaColumnNumber);
            if(thisPropertiesMarketValueString.equals("")||thisPropertiesZipCodeString.equals("")||thisPropertiesTotalAreaString.equals("")){
                scanner.nextLine();

                //do nothing
            }
            else {

//                String address = "20' N WILLOWS AVE        ";
//                if (words.get(2).equals(address)) {
//                    System.out.println(thisLine);
//                    System.out.println(address);
//                    System.out.println("This property's market value is: " + thisPropertiesMarketValueString);
//                    System.out.println("This property's zip code is: " + thisPropertiesZipCode);
//                    System.out.println("This property's TLA is : " +thisPropertiesTotalArea);
//
//                }

                Double thisPropertiesMarketValue = Double.parseDouble(thisPropertiesMarketValueString);
                String zipCodeSubString = "";
                if (thisPropertiesZipCodeString.length()>5){ //trims the zipcode to only first 5 digits
                    zipCodeSubString = thisPropertiesZipCodeString.substring(0,5);
                    Integer thisPropertiesZipCode = Integer.parseInt(zipCodeSubString);

                }
                Integer thisPropertiesZipCode = Integer.parseInt(zipCodeSubString);

                Integer thisPropertiesTotalArea= Integer.parseInt(thisPropertiesTotalAreaString);

                property.add(new Property(thisPropertiesMarketValue,thisPropertiesZipCode, thisPropertiesTotalArea));
            }

            for( Property prop: property){ // for testing
                System.out.println(prop.getMarketValue());
                System.out.println(prop.getZipCode());
                System.out.println(prop.getTotalLivableArea());
            }
        }

        scanner.close();
            return property;
        }

        public static void main (String[]args){ // for testing

            PropertyValueCSVReader reader = new PropertyValueCSVReader("properties.csv");
            reader.read();
        }

    }


