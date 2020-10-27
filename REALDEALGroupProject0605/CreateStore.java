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

public class CreateStore {
    public GroupProject484 parent;
    private String CreateStoreID;
    int nextID = 0;
    
    // Store controls
    Label lblCreateStore = new Label("-Create Store-");
    Label lblStoreName = new Label("Store Name:");
    TextField txtStoreName = new TextField();
    Label lblStreetAddress4 = new Label("Street Address:");
    TextField txtStreetAddress4 = new TextField();
    Label lblCity4 = new Label("City:");
    TextField txtCity4 = new TextField();
    Label lblState4 = new Label("State:");
    TextField txtState4 = new TextField();
    Label lblZip4 = new Label("Zip Code:");
    TextField txtZip4 = new TextField();
    Button btnCreateStore = new Button("Create Store");
    
    public CreateStore(GroupProject484 parentForm) {
        this.parent = parentForm;
        this.CreateStoreID = "CST" + nextID;
        nextID++;
        
        GridPane storePane = new GridPane();
        storePane.setAlignment(Pos.CENTER);
        storePane.setVgap(10);
        storePane.setHgap(10);
        
        //CSS controls
        storePane.setStyle("-fx-background-color: lightgrey;");
        lblCreateStore.setStyle("-fx-font-size: 11pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");
        lblStoreName.setStyle("-fx-font-size: 11pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");
        lblStreetAddress4.setStyle("-fx-font-size: 11pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");
        lblCity4.setStyle("-fx-font-size: 11pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");
        lblState4.setStyle("-fx-font-size: 11pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");
        lblZip4.setStyle("-fx-font-size: 11pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");
        
        txtStoreName.setStyle("-fx-font-family: \"Segoe UI Semibold\"; -fx-border-color: black;");
        txtStreetAddress4.setStyle("-fx-font-family: \"Segoe UI Semibold\"; -fx-border-color: black;");
        txtCity4.setStyle("-fx-font-family: \"Segoe UI Semibold\"; -fx-border-color: black;");
        txtState4.setStyle("-fx-font-family: \"Segoe UI Semibold\"; -fx-border-color: black;");
        txtZip4.setStyle("-fx-font-family: \"Segoe UI Semibold\"; -fx-border-color: black;");
        
        btnCreateStore.setStyle("-fx-padding: 5 22 5 22; -fx-border-color: #1F39F2; -fx-border-width: 2; -fx-background-radius: 0; -fx-background-color: #ED1C26; -fx-font-family: \"Segoe UI\", Helvetica, Arial, sans-serif; -fx-font-size: 14pt; -fx-text-fill: white; -fx-background-insets: 0 0 0 0, 0, 1, 2; -fx-font-weight: bold;");
        
        // Store controls 
        storePane.add(lblCreateStore, 1, 1, 2, 1);
        storePane.add(lblStoreName, 1, 2);
        storePane.add(txtStoreName, 2, 2);
        storePane.add(lblStreetAddress4, 1, 3);
        storePane.add(txtStreetAddress4, 2, 3);
        storePane.add(lblCity4, 1, 4);
        storePane.add(txtCity4, 2, 4);
        storePane.add(lblState4, 1, 5);
        storePane.add(txtState4, 2, 5);
        storePane.add(lblZip4, 1, 6);
        storePane.add(txtZip4, 2, 6);
        storePane.add(btnCreateStore, 1, 7, 2, 1);
        
        Scene primaryScene = new Scene(storePane, 800, 600);
        Stage primaryStage = new Stage();
        primaryStage.setScene(primaryScene);
        primaryStage.setTitle("Create Store");
        primaryStage.show();
        primaryStage.setResizable(false);
        
        btnCreateStore.setOnAction(e -> {
            String name = txtStoreName.getText();
            String street = txtStreetAddress4.getText();
            String city = txtCity4.getText();
            String state = txtState4.getText();
            String zip = txtZip4.getText();
            
            parent.create_Store(name,street,city,state,zip);
            primaryStage.close();
        });
    }    
}
