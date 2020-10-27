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

public class CreateClubMember {
    public GroupProject484 parent;
    private String CreateClubMemberID;
    int nextID = 0;
    
    // Controls at class level
    Label lblAddNewMember = new Label("-Add New Thrifty Club Member-");
    Label lblFirstName = new Label("First Name:");
    TextField txtFirstName = new TextField();
    Label lblLastName = new Label("Last Name:");
    TextField txtLastName = new TextField();
    Label lblPhone = new Label("Phone Number:");
    TextField txtPhone = new TextField();
    Label lblStreetAddress = new Label("Street Address:");
    TextField txtStreetAddress = new TextField();
    Label lblCity = new Label("City:");
    TextField txtCity = new TextField();
    Label lblState = new Label("State:");
    TextField txtState = new TextField();
    Label lblZip = new Label("Zip Code:");
    TextField txtZip = new TextField();
    Button btnAddMember = new Button("Add Member");
    
    public CreateClubMember (GroupProject484 parentForm) {
        this.parent = parentForm;
        this.CreateClubMemberID = "CM" + nextID;
        nextID++;
        
        GridPane memberPane = new GridPane();
        memberPane.setAlignment(Pos.CENTER);
        memberPane.setVgap(10);
        memberPane.setHgap(10);
        
        // CSS for create transaction
        memberPane.setStyle("-fx-background-color: lightgrey;");
        lblAddNewMember.setStyle("-fx-font-size: 11pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");
        lblFirstName.setStyle("-fx-font-size: 11pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");
        lblLastName.setStyle("-fx-font-size: 11pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");
        lblPhone.setStyle("-fx-font-size: 11pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");
        lblStreetAddress.setStyle("-fx-font-size: 11pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");
        lblCity.setStyle("-fx-font-size: 11pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");
        lblState.setStyle("-fx-font-size: 11pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");
        lblZip.setStyle("-fx-font-size: 11pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");
        
        txtFirstName.setStyle("-fx-font-family: \"Segoe UI Semibold\"; -fx-border-color: black;");
        txtLastName.setStyle("-fx-font-family: \"Segoe UI Semibold\"; -fx-border-color: black;");
        txtPhone.setStyle("-fx-font-family: \"Segoe UI Semibold\"; -fx-border-color: black;");
        txtStreetAddress.setStyle("-fx-font-family: \"Segoe UI Semibold\"; -fx-border-color: black;");
        txtCity.setStyle("-fx-font-family: \"Segoe UI Semibold\"; -fx-border-color: black;");
        txtState.setStyle("-fx-font-family: \"Segoe UI Semibold\"; -fx-border-color: black;");
        txtZip.setStyle("-fx-font-family: \"Segoe UI Semibold\"; -fx-border-color: black;");
        
        btnAddMember.setStyle("-fx-padding: 5 22 5 22; -fx-border-color: #1F39F2; -fx-border-width: 2; -fx-background-radius: 0; -fx-background-color: #ED1C26; -fx-font-family: \"Segoe UI\", Helvetica, Arial, sans-serif; -fx-font-size: 14pt; -fx-text-fill: white; -fx-background-insets: 0 0 0 0, 0, 1, 2; -fx-font-weight: bold;");
        // Member controls
        memberPane.add(lblAddNewMember, 1, 1, 2, 1);
        memberPane.add(lblFirstName, 1, 2);
        memberPane.add(txtFirstName, 2, 2);
        memberPane.add(lblLastName, 1, 3);
        memberPane.add(txtLastName, 2, 3);
        memberPane.add(lblPhone, 1, 4);
        memberPane.add(txtPhone, 2, 4);
        memberPane.add(lblStreetAddress, 1, 5);
        memberPane.add(txtStreetAddress, 2, 5);
        memberPane.add(lblCity, 1, 6);
        memberPane.add(txtCity, 2, 6);
        memberPane.add(lblState, 1, 7);
        memberPane.add(txtState, 2, 7);
        memberPane.add(lblZip, 1, 8);
        memberPane.add(txtZip, 2, 8);
        memberPane.add(btnAddMember, 2, 9, 2, 1);
        
        Scene primaryScene = new Scene(memberPane, 800, 600);
        Stage primaryStage = new Stage();
        primaryStage.setScene(primaryScene);
        primaryStage.setTitle("Create Thrifty Club Member");
        primaryStage.show();
        primaryStage.setResizable(false);
        
        btnAddMember.setOnAction(e -> {
           String name = txtFirstName.getText() + " " + txtLastName.getText();
           String phone = txtPhone.getText();
           String street = txtStreetAddress.getText();
           String city = txtCity.getText();
           String state = txtState.getText();
           String zip = txtZip.getText();
           
           parent.create_ClubMember(name, phone, street, city, state, zip);
        });
    }
}
