package edu.upenn.cit594.ui;

import edu.upenn.cit594.data.ZipCode;
import edu.upenn.cit594.datamanagement.ParkingViolationCSVReader;
import edu.upenn.cit594.datamanagement.ParkingViolationReader;
import edu.upenn.cit594.datamanagement.PopulationDataReader;
import edu.upenn.cit594.datamanagement.PropertyValueCSVReader;
import edu.upenn.cit594.processor.Processor;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Scanner;

public class UserInterface {

    private Processor processor;
    Scanner in;

    public UserInterface(Processor processor){

        this.processor = processor;
        in = new Scanner(System.in);
    }

    public void start() {

        //this method will start up the program
        System.out.println("Starting program");
//        System.out.println("Enter 0 to end the program. " );
//        System.out.println("Enter 1 to get total population. " );
//        System.out.println("Enter 2 to get parking violation per capita by zipcode.");
//        System.out.println("Enter 3 for average market value for a zipcode. ");
//        System.out.println("Enter 4 for average livable area for a zipcode.");
//        System.out.println("Enter 5 for total market value per capita. ");
//        System.out.println("Enter 6 for something. ");

        Boolean indicator = true;


        while (indicator) {

            System.out.println("");
            System.out.println("Enter 0 to end the program. " );
            System.out.println("Enter 1 to get total population. " );
            System.out.println("Enter 2 to get parking violation per capita by zipcode.");
            System.out.println("Enter 3 for average market value for a zipcode. ");
            System.out.println("Enter 4 for average livable area for a zipcode.");
            System.out.println("Enter 5 for total market value per capita. ");
            System.out.println("Enter 6 for something. ");
            if (in.hasNextInt()) {
                int choice = in.nextInt();

                if (choice > 6 || choice < 0) {
                    System.out.println("Not a valid selection, please choose again");

                }


                // if not a number, print line
                if (choice == 0) { //end program
                    System.exit(0);
                } else if (choice == 1) {
                    doTotalPopulationForAllZipCodes();

                } else if (choice == 2) {
                    doGetFinesPerCapita();

                } else if (choice == 3) {


                } else if (choice == 4) {

                } else if (choice == 5) {

                    System.out.print("Please enter a zipcode:");
                    Boolean indicator1 = true;
                    while ( indicator1){
                        int zip = in.nextInt();
                        if(zip > 99999  || zip <9999){
                            System.out.print("Please enter a valid zipcode");


                        }else {

                            doGetResidentialMarketValuePerCapita(zip);
                            indicator1 = false;



                        }
                    }

                } else if (choice == 6) {

                }

                //I believe this method will be the one that asks for user input (0,1,2,3,4,5,6)
                //and executes the related command.

                //We gotta make sure we LOG to the logger the CURRENT TIME and the USER SELECTION

            } else {
                System.out.println("Not a valid selection, please choose again");
                in.next();
            }

        }
        in.close();
    }

    protected void doTotalPopulationForAllZipCodes() {
        System.out.println(processor.getTotalPopulationForAllZipCodes());
    }

    protected void doGetFinesPerCapita() {
        HashMap<Integer, Double> finesPerCapita = processor.getTotalFinesPerCapita();
        ArrayList<ZipCode> allZipCodes = processor.getPopulationData();

        for (ZipCode zipCode : allZipCodes) {
            if (finesPerCapita.containsKey(zipCode.getZipcode())) {

                Double finesPerCapitaResult = finesPerCapita.get(zipCode.getZipcode());

                String pattern = "###0.0000";
                DecimalFormat df = new DecimalFormat(pattern);


                System.out.println(zipCode.getZipcode() + " " + df.format(finesPerCapitaResult));

            }




        }
    }
        protected void doGetResidentialMarketValuePerCapita(int zip){


             Double residentialMarketValue = processor.getResidentialMarketValuePerCapita(zip);


                    String pattern = "###0.";
                    DecimalFormat df = new DecimalFormat(pattern);


                    System.out.println( df.format(residentialMarketValue));



            }










    public static void main(String[] args) { // testing

        PopulationDataReader populationReader = new PopulationDataReader("population.txt");
        ParkingViolationReader parkingReader = new ParkingViolationCSVReader("parking.csv");
        PropertyValueCSVReader propertyReader = new PropertyValueCSVReader("properties.csv");

        Processor processor = new Processor(parkingReader, populationReader, propertyReader);
        UserInterface ui = new UserInterface(processor);
        ui.start();
    }



}
