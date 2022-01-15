public class Server extends Staff{

    // private fields
    private int targetTipPct;

    // calling the constructor method for the class Server
    public Server(String name, int targetTipPct){

        // calling the super method as Server is also a Staff
        super(name, false);

        this.targetTipPct = targetTipPct;
    }

    // writing the getTargetTipPct() method
    public int getTargetTipPct(){
        return (this.targetTipPct);
    }
}
