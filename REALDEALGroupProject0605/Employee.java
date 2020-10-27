package groupproject484;

import java.util.ArrayList;


public class Employee {
    //datafields
    private String empName;
    private String empStreet;
    private String empCity;
    private String empState;
    private String empZip;
    private String empPhone;
    private int empType;
    private int empID;
    private boolean isHourly;
    private double compensation;
    private Store store;
    private static int nextID = 0;
    
    //constructor for UI
    public Employee(String empName, String empStreet, String empCity,
            String empState, String empZip, String empPhone, int empType, Store store, boolean isHourly, double compensation)
    {
        this.empName = empName;
        this.empStreet = empStreet;
        this.empCity = empCity;
        this.empState = empState;
        this.empZip = empZip;
        this.empPhone = empPhone;
        this.store = store;
        this.isHourly = isHourly;
        this.compensation = compensation;
        this.empID = nextID;
        nextID++;
    }
    //constructor for database
   public Employee(int empID, String empName, String empStreet, String empCity,
            String empState, String empZip, String empPhone, int empType, Store store, boolean isHourly, double compensation)
    {
        this.empName = empName;
        this.empStreet = empStreet;
        this.empCity = empCity;
        this.empState = empState;
        this.empZip = empZip;
        this.empPhone = empPhone;
        this.empType = empType;
        this.store = store;
        this.empID = empID;
        this.isHourly = isHourly;
        this.compensation = compensation;
        nextID = empID;
        nextID++;
    }
    //member methods
    public int getEmpID(){
        return this.empID;
    }
    
    public String getEmpName(){
        return this.empName;
    }
    
    public void setEmpName(String empName){
        this.empName = empName;
    }
    
    public String getEmpAddress(){
        return this.empStreet + " " + this.empCity + ", " + this.empState + " " 
                + this.empZip;
    }
    
    public void setEmpStreet(String empStreet){
        this.empStreet = empStreet;
    }
    
    public void setEmpCity(String empCity){
        this.empCity = empCity;
    }
    
     public void setEmpState(String empState) {
        this.empState = empState;
    }
    
    public void setEmpZip(String empZip) {
        this.empZip = empZip;
    }

    public String getEmpPhone() {
        return this.empPhone;
    }

    public void setEmpPhone(String empPhone) {
        this.empPhone = empPhone;
    }

    public int getEmpType() {
        return this.empType;
    }

    public void setEmpType(int empType) {
        this.empType = empType;
    }
    
    @Override
    public String toString(){
        return "Employee ID: " + this.getEmpID() + "\n" + 
                "Employee Name: " + this.getEmpName() + "\n" +
                "Employee Address: " + this.getEmpAddress() + "\n" + 
                "Employee Phone: " + this.getEmpPhone() + "\n" + 
                "Employee Type: " + this.getEmpType();
    }
    /*  */
    
    
    
}
