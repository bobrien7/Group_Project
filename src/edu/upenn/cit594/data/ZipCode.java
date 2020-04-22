package edu.upenn.cit594.data;

public class ZipCode {


    private int zipcode;
    private double population;

    public ZipCode(int zipcode, double population){
        this.population = population;
        this.zipcode = zipcode;
    }


    public int getZipcode(){ return zipcode;}
    public double getPopulation() {
        return population;
    }
}
