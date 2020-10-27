package groupproject484;

import java.util.*;

public class Product {
    // Datafields
    private String productName;
    private double productPrice;
    private String productDescription;
    private int productID;
    private static int nextProductID;
    private String productCategory;
    private String pictureURL;
    
    // Constructors
    public Product(String productName, double productPrice, String productDescription, String category, String URL){
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
        this.productCategory = category;
        this.pictureURL = URL;
        this.productID = nextProductID++;
    }
    
    public Product(int ID, String productName, double productPrice, String productDesc, String category, String URL)
    {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDescription = productDesc;
        this.productID = ID;
        nextProductID = ID + 1;
    }
    public String getName(){
        return this.productName;
    }
    public String getDescription(){
        return this.productDescription;
    }
    public double getPrice(){
        return this.productPrice;
    }
    public int getProductID()
    {
        return this.productID;
    }
    
    public String getURL() {
        return this.pictureURL;
    }
    @Override
    public String toString(){
        String info = "";
        info += "Product ID: " + this.productID + ", Product Name: " + this.productName + " , Product Price: " + this.productPrice +
                " , Product Description: " + this.productDescription;
        return info;
    }
}
