package edu.upenn.cit594.ui;

import edu.upenn.cit594.Main;
import edu.upenn.cit594.data.ZipCode;
import edu.upenn.cit594.datamanagement.ParkingViolationCSVReader;
import edu.upenn.cit594.datamanagement.ParkingViolationReader;
import edu.upenn.cit594.datamanagement.PopulationDataReader;
import edu.upenn.cit594.datamanagement.PropertyValueCSVReader;
import edu.upenn.cit594.logging.Logger;
import edu.upenn.cit594.processor.Processor;

import java.text.DecimalFormat;
import java.time.LocalTime;
import java.util.*;

public class UserInterface {

    private Processor processor;
    Scanner in;

    public UserInterface(Processor processor){

        this.processor = processor;
        in = new Scanner(System.in);
    }

    public void start() {

        //this method will start up the program

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
                String stringChoice = in.next();
                int choice = Integer.parseInt(stringChoice);

                Logger.getInstance().log(stringChoice);   //log the users selection

                if (stringChoice.length() != 1) {
                    System.out.println("Not a valid selection, program terminating");
                    System.exit(0);

                } else if (choice > 6 || choice < 0) {
                    System.out.println("Not a valid selection, program terminating");
                    System.exit(0);

                }


                // if not a number, print line
                else if (choice == 0) { //end program
                    Logger.getInstance().stopLogging();
                    System.exit(0);
                } else if (choice == 1) {
                    doTotalPopulationForAllZipCodes();

                } else if (choice == 2) {
                    doGetFinesPerCapita();

                } else if (choice == 3) {
                    System.out.print("Please enter a zipcode: ");

                        Boolean indicator1 = true;
                        while (indicator1) {
                            if(in.hasNextInt()) {
                            int zip = in.nextInt();
                            if (zip > 99999 || zip < 9999) {
                                System.out.print(0);  //displays 0 if the user enters an invalid zip code

                                Logger.getInstance().log(Integer.toString(zip));
                                indicator1 = false;


                            } else {
                                doGetAverageMarketValue(zip);
                                indicator1 = false;

                            }
                        }else {
                                indicator1 = false;
                                System.out.println(0);
                                Logger.getInstance().log(in.next());

                            }


                    }




                } else if (choice == 4) {
                    System.out.print("Please enter a zipcode: ");

                        Boolean indicator2 = true;
                        while (indicator2) {
                            if(in.hasNextInt()) {
                                int zip = in.nextInt();
                                if (zip > 99999 || zip < 9999) {
                                    System.out.print(0);  //displays 0 if the user enters an invalid zip code
                                    indicator2 = false;

                                    Logger.getInstance().log(Integer.toString(zip));

                                } else {
                                    doAverageTotalLivableArea(zip);
                                    indicator2 = false;

                                }
                            }else {
                                System.out.println(0);
                                indicator2 = false;
                                Logger.getInstance().log(in.next());

                            }

                        }




                } else if (choice == 5) {

                    System.out.print("Please enter a zipcode: ");
                    Boolean indicator3 = true;
                    while ( indicator3) {
                        if (in.hasNextInt()) {
                            int zip = in.nextInt();
                            if (zip > 99999 || zip < 9999) {
                                System.out.print(0);
                                indicator3 = false;

                                Logger.getInstance().log(Integer.toString(zip));

                            } else {
                                doGetResidentialMarketValuePerCapita(zip);
                                indicator3 = false;

                            }
                        } else {
                            System.out.println(0);
                            indicator3 = false;
                            Logger.getInstance().log(in.next());
                        }
                    }

                } else if (choice == 6) {
                    doCustomOperation();
                }

                //I believe this method will be the one that asks for user input (0,1,2,3,4,5,6)
                //and executes the related command.

                //We gotta make sure we LOG to the logger the CURRENT TIME and the USER SELECTION

            } else {
                System.out.println("Not a valid selection, terminating program");
                Logger.getInstance().log(in.next());
                Logger.getInstance().stopLogging();
                System.exit(0);
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
            TreeSet<Integer> allZipCodesInTree = new TreeSet<>();

            for (ZipCode zipCode : allZipCodes) {
                allZipCodesInTree.add(zipCode.getZipcode());
            }

            Iterator<Integer> iterator = allZipCodesInTree.iterator();
            while (iterator.hasNext()) {
                Integer current = iterator.next();
                if (finesPerCapita.containsKey(current)) {

                    Double finesPerCapitaResult = finesPerCapita.get(current);
                    String pattern = "###0.0000";
                    DecimalFormat df = new DecimalFormat(pattern);
                    System.out.println(current + " " + df.format(finesPerCapitaResult));

                }

            }

        }
        protected void doGetAverageMarketValue(int zip){


        Double averageMarketValue = processor.getAverageMarketValue(zip, true);
            String pattern = "###0";
            DecimalFormat df = new DecimalFormat(pattern);

            System.out.println( df.format(averageMarketValue));

        }
        protected void doAverageTotalLivableArea(int zip){
            Double averageTotalLivableArea = processor.getAverageTotalLivableArea(zip);
            String pattern = "###0.0000";
            DecimalFormat df = new DecimalFormat(pattern);

            System.out.println(df.format(averageTotalLivableArea));


        }

        protected void doGetResidentialMarketValuePerCapita(int zip){


             Double residentialMarketValue = processor.getResidentialMarketValuePerCapita(zip);


            String pattern = "###0";
            DecimalFormat df = new DecimalFormat(pattern);


            System.out.println(df.format(residentialMarketValue));


        }

    protected void doCustomOperation() {

        ArrayList<ZipCode> theZipCodes = processor.updateAverageCostForPropertyAndFineForAllZips();

        for (ZipCode zipcode : theZipCodes) {

            if (zipcode.getAverageParkingTicketCost() == 0 || zipcode.getAverageHouseMarketValue() == 0) {

                //do nothing
            } else {
                String pattern = "###0";
                String pattern2 = "###0.00";
                DecimalFormat df = new DecimalFormat(pattern);
                DecimalFormat df2 = new DecimalFormat(pattern2);

                System.out.print(zipcode.getZipcode() + " ");
                System.out.print(df.format(zipcode.getAverageHouseMarketValue()) + " ");
                System.out.println(df2.format(zipcode.getAverageParkingTicketCost()));
            }

        }
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
