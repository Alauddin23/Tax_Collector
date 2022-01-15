public class Owner extends IncomeTaxPayer{

    // private fields
    private int incomeTaxPct;

    private double salaryExpenses;

    private FoodPlace foodPlace;

    // calling the constructor method for the class Owner
    public Owner(String name){
        // using the method super as Owner is also an IncomeTaxPayer
        super(name);
    }

    // writing the getIncomeTaxPct() method
    public int getIncomeTaxPct(){
        return (this.incomeTaxPct);
    }

    // writing the getSalaryExpenses() method
    public double getSalaryExpenses(){
        return (this.salaryExpenses);
    }

    // writing the setSalaryExpenses(double salaryExpenses) method
    public void setSalaryExpenses(double salaryExpenses){
        this.salaryExpenses = salaryExpenses;
    }

    // writing the getFoodPlace() method
    public FoodPlace getFoodPlace(){
        return (this.foodPlace);
    }

    // writing the setFoodPlace(FoodPlace foodPlace) method
    public void setFoodPlace(FoodPlace foodPlace){
        this.foodPlace = foodPlace;
    }

    // writing the calculateIncomeTax() method
    // the method returns the amount of tax the owner needs to pay based on owner's expenses and income
    // owner's income : sum of menu prices on all customer's checks
    // owner's expenses : hourly wages paid to stuff + certain fixed costs for running the restaurant

    // owner's income tax is 10 % of the difference between owner's income and owner's expenses if
    // owner's income is greater, otherwise owner's income tax is just 0
    public double calculateIncomeTax(){

        // owner's income
        double ownerIncome = super.getIncome();

        // owner's expenses
        double ownerSalaryExpenses = this.getSalaryExpenses();

        double ownerFixedCosts = this.foodPlace.getFixedCosts();

        double ownerExpenses = ownerSalaryExpenses + ownerFixedCosts;

        // The owner's income tax is 10% of the difference between owner income and owner expenses
        // given that owner's income is greater than owner expenses
        // otherwise, income tax is 0
        if (ownerIncome > ownerExpenses){

            double differenceOfIncomeAndExpense = ownerIncome - ownerExpenses;
            return (0.10 * differenceOfIncomeAndExpense);
        }

        return (0.0);

    }
}
