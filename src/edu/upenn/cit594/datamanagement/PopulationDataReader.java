package edu.upenn.cit594.datamanagement;

import edu.upenn.cit594.data.ParkingViolation;
import edu.upenn.cit594.data.ZipCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class PopulationDataReader {

    private String filename;

    public PopulationDataReader(String filename){
        this.filename = filename;
    }


    public ArrayList<ZipCode> read() {
        //HashMap<ZipCode, Double> zipcodes = new HashMap<ZipCode, Double>();
        ArrayList<ZipCode> theZipCodes = new ArrayList<>();
//        int counter=0;
        try {
            Scanner scanner = new Scanner(new File(filename));

            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                String[] lineData = data.split(" ");
                int zipcode = Integer.parseInt(lineData[0]);
                double population = Integer.parseInt(lineData[1]);


                //zipcodes.put(new ZipCode(zipcode, population), population);
                theZipCodes.add(new ZipCode(zipcode, population));
            }
            scanner.close();

        } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
//        for(int pd : populationData.values() ) { // for testing
//            counter++;
//            System.out.println(pd);
//        }
//        }System.out.println(counter);

        return theZipCodes;
    }

//    public static void main(String[] args) { //  for testing
//        PopulationDataReader pvcsv = new PopulationDataReader("population.txt");
//        pvcsv.read();
//
//    }
}
