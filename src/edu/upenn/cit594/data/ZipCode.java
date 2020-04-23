package edu.upenn.cit594.data;

public class ZipCode {


    private int zipcode;

    private double population;

    private double totalParkingFinesAmount;

    public double getFinesPerCapita() {
        return finesPerCapita;
    }

    public void setFinesPerCapita(double finesPerCapita) {
        this.finesPerCapita = finesPerCapita;
    }

    private double finesPerCapita;

    public ZipCode(int zipcode, double population){
        this.population = population;
        this.zipcode = zipcode;
    }


    public int getZipcode(){ return zipcode;}
    public double getPopulation() {
        return population;
    }
    public void setTotalParkingFinesAmount(double totalParkingFinesAmount) {
        this.totalParkingFinesAmount = totalParkingFinesAmount;
    }
    public double getTotalParkingFinesAmount() {
        return totalParkingFinesAmount;
    }
}
