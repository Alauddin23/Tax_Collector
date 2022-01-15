import java.util.List;

// The program models part of a food service industry
// First, we model places where customers can buy food : Restaurant,// creating an abstract class called FoodPlace
public abstract class FoodPlace {

    // has a static field, at any given time this is the largest ID of any FoodPlace
    // When a new FoodPlace is initiated, the value of this variable is incremented, and it becomes ID of this
    // new FoodPlace
    private static int currentMaxFoodPlaceID = 0;

    // The value of the currentMaxFoodPlaceID is initiated with 0
    // During the creation of each FoodPlace the value of this field is incremented by 1 and that value is
    // the id of this new FoodPlace, this is done inside constructor

    // it has several private fields
    private int foodPlaceID;

    private String name;

    private double fixedCosts;

    private double totalSalesTax;

    private Owner owner ;

    // writing the constructor method for the class FoodPlace
    public FoodPlace(String name, double fixedCosts, Owner owner) {
        currentMaxFoodPlaceID++; // this makes sure the first FoodPlace object has id of 1
        this.name = name;
        this.fixedCosts = fixedCosts;
        this.owner = owner;
        this.foodPlaceID = currentMaxFoodPlaceID;
        this.owner.setFoodPlace(this);
    }

    // writing the getCurrentMaxFoodPlaceID() method
    public static int getCurrentMaxFoodPlaceID(){
        return currentMaxFoodPlaceID;
    }

    // writing the getFoodPlaceID() method
    public int getFoodPlaceID(){
        return (this.foodPlaceID);
    }

    // writing the getName() method
    public String getName(){
        return (this.name);
    }

    // writing the getFixedCosts() method
    public double getFixedCosts(){
        return (this.fixedCosts);
    }

    // writing the getTotalSalesTax() method
    public double getTotalSalesTax(){
        return (this.totalSalesTax);
    }

    // writing the setTotalSalesTax(double totalSalesTax) method
    public void setTotalSalesTax(double totalSalesTax){
        this.totalSalesTax = totalSalesTax;
    }

    // writing the getOwner() method
    public Owner getOwner(){
        return (this.owner);
    }

    // writing the equals(Object obj) method
    // This method returns true if the argument object is indeed a FoodPlace and the foodPlaceID's match
    // and false otherwise
    public boolean equals(Object obj){

        // the method first checks whether the argument obj is a FoodPlace or not
        if (obj instanceof FoodPlace){

            // the method then checks whether the foodPlaceID of this argument matches the foodPlaceID of the
            // object it is called upon
            if (this.foodPlaceID == ((FoodPlace) obj).foodPlaceID){
                return true;
            }
        }

        // else, the method returns false
        return false;
    }

    // writing the abstract methods

    public abstract void workShift(int hours);

    public abstract List<IncomeTaxPayer> getIncomeTaxPayers();

    public abstract void distributeIncomeAndSalesTax(Check check);

    public abstract double getTipPercentage();




}
