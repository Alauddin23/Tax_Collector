import java.util.ArrayList;
import java.util.List;

// The FastFood class is a subclass of FoodPlace class
public class FastFood extends FoodPlace{

    // the class FastFood has one private field
    private List<Staff> staff;

    // writing the constructor of the FastFood class
    public FastFood(String name, double fixedCosts, Owner owner, List<Staff> staff){
        super(name, fixedCosts, owner);

        // The constructor now copies all the element of List staff and places it in a new list
        // This causes the shallow copy
        List<Staff> staffClone = new ArrayList<>();
        for (Staff staffObject : staff){

            // The method first gets the index of the staff object being iterated and adds that object
            // to the appropriate index in the new list
            int index = staff.indexOf(staffObject);
            staffClone.add(index, staffObject);

        }

        this.staff = staffClone;
    }

    // writing the getStaff() method
    public List<Staff> getStaff(){
        return (this.staff);
    }

    // writing the toString() method
    public String toString(){
        return ("Number of staffs working in the FastFood shop: " + this.staff.size());
    }

    // The method returns nothing
    // This method models that the owner pays each staff an hourly wage
    // This method adds an amount to each staff's income and adds the amount to owner's total salary expenses
    public void workShift(int hours){

        // The method iterates through staff which is a list of Staff objects
        // For each Staff object, the workHours method is called which takes hours as argument
        // and increases the income of that staff and also returns the money earned by that staff during that shift
        for (Staff staffObject : this.staff){

            double incomeEarnedByStaffThisShift = staffObject.workHours(hours);

            // The amount paid to each staff is added to the owner's total salary expenses
            double newSalaryExpense = (this.getOwner().getSalaryExpenses()) + incomeEarnedByStaffThisShift;
            this.getOwner().setSalaryExpenses(newSalaryExpense);
        }
    }

    // The method returns an ArrayList that includes owner and all the staff members in any order
    // The method returns a shallow copy of this list
    public ArrayList<IncomeTaxPayer> getIncomeTaxPayers(){

        ArrayList<IncomeTaxPayer> incomeTaxPayerArrayList = new ArrayList<>();

        for (Staff staffObject : this.staff){

            // The method first gets the index of staffObject in staff and adds the object in the same index in
            // incomeTaxPayerArrayList
            int index = this.staff.indexOf(staffObject);
            incomeTaxPayerArrayList.add(index, staffObject);
        }

        // The method then adds the owner to the ArrayList
        int indexOfOwner = this.staff.size();
        incomeTaxPayerArrayList.add(indexOfOwner, this.getOwner());

        // The method now creates a clone for incomeTaxPayerArrayList and returns that list
        ArrayList<IncomeTaxPayer> incomeTaxPayerArrayListClone = new ArrayList<>();

        for (IncomeTaxPayer incomeTaxPayerObject : incomeTaxPayerArrayList){

            int index = incomeTaxPayerArrayList.indexOf(incomeTaxPayerObject);
            incomeTaxPayerArrayListClone.add(index, incomeTaxPayerObject);
        }

        return (incomeTaxPayerArrayListClone);
    }

    // The method returns nothing
    // The method adds the menu price component of check to the owner's income
    // It is possible to have tips, but it depends on customers
    // The tip is split between all staffs equally
    // The method also updates the total sales tax
    public void distributeIncomeAndSalesTax(Check check){

        // The method first adds the menu price component of the check to the owner's income
        double newOwnerIncome = (this.getOwner().getIncome()) + (check.getMenuPrice());
        this.getOwner().setIncome(newOwnerIncome);

        // The tip is split between all staff equally (excluding owner)
        // First we calculate the number of staffs, and then we divide the tip by the number of staffs
        // to get the tip for each of the staff
        int numberOfStaff = staff.size();
        double tipForEachStaff = (check.getTip()) / (numberOfStaff);

        // The tip is then added to the income of each of the staff member
        for (Staff staffObject : staff){

            double newStaffIncome = (staffObject.getIncome())+ (tipForEachStaff);
            staffObject.setIncome(newStaffIncome);
        }

        // The method then updates the total sales tax
        double accumulatedSalesTax = (this.getTotalSalesTax()) + (check.getSalesTax());
        this.setTotalSalesTax(accumulatedSalesTax);

    }

    // writing the method getTipPercentage() which returns 0 as in FastFood no tip percentage
    public double getTipPercentage(){
        return 0;
    }
}