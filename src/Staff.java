public class Staff extends IncomeTaxPayer{

    // private fields
    private int salaryPerHour;

    final private int incomeTaxPercentage = 25;

    // the constructor for the class Staff
    public Staff(String name, boolean isCook){

        // calling the super method as Staff is also an IncomeTaxPayer
        super(name);

        // if the boolean isCook is true, then the staff is a cook and they are paid 20 dollars per hour
        if (isCook){
            this.salaryPerHour = 20;
        }
        // if the boolean isCook is not true, then the staff is not a cook and they are paid 10 dollars per hour
        else{
            this.salaryPerHour = 10;
        }

    }

    // writing the getSalaryPerHour() method
    public int getSalaryPerHour(){
        return (this.salaryPerHour);
    }

    // writing the getIncomeTaxPercentage() method
    public int getIncomeTaxPercentage(){
        return (this.incomeTaxPercentage);
    }

    // The method workHours() returns the amount of money earned by that staff for the shift given as input
    // and modifies that staff’s income
    // The parameter of this method is the number of hours worked in a shift; whenever a staff works this
    // number of hours, the staff’s income increases
    public double workHours(int numHours){
        double salaryForThisShift = (this.salaryPerHour * numHours);

        // First, we add this to the previously accumulated staff income
        double accumulatedIncome = super.getIncome() + salaryForThisShift;
        super.setIncome(accumulatedIncome);

        // Then, we return the amount of money earned by the staff for this shift
        return (salaryForThisShift);
    }

    // writing the calculateIncomeTax() method
    public double calculateIncomeTax(){
        return (this.incomeTaxPercentage * 0.01 * super.getIncome());
    }
}