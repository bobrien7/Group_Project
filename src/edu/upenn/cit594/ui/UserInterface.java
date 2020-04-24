package edu.upenn.cit594.ui;

import edu.upenn.cit594.datamanagement.ParkingViolationCSVReader;
import edu.upenn.cit594.datamanagement.ParkingViolationReader;
import edu.upenn.cit594.datamanagement.PopulationDataReader;
import edu.upenn.cit594.datamanagement.PropertyValueCSVReader;
import edu.upenn.cit594.processor.Processor;

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
        System.out.println("Enter 0 to end the program, 1 to get total population, 2 to get parking violation per capita by zipcode" +
                ", 3 for average market value for a zipcode, 4 for average livable area for a zipcode, 5 for total market value per capita ");

        while (in.hasNextInt()) {
            int choice = in.nextInt();

            if (choice > 6 || choice < 0) {
                System.out.println("Not a valid selection, please choose again");
                in.next();


                // if not a number, print line
                if (choice == 0) { //end program
                    System.exit(0);
                } else if (choice == 1) {

                } else if (choice == 2) {

                } else if (choice == 3) {

                } else if (choice == 4) {

                } else if (choice == 5) {

                } else if (choice == 6) {

                }
                in.close();
                //I believe this method will be the one that asks for user input (0,1,2,3,4,5,6)
                //and executes the related command.

            }  //We gotta make sure we LOG to the logger the CURRENT TIME and the USER SELECTION

            }

            System.out.println("Not a valid selection, please choose again");
            in.next();



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
