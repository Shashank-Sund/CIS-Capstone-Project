
package groupproject484;
import java.util.ArrayList;

public class Store {
    
    //DATA FIELDS
    private int store_ID;
    private String store_name;
    private String store_street;
    private String store_city;
    private String store_state;
    private String store_zip;
    private static int nextID = 0;

    public ArrayList<Product> inventoryProducts = new ArrayList<>();
    public ArrayList<Integer> associatedQuantity = new ArrayList<>();
    public ArrayList<Supplier> associatedSuppliers = new ArrayList<>();
    
    //CONSTRUCTORS
    public Store(String name, String street, String city, String state, String zip)
    {
        this.store_name = name;
        
        //street and city adding
        this.store_street = street;
        this.store_city = city;
        

            this.store_state = state;

            this.store_zip = zip;

        
        //add the current object to array and give them an ID
        this.store_ID = nextID;
        nextID++;
    }
    
    public Store(int ID, String name, String street, String city, String state, String zip)
    {
        this.store_name = name;
        this.store_street = street;
        this.store_city = city;
        this.store_state = state;
        this.store_zip = zip;
        this.store_ID = ID;
        nextID = ID;
        nextID++;
        
    }
    
    //GETTERS
    public int getStoreID(){
        return this.store_ID;
    }
    
    public String getStoreName(){
        return this.store_name;
    }
    
    public String getAddress(){
        String addy = this.store_street + ", " + this.store_city + ", " + this.store_state + ", " + this.store_zip;
        return addy;
    }
    
    //SETTERS

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }

    public void setStore_street(String store_street) {
        this.store_street = store_street;
    }

    public void setStore_city(String store_city) {
        this.store_city = store_city;
    }

    public void setStore_state(String state) {
        if(state.length() == 2)
            this.store_state = state;
        else{}
    }

    public void setStore_zip(String zip) {
        if(zip.length() == 5)
            this.store_zip = zip;
        else{}
    }
    
    public void increaseProduct(Product prod, int qty, Supplier supp) {
        boolean found = false;
        int index = 0;
        if (!inventoryProducts.contains(prod)){
            inventoryProducts.add(prod);
            associatedQuantity.add(qty);
            associatedSuppliers.add(supp);
        } else {
            for (int i = 0; i < inventoryProducts.size(); i++) {
                if (inventoryProducts.get(i).equals(prod)) {
                    index = i;
                    if (associatedSuppliers.get(i).equals(supp)) {
                        int previousQty = associatedQuantity.get(i);
                        int nextQty = previousQty + qty;
                        associatedQuantity.remove(i);
                        associatedQuantity.add(i, nextQty);
                        found = true;
                    }
            }
            }
            if (!found) {
                inventoryProducts.add(index+1,prod);
                associatedQuantity.add(index+1,qty);
                associatedSuppliers.add(index+1,supp); 
            } 
    }
    }
    
    public void decreaseProduct(Product prod, int qty, Supplier supp) {
        boolean found = false;
        int index = 0;
        if (!inventoryProducts.contains(prod)){
            qty = 0;
            inventoryProducts.add(prod);
            associatedQuantity.add(qty);
            associatedSuppliers.add(supp);
        } else {
            for (int i = 0; i < inventoryProducts.size(); i++) {
                if (inventoryProducts.get(i).equals(prod)) {
                    index = i;
                    if (associatedSuppliers.get(i).equals(supp)) {
                        int previousQty = associatedQuantity.get(i);
                        int nextQty = previousQty - qty;
                        if (nextQty < 0) {
                            nextQty =0;
                        } 
                        associatedQuantity.remove(i);
                        associatedQuantity.add(i, nextQty);
                        found = true;
                    }
            }
            }
            if (!found) {
                inventoryProducts.add(index+1,prod);
                associatedQuantity.add(index+1,-qty);
                associatedSuppliers.add(index+1,supp); 
            } 
    }   
    }
      
    
    //MEMBER METHODS
    public String toString()
    {
        String out = "Store ID: " + this.getStoreID() + "\n" +
                     "Store Name: " + this.getStoreName() + "\n" +
                     "Address: " + this.getAddress();     
        return out;
    }
    
}