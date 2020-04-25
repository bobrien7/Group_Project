package edu.upenn.cit594.logging;

import edu.upenn.cit594.Main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {

    public static String loggerName = Main.loggerFileName;

    FileWriter fileWriter;
    private Logger(String loggerName) {

        //This is the private constructor for the logger.
        //USING THE SINGLETON DESIGN PATTERN

        //this method will check for a logger file and overwrite or create
        //the file if it doesn't already exist

        System.out.println(Main.loggerFileName);
        System.out.println(loggerName);
        File file = new File(loggerName);

        try {
            if (file.createNewFile()) {
                fileWriter = new FileWriter(loggerName);
                //System.out.println("Logger file created: " + file.getName());
            } else {                                                                          //this Code needs to append existing logger NOT overwrite it
                //System.out.println("Logger file already exists: Overwriting now");
                fileWriter = new FileWriter(loggerName);
                fileWriter.write("");
                fileWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
            //System.out.println("Error Occured: Wasn't able to create logger file");
        }
    }

    private static Logger instance = new Logger(loggerName); //Singleton instance

    public static Logger getInstance() { //Part of the singleton design patter
        //This method is how other classes will
        //access the single logger instance
        return instance;
    }


    public void log(String printedLine) {  //this code will log the given tweet to the log files

        try {
            FileWriter fileWriter = new FileWriter(loggerName);
            System.out.println(this.fileWriter);
            fileWriter.write(printedLine);
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void stopLogging() {

        try {
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
