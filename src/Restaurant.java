import java.util.ArrayList;

// The Restaurant class is a subclass of FoodPlace class
public class Restaurant extends FoodPlace{

    // it has two private fields
    private Staff cook;

    private Server server;

    // this is the constructor method for the class Restaurant
    public Restaurant(String name, double fixedCosts, Owner owner, Staff cook, Server server){

        // calling the super method as the Restaurant is also a FoodPlace
        super(name, fixedCosts, owner);
        this.cook = cook;
        this.server = server;
    }

    // writing the getCook() method
    public Staff getCook(){
        return (this.cook);
    }

    // writing the getServer() method
    public Server getServer(){
        return (this.server);
    }

    // writing the toString() method
    public String toString(){
        return ("Server's target tip percentage: " + this.server.getTargetTipPct() + ", Cook's salary per hour: " + this.cook.getSalaryPerHour() + ", Cook's income tax percentage: " + this.cook.getIncomeTaxPercentage());

    }

    // writing the workShift(int hours) method
    // This method models that the cook and server are paid an hourly wage
    // This method increases cook and server's income based on number of hours worked and per hour salary
    // It also adds these wages to owner's accumulated salary expenses
    public void workShift(int hours){

        // the method first calculates the earning made by the cook for the number of hours given as argument
        // and adds this value to the income of the cook
        double earningForCurrentShiftCook = (cook.getSalaryPerHour()) * hours;

        double newIncomeOfCook = (cook.getIncome()) + earningForCurrentShiftCook;

        cook.setIncome(newIncomeOfCook);

        // the method now repeats the same task with server
        double earningForCurrentShiftServer = (server.getSalaryPerHour()) * hours;

        double newIncomeOfServer = (server.getIncome()) + earningForCurrentShiftServer;

        server.setIncome(newIncomeOfServer);

        // The method now adds the money given to the server and cook to the previously accumulated
        // salary expenses of the owner

        double newSalaryExpenses = (this.getOwner().getSalaryExpenses()) + (earningForCurrentShiftCook) + (earningForCurrentShiftServer);

        this.getOwner().setSalaryExpenses(newSalaryExpenses);
    }

    // The method getIncomeTaxPayers() returns a list of IncomeTaxPayers that work at that Restaurant
    // namely a cook, server and an owner
    public ArrayList<IncomeTaxPayer> getIncomeTaxPayers(){

        // creating an ArrayList which will store the IncomeTaxPayers
        ArrayList<IncomeTaxPayer> incomeTaxPayersList = new ArrayList<>();

        // adding IncomeTaxPayers to that list
        incomeTaxPayersList.add(0, cook);
        incomeTaxPayersList.add(1, server);
        incomeTaxPayersList.add(2, this.getOwner());

        return incomeTaxPayersList;
    }

    // The method returns nothing (void)
    // In all restaurants, menu price component of the Check object is added to the owner's income
    // tip component is added to the income of the cook (20 %) and to the income of the server (80 %)
    // The method also accumulates the total sales tax
    public void distributeIncomeAndSalesTax(Check check){

        // The method first adds the menu price component of check to the owner's income
        double newOwnerIncome = (this.getOwner().getIncome()) + (check.getMenuPrice());
        this.getOwner().setIncome(newOwnerIncome);

        // The method then adds 20% of the tip from check to the cook income
        // and 80% of the tip to the server
        double newCookIncome = (this.cook.getIncome()) + (0.20 * (check.getTip()));
        this.cook.setIncome(newCookIncome);

        double newServerIncome = (this.server.getIncome()) + (0.80 * (check.getTip()));
        this.server.setIncome(newServerIncome);

        // The method now accumulates the total sales tax which is 15% of the menu price
        // to the totalSalesTax field in FoodPlace
        double accumulatedSalesTax = (check.getSalesTax()) + (this.getTotalSalesTax());
        this.setTotalSalesTax(accumulatedSalesTax);
    }

    // The method returns server's target tip percentage
    public double getTipPercentage(){
        return (server.getTargetTipPct());
    }
}
