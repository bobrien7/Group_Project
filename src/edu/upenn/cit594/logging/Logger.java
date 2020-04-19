package edu.upenn.cit594.logging;

import edu.upenn.cit594.Main;

public class Logger {

    public static String loggerName = Main.loggerFileName;

    private Logger(String loggerName){

        //This is the private constructor for the logger.
        //USING THE SINGLETON DESIGN PATTERN

        //this method will check for a logger file and overwrite or create
        //the file if it doesn't already exist
    }

    private static Logger instance = new Logger(loggerName); //Singleton instance

    public static Logger getInstance(){ //Part of the singleton design patter
                                        //This method is how other classes will
                                        //access the single logger instance
        return instance;
    }

    public void log(){

        //this method will be called when you actually want to write something to the logger file
    }


}
