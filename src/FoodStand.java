import java.util.ArrayList;

// The FoodStand class is a subclass of FoodPlace class
public class FoodStand extends FoodPlace{

    // this is the constructor method for the class FoodPlace
    public FoodStand(String name, double fixedCosts, WorkingOwner owner){

        super(name, fixedCosts, owner);
    }

    // writing the toString() method
    public String toString(){
        return ("Name of FoodStand: " + this.getName() + ", Fixed costs of the FoodStand: " + this.getFixedCosts());
    }

    // The method returns an array list containing one element - the owner
    public ArrayList<IncomeTaxPayer> getIncomeTaxPayers(){

        // creating the ArrayList that will be returned
        ArrayList<IncomeTaxPayer> incomeTaxPayerList = new ArrayList<>();

        incomeTaxPayerList.add(0, this.getOwner());

        return incomeTaxPayerList;
    }

    // The method takes a Check object as argument and returns nothing
    // The method uses Check and updates owner's income by adding menu price and tip
    // It also updates the total sales tax
    public void distributeIncomeAndSalesTax(Check check){

        // The method first calculates the new income of the owner by adding tip and menu price to the previous income
        double newOwnerIncome = (this.getOwner().getIncome()) + (check.getMenuPrice()) + (check.getTip());
        this.getOwner().setIncome(newOwnerIncome);

        // The method now updates the total sales tax
        double newSalesTax = (this.getTotalSalesTax()) + (check.getSalesTax());
        this.setTotalSalesTax(newSalesTax);
    }

    // This method returns target tip percentage defined by the owner
    public double getTipPercentage(){

        // The owner of a FoodStand is WorkingOwner, so first we type cast Owner into WorkingOwner
        WorkingOwner workingOwner = (WorkingOwner) this.getOwner();

        // Then we return the targetTipPct which is a field of WorkingOwner
        return (workingOwner.getTargetTipPct());
    }

    // There is no workShift() method in FoodStand, so keeping the method body empty
    public void workShift(int hours){

    }

}

