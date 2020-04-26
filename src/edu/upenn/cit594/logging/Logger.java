package edu.upenn.cit594.logging;

import edu.upenn.cit594.Main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;

public class Logger {

    public static String loggerName = Main.loggerFileName;

    FileWriter fileWriter;
    private Logger(String loggerName) {

        //This is the private constructor for the logger.
        //USING THE SINGLETON DESIGN PATTERN

        //this method will check for a logger file and overwrite or create
        //the file if it doesn't already exist

        File file = new File(loggerName);

        try {
            if (file.createNewFile()) {

                fileWriter = new FileWriter(loggerName);

            } else {   //this Code needs to append existing logger NOT overwrite it

                fileWriter = new FileWriter(loggerName, true);
                //fileWriter.write("");

            }
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    private static Logger instance = new Logger(loggerName); //Singleton instance

    public static Logger getInstance() { //Part of the singleton design pattern
        //This method is how other classes will
        //access the single logger instance
        return instance;
    }


    public void log(String printedLine) {  //this code will log the given string to the log files

        try {

            LocalTime localTime = java.time.LocalTime.now();   //logs current time
            String theTime = localTime.toString();

            fileWriter.write(theTime + " " + printedLine + "\n");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void stopLogging() {

        try {
            fileWriter.close();    //closes the filewriter when finished logging
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
