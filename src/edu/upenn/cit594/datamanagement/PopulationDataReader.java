package edu.upenn.cit594.datamanagement;

import edu.upenn.cit594.data.ParkingViolation;
import edu.upenn.cit594.data.ZipCode;
import edu.upenn.cit594.logging.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class PopulationDataReader {

    private String filename;

    public PopulationDataReader(String filename) {
        this.filename = filename;
    }


    public ArrayList<ZipCode> read() {  //this method returns an arrayList of ZipCode objects that each have an associated population field

        ArrayList<ZipCode> theZipCodes = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File(filename));
            Logger.getInstance().log(filename);    //log that the file was read


            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                String[] lineData = data.split(" ");
                int zipcode = Integer.parseInt(lineData[0]);
                double population = Integer.parseInt(lineData[1]);

                theZipCodes.add(new ZipCode(zipcode, population));  //add the zipCode to the arrayList
            }
            scanner.close();

        } catch (FileNotFoundException e) {
        e.printStackTrace();
    }

        return theZipCodes;
    }

}
