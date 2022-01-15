// creating the class Customer

public class Customer {

    // private fields
    private String name;

    private int targetTipPct;

    // writing the constructor method for the class Customer
    public Customer(String name, int targetTipPct){

        this.name = name;

        this.targetTipPct = targetTipPct;
    }

    // writing the getName() method
    public String getName(){
        return (this.name);
    }

    // writing the getTargetTipPct() method
    public int getTargetTipPct(){
        return (this.targetTipPct);
    }

    // writing the getDescriptiveMessage(FoodPlace foodPlace) method
    public String getDescriptiveMessage(FoodPlace foodPlace){
        return (this.name + " dined in " + foodPlace.getName());
    }

    // The method returns nothing
    // The idea of this method is customer visits FoodPlace - eats and pays the check
    // The tip calculation and the way payment is distributed depends on FoodPlace
    // The method constructs a new Check
    // The method calculates the tip of the check by taking the average of target tip of the customer
    // and the FoodPlace's tip percentage returned by getTipPercentage() method
    public void dineAndPayCheck(FoodPlace foodPlace, double menuPrice){

        // The method first creates a new check object
        Check check = new Check(menuPrice);

        // The method now calculates the tip percentage
        double tipPercentage = ((this.getTargetTipPct()) + (foodPlace.getTipPercentage())) / 2;

        // The method new sets the tip fields of the Check class using the setTipByPct(double tipPct) method
        check.setTipByPct(tipPercentage);

        // The method now distributes the earning of this check using the FoodPlace's distributeIncomeAndSalesTax method
        foodPlace.distributeIncomeAndSalesTax(check);
    }
}
