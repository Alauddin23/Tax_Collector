// creating the class called TaxCollector

import java.util.List;

public class TaxCollector {

    // private fields
    private List<FoodPlace> foodPlaces;

    private double incomeTaxCollected;

    private double salesTaxCollected;

    // writing the constructor class for the class TaxCollector
    public TaxCollector(List<FoodPlace> foodPlaces){

        this.foodPlaces = foodPlaces;
    }

    // writing the getFoodPlaces() method
    public List<FoodPlace> getFoodPlaces(){
        return (this.foodPlaces);
    }

    // writing the getIncomeTaxCollected() method
    public double getIncomeTaxCollected(){
        return (this.incomeTaxCollected);
    }

    // writing the getSalesTaxCollected() method
    public double getSalesTaxCollected(){
        return (this.salesTaxCollected);
    }

    // writing the toString() method
    public String toString(){
        return ("Income tax collected: " + this.getIncomeTaxCollected() + ", Sales tax collected: " + this.getSalesTaxCollected());
    }

    // The method returns nothing
    // For each FoodPlace in the list of FoodPlace, the sales tax is collected and the income tax from all income
    // tax payers are collected and values added to incomeTaxCollected and salesTaxCollected
    public void collectTax(){

        // The method iterates through the list of FoodPlace
        for (FoodPlace foodPlaceObject : foodPlaces){

            // The method first adds the totalSalesTaxCollected for each FoodPlace object
            // to the salesTaxCollected field
            double accumulatedSalesTax = (foodPlaceObject.getTotalSalesTax()) + (this.salesTaxCollected);
            this.salesTaxCollected = accumulatedSalesTax;

            // In each FoodPlace object there is a list of IncomeTaxPayers which is obtained by the
            // getIncomeTaxPayers() method
            // The method iterates through that list

            double addedIncomeTax = 0.0;

            for (IncomeTaxPayer incomeTaxPayerObject : (foodPlaceObject.getIncomeTaxPayers())){

                // The method now adds all the income tax that needs to be paid by all the Income Tax Payers
                // in that particular FoodPlace

                addedIncomeTax = (addedIncomeTax) + (incomeTaxPayerObject.calculateIncomeTax());

            }

            // The addedIncomeTax for each FoodPlace should be added to the incomeTaxCollected field
            double accumulatedIncomeTax = (addedIncomeTax) + (this.incomeTaxCollected);
            this.incomeTaxCollected = accumulatedIncomeTax;
        }
    }
}
