package groupproject484;

import javafx.application.Application;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.*;
import javafx.collections.*;
import javafx.geometry.Pos;

public class CreateProduct {
    public GroupProject484 parent;
    private String CreateProductID;
    int nextID = 0;
    
    // Controls at Class Level
    Label lblCreateProduct = new Label("-Create Product-");
    Label lblProductName = new Label("Product Name:");
    TextField txtProductName = new TextField();
    Label lblPrice = new Label("Product Price:");
    TextField txtPrice = new TextField();
    Label lblPictureURL = new Label("Picture URL:");
    TextField txtPictureURL = new TextField();
    Button btnCreateProduct = new Button("Create Product");
    Label lblProductDescription = new Label("Product Description:");
    TextField txtProductDescription = new TextField();
    Label lblProductCategory = new Label("Product Category:");
    TextField txtProductCategory = new TextField();
    
    public CreateProduct(GroupProject484 parentForm) {
        this.parent = parentForm;
        this.CreateProductID = "CP" + nextID;
        nextID++;
        
        GridPane productPane = new GridPane();
        productPane.setAlignment(Pos.CENTER);
        productPane.setVgap(10);
        productPane.setHgap(10);
        
        // CSS controls
        productPane.setStyle("-fx-background-color: lightgrey;");
        lblCreateProduct.setStyle("-fx-font-size: 11pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");
        lblProductName.setStyle("-fx-font-size: 11pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");
        lblPrice.setStyle("-fx-font-size: 11pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");
        lblPictureURL.setStyle("-fx-font-size: 11pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");
        lblProductDescription.setStyle("-fx-font-size: 11pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");
        lblProductCategory.setStyle("-fx-font-size: 11pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");
        
        txtProductName.setStyle("-fx-font-family: \"Segoe UI Semibold\"; -fx-border-color: black;");
        txtPrice.setStyle("-fx-font-family: \"Segoe UI Semibold\"; -fx-border-color: black;");
        txtPictureURL.setStyle("-fx-font-family: \"Segoe UI Semibold\"; -fx-border-color: black;");
        txtProductDescription.setStyle("-fx-font-family: \"Segoe UI Semibold\"; -fx-border-color: black;");
        txtProductCategory.setStyle("-fx-font-family: \"Segoe UI Semibold\"; -fx-border-color: black;");
        
        btnCreateProduct.setStyle("-fx-padding: 5 22 5 22; -fx-border-color: #1F39F2; -fx-border-width: 2; -fx-background-radius: 0; -fx-background-color: #ED1C26; -fx-font-family: \"Segoe UI\", Helvetica, Arial, sans-serif; -fx-font-size: 14pt; -fx-text-fill: white; -fx-background-insets: 0 0 0 0, 0, 1, 2; -fx-font-weight: bold;");
    
        productPane.add(lblCreateProduct, 0, 0, 2 ,1); 
        productPane.add(lblProductName, 0, 1);
        productPane.add(txtProductName, 1, 1);
        productPane.add(lblPrice, 0, 2);
        productPane.add(txtPrice, 1, 2);
        productPane.add(lblProductDescription, 0, 3);
        productPane.add(txtProductDescription, 1, 3);
        productPane.add(lblProductCategory, 0, 4);
        productPane.add(txtProductCategory, 1, 4);
        productPane.add(lblPictureURL, 0, 5);
        productPane.add(txtPictureURL, 1, 5);
        productPane.add(btnCreateProduct, 0, 6, 2, 1);
        
        Scene primaryScene = new Scene(productPane, 800, 600);
        Stage primaryStage = new Stage();
        primaryStage.setScene(primaryScene);
        primaryStage.setTitle("Create Product");
        primaryStage.show();
        primaryStage.setResizable(false);
        
        btnCreateProduct.setOnAction(e -> {
            if (productValid()) {
                String name = txtProductName.getText();
                double price = Double.parseDouble(txtPrice.getText());
                String desc = txtProductDescription.getText();
                String category = txtProductCategory.getText();
                String picURL = txtPictureURL.getText();
                
                parent.create_Product(name,price,desc,category,picURL);
                primaryStage.close();
            } else {
                displayAlert("Error", "Invalid Entry", "Please Enter Valid Product!");
            }
        });
    }
        // Display Alert
    public void displayAlert(String title, String header, String context) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(context);
        alert.showAndWait();
    }
    
    public boolean productValid() {
        return true;
    }
    
}
