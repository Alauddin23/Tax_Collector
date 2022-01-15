// Check models a customer’s payment
// It is used to specify the menu price, sales tax, and tip

public class Check {

    // private fields
    private double menuPrice;

    private double salesTax;

    private double tip;

    // writing the constructor for the Check class
    public Check(double menuPrice) {
        this.menuPrice = menuPrice;

        this.salesTax = (0.15 * menuPrice);
    }

    // the getMenuPrice() method
    public double getMenuPrice() {
        return (this.menuPrice);
    }

    // the getSalesTax() method
    public double getSalesTax() {
        return (this.salesTax);
    }

    // the setTipByPct(double tipPct) method
    // this method takes one double parameter as input which is the tip percentage between 0 to 100
    // It sets the tip to be that percentage of the menuPrice
    public void setTipByPct(double tipPct) {

        // the tipPct is given as a percentage , for example 10% which is obtained by multiplying 10 with 0.01
        this.tip = (tipPct * 0.01) * menuPrice;
    }

    // the getTip() method
    public double getTip() {
        return (this.tip);
    }
}
