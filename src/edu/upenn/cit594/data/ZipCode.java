package edu.upenn.cit594.data;

public class ZipCode {


    private int zipcode;

    private double population;

    private double totalParkingFinesAmount;

    private double totalParkingFinesAmount2;

    private double quantityOfParkingFines;

    private double averageParkingTicketCost;

    private double averageHouseMarketValue;

    public double getTotalMarketValueAmount() {
        return totalMarketValueAmount;
    }

    public void setTotalMarketValueAmount(double totalMarketValueAmount) {
        this.totalMarketValueAmount = totalMarketValueAmount;
    }

    private double totalMarketValueAmount;

    public double getFinesPerCapita() {
        return finesPerCapita;
    }

    public void setFinesPerCapita(double finesPerCapita) {
        this.finesPerCapita = finesPerCapita;
    }

    private double finesPerCapita;

    public double getMarketValuePerCapita() {
        return marketValuePerCapita;
    }

    public void setMarketValuePerCapita(double marketValuePerCapita) {
        this.marketValuePerCapita = marketValuePerCapita;
    }

    private double marketValuePerCapita;

    public ZipCode(int zipcode, double population) {
        this.population = population;
        this.zipcode = zipcode;
    }


    public int getZipcode() {
        return zipcode;
    }

    public double getPopulation() {
        return population;
    }

    public void setTotalParkingFinesAmount(double totalParkingFinesAmount) {
        this.totalParkingFinesAmount = totalParkingFinesAmount;
    }

    public double getTotalParkingFinesAmount() {
        return totalParkingFinesAmount;
    }

    public double getQuantityOfParkingFines() {
        return quantityOfParkingFines;
    }

    public void setQuantityOfParkingFines(double quantityOfParkingFines) {
        this.quantityOfParkingFines = quantityOfParkingFines;
    }

    public double getAverageParkingTicketCost() {
        return averageParkingTicketCost;
    }

    public void setAverageParkingTicketCost(double averageParkingTicketCost) {
        this.averageParkingTicketCost = averageParkingTicketCost;
    }

    public double getAverageHouseMarketValue() {
        return averageHouseMarketValue;
    }

    public void setAverageHouseMarketValue(double averageHouseMarketValue) {
        this.averageHouseMarketValue = averageHouseMarketValue;
    }

    public double getTotalParkingFinesAmount2() {
        return totalParkingFinesAmount2;
    }

    public void setTotalParkingFinesAmount2(double totalParkingFinesAmount2) {
        this.totalParkingFinesAmount2 = totalParkingFinesAmount2;
    }
}
