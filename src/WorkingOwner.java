public class WorkingOwner extends Owner {

    // private fields
    private int targetTipPct;

    // writing the constructor for the class WorkingOwner
    public WorkingOwner(String name, int targetTipPct){
        super(name);
        this.targetTipPct = targetTipPct;
    }

    // writing the getTargetTipPct() method
    public int getTargetTipPct(){
        return (this.targetTipPct);
    }
}
