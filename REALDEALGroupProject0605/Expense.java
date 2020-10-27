
package groupproject484;

public class Expense {
    private int ID;
    private static int nextID = 0;
    private boolean isYearly;
    private double amount;
    private String name;
    
    public Expense(String name, double ammount, boolean isYearly) {
        this.name = name;
        this.amount = ammount;
        this.isYearly = isYearly;
    }
    
    public Expense(int ID, String name, double ammount, boolean isYearly) {
        this.name = name;
        this.amount = ammount;
        this.isYearly = isYearly;
        this.ID = ID;
        nextID = ID;
        nextID++;
    }
    
    public String getName() {
        return this.name;
    }
    
    public double getAmount() {
        return this.amount;
    }
    
    public boolean getIsYearly() {
        return this.isYearly;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setAmount(double amt) {
        this.amount = amt;
    }
    
    public void setIsYearly(boolean isYearly) {
        this.isYearly = isYearly;
    }
    
}
