package groupproject484;

import java.util.ArrayList;

public class Supplier {
    // Datafields
    private int ID;
    public static int nextID = 0;
    public String supplierName;
    public String cName;
    public String supplierAddress;
    public String supplierCity;
    public String supplierState;
    public String supplierZip;
    public String contactEmail;
    public String contactPhone;
    
    // Constructor
    public Supplier(String supplierName, String supplierAddress, String supplierCity, String supplierState, String supplierZip, String cName, String contactEmail, String contactPhone){
        this.ID = nextID;
        nextID++;
        this.supplierName = supplierName;
        this.supplierAddress = supplierAddress;
        this.supplierCity = supplierCity;
        this.supplierState = supplierState;
        this.supplierZip = supplierZip;
        this.cName = cName;
        this.contactEmail = contactEmail;
        this.contactPhone = contactPhone;
    }
    public Supplier(int ID, String supplierName, String supplierAddress, String supplierCity, String supplierState, String supplierZip, String cName, String contactEmail, String contactPhone){
        this.ID = ID;
        nextID = ID;
        nextID++;
        this.supplierName = supplierName;
        this.supplierAddress = supplierAddress;
        this.supplierCity = supplierCity;
        this.supplierState = supplierState;
        this.supplierZip = supplierZip;
        this.cName = cName;
        this.contactEmail = contactEmail;
        this.contactPhone = contactPhone;
    }
    // Member Methods
    public void setSupplierName(String name){
        this.supplierName = name;
    }
    public void setSupplierAddress(String address){
        this.supplierAddress = address;
    }
    public void setContactEmail(String email){
        this.contactEmail = email;
    }
    public void setContactPhone(String phone){
        this.contactPhone = phone;
    }
    public String getSupplierName(){
        return this.supplierName;
    }
    public String getSupplierAddress(){
        return this.supplierAddress;
    }
    public String getContactEmail(){
        return this.contactEmail;
    }
    public String getContactPhone(){
        return this.contactPhone;
    } 
    public int getSupplierID(){
        return this.ID;
    }
    public String getContactName(){
        return this.cName;
    }
    @Override
    public String toString(){
        String info = "";
        info += "Supplier #" + this.getSupplierID() + "\n" + "Supplier Name: " + this.supplierName + "\n" +
                "Supplier Address: " + this.supplierAddress + "\n" + 
                "Contact Name: " + this.cName + "\n" +
                "Contact Email: " + this.contactEmail + "\n" +
                "Contact Phone: " + this.contactPhone + "\n";
        return info;
    }
}