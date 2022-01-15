// These class looks at various types of people that work in these food places
// They are all income tax payers

public abstract class IncomeTaxPayer{

    // it has one static field
    private static int currentMaxTaxID = 0;

    // the private fields of this class
    private int taxID;

    private String name;

    private double income;

    // the constructor method for the abstract class IncomeTaxPayer

    public IncomeTaxPayer(String name){

        // Each time an IncomeTaxPayer object is created, the value of currentMaxTaxID is increased by 1
        // Then that particular IncomeTaxPayer object is assigned that unique value as its taxID
        currentMaxTaxID++;
        this.name = name;
        this.taxID = currentMaxTaxID;
    }

    // the getCurrentMaxTaxID method
    public static int getCurrentMaxTaxID(){
        return currentMaxTaxID;
    }

    // the getTaxID method
    public int getTaxID(){
        return (this.taxID);
    }

    // the getName method
    public String getName() {
        return (this.name);
    }

    // the getIncome method
    public double getIncome(){
        return (this.income);
    }

    // the setIncome method, which takes as argument one input which is an income value of type double
    public void setIncome(double income){
        this.income = income;
    }

    // writing the toString() method
    // this method overwrites Object.toString() method
    public String toString(){
        return("Name: " + this.name + ", taxID: " + this.taxID + ", Income: " + this.income);
    }

    // writing the equals(obj:Object) method
    // This method returns true if the argument is indeed an IncomeTaxPayer and if the id’s match
    // and otherwise returns false
    // It is not required to match names as to IncomeTaxPayers can have same name but not same id
    public boolean equals(Object obj){

        // the method first checks whether the argument is an IncomeTaxPayer or not
        if (obj instanceof IncomeTaxPayer){
            // the method now checks whether the object which is an IncomeTaxPayer has the same id as the
            // object it is called upon
            if (this.taxID == ((IncomeTaxPayer) obj).taxID){
                return true;
            }
        }

        return false;
   }

   // writing the abstract method calculateIncomeTax(public abstract double calculateIncomeTax();
}
