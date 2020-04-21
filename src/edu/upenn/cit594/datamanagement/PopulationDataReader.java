package edu.upenn.cit594.datamanagement;

import edu.upenn.cit594.data.ParkingViolation;
import edu.upenn.cit594.data.ZipCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PopulationDataReader {

    private String filename;

    public PopulationDataReader(String filename){
        this.filename = filename;
    }


    public HashMap<Integer, Integer> read() {
        HashMap<Integer, Integer> populationData = new HashMap<Integer, Integer>();
//        int counter=0;
        try {
            Scanner scanner = new Scanner(new File(filename));

        while(scanner.hasNextLine()){
            String data = scanner.nextLine();
            String[] lineData = data.split(" ");
            int zipcode = Integer.parseInt(lineData[0]);
            int population = Integer.parseInt(lineData[1]);

            populationData.put(zipcode, population);
        }


    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
//        for(int pd : populationData.values() ) { // for testing
//            counter++;
//            System.out.println(pd);
//        }
//        }System.out.println(counter);

        return populationData;
    }

//    public static void main(String[] args) { //  for testing
//        PopulationDataReader pvcsv = new PopulationDataReader("population.txt");
//        pvcsv.read();
//
//    }
}
