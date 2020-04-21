package edu.upenn.cit594.data;

public class ZipCode {

    private int population;
    private int zipcode;

    public ZipCode(int zipcode, int population){
        this.population = population;
        this.zipcode = zipcode;
    }

    public double getPopulation() {
        return population;
    }
    public int getZipcode(){ return zipcode;}
}
