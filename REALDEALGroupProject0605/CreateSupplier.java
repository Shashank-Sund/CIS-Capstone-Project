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

public class CreateSupplier {
    public GroupProject484 parent;
    private String CreateSupplierID;
    int nextID = 0;
    
    // Controls at class level
    Label lblCreateSupplier = new Label("-Create Supplier-");
    Label lblSupplierName = new Label("Supplier Name:");
    TextField txtSupplierName = new TextField();
    Label lblStreetAddress3 = new Label("Street Address:");
    TextField txtStreetAddress3 = new TextField();
    Label lblCity3 = new Label("City:");
    TextField txtCity3 = new TextField();
    Label lblState3 = new Label("State:");
    TextField txtState3 = new TextField();
    Label lblZip3 = new Label("Zip Code:");
    TextField txtZip3 = new TextField();
    Label lblSupplierContactName = new Label("Contact Name:");
    TextField txtSupplierContactName = new TextField();
    Label lblSupplierContactPhone = new Label("Contact Phone:");
    TextField txtSupplierContactPhone = new TextField();
    Label lblSupplierContactEmail = new Label("Contact Email:");
    TextField txtSupplierContactEmail = new TextField();
    Button btnCreateSupplier = new Button("Create Supplier");
    
    public CreateSupplier(GroupProject484 parentForm) {
        this.parent = parentForm;
        this.CreateSupplierID = "CS" + nextID;
        nextID++;
        
        GridPane supplierPane = new GridPane();
        supplierPane.setAlignment(Pos.CENTER);
        supplierPane.setVgap(10);
        supplierPane.setHgap(10);
        
        // CSS controls
        supplierPane.setStyle("-fx-background-color: lightgrey;");
        lblCreateSupplier.setStyle("-fx-font-size: 11pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");
        lblSupplierName.setStyle("-fx-font-size: 11pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");
        lblStreetAddress3.setStyle("-fx-font-size: 11pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");
        lblCity3.setStyle("-fx-font-size: 11pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");
        lblState3.setStyle("-fx-font-size: 11pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");
        lblZip3.setStyle("-fx-font-size: 11pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");
        lblSupplierContactName.setStyle("-fx-font-size: 11pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");
        lblSupplierContactPhone.setStyle("-fx-font-size: 11pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");
        lblSupplierContactEmail.setStyle("-fx-font-size: 11pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");
        
        txtSupplierName.setStyle("-fx-font-family: \"Segoe UI Semibold\"; -fx-border-color: black;");
        txtStreetAddress3.setStyle("-fx-font-family: \"Segoe UI Semibold\"; -fx-border-color: black;");
        txtCity3.setStyle("-fx-font-family: \"Segoe UI Semibold\"; -fx-border-color: black;");
        txtState3.setStyle("-fx-font-family: \"Segoe UI Semibold\"; -fx-border-color: black;");
        txtZip3.setStyle("-fx-font-family: \"Segoe UI Semibold\"; -fx-border-color: black;");
        txtSupplierContactName.setStyle("-fx-font-family: \"Segoe UI Semibold\"; -fx-border-color: black;");
        txtSupplierContactPhone.setStyle("-fx-font-family: \"Segoe UI Semibold\"; -fx-border-color: black;");
        txtSupplierContactEmail.setStyle("-fx-font-family: \"Segoe UI Semibold\"; -fx-border-color: black;");
        
        btnCreateSupplier.setStyle("-fx-padding: 5 22 5 22; -fx-border-color: #1F39F2; -fx-border-width: 2; -fx-background-radius: 0; -fx-background-color: #ED1C26; -fx-font-family: \"Segoe UI\", Helvetica, Arial, sans-serif; -fx-font-size: 14pt; -fx-text-fill: white; -fx-background-insets: 0 0 0 0, 0, 1, 2; -fx-font-weight: bold;");
    
        // Supplier controls
        supplierPane.add(lblCreateSupplier, 1, 1, 2, 1);
        supplierPane.add(lblSupplierName, 1, 2);
        supplierPane.add(txtSupplierName, 2, 2);
        supplierPane.add(lblStreetAddress3, 1, 3);
        supplierPane.add(txtStreetAddress3, 2, 3);
        supplierPane.add(lblCity3, 1, 4);
        supplierPane.add(txtCity3, 2, 4);
        supplierPane.add(lblState3, 1, 5);
        supplierPane.add(txtState3, 2, 5);
        supplierPane.add(lblZip3, 1, 6);
        supplierPane.add(txtZip3, 2, 6);
        supplierPane.add(lblSupplierContactName, 1, 7);
        supplierPane.add(txtSupplierContactName, 2, 7);
        supplierPane.add(lblSupplierContactPhone, 1, 8);
        supplierPane.add(txtSupplierContactPhone, 2, 8);
        supplierPane.add(lblSupplierContactEmail, 1, 9);
        supplierPane.add(txtSupplierContactEmail, 2, 9);
        supplierPane.add(btnCreateSupplier, 1, 10, 2, 1);
        
        Scene primaryScene = new Scene(supplierPane, 800, 600);
        Stage primaryStage = new Stage();
        primaryStage.setScene(primaryScene);
        primaryStage.setTitle("Create Supplier");
        primaryStage.show();
        primaryStage.setResizable(false);
        
        btnCreateSupplier.setOnAction(e -> {
            String name = txtSupplierName.getText();
            String address = txtStreetAddress3.getText();
            String city = txtCity3.getText();
            String state = txtState3.getText();
            String zip = txtZip3.getText();
            String contactName = txtSupplierContactName.getText();
            String contactPhone = txtSupplierContactPhone.getText();
            String contactEmail = txtSupplierContactEmail.getText();
            parent.create_Supplier(name, address, city, state, zip, contactName, contactPhone, contactEmail);
            primaryStage.close();
        });
                
                
        
    }    
}
