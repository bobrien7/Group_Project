package edu.upenn.cit594.ui;

import edu.upenn.cit594.processor.Processor;

public class UserInterface {

    private Processor processor;

    public UserInterface(Processor processor){

        this.processor = processor;
    }

    public void start(){

        //this method will start up the program
        System.out.println("Starting program");

        //I believe this method will be the one that asks for user input (0,1,2,3,4,5,6)
        //and executes the related command.

        //We gotta make sure we LOG to the logger the CURRENT TIME and the USER SELECTION
    }


}
