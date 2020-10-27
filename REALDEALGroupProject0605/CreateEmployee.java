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

public class CreateEmployee {
    public GroupProject484 parent;
    private String CreateEmployeeID;
    int nextID = 0;
    
    // Controls at Class Level
    Label lblCreateNewEmployee = new Label("-Create New Employee-");
    Label lblFirstName2 = new Label("First Name:");
    TextField txtFirstName2 = new TextField();
    Label lblLastName2 = new Label("Last Name:");
    TextField txtLastName2 = new TextField();
    Label lblPhone2 = new Label("Phone Number:");
    TextField txtPhone2 = new TextField();
    Label lblStreetAddress2 = new Label("Street Address:");
    TextField txtStreetAddress2 = new TextField();
    Label lblCity2 = new Label("City:");
    TextField txtCity2 = new TextField();
    Label lblState2 = new Label("State:");
    TextField txtState2 = new TextField();
    Label lblZip2 = new Label("Zip Code:");
    TextField txtZip2 = new TextField();
    RadioButton rdoSalary = new RadioButton("Salary");
    RadioButton rdoHourly = new RadioButton("Hourly");
    Label lblCompensation = new Label("Compensation:");
    TextField txtCompensation = new TextField();
    Label lblEmployeeType = new Label("Employee Type:");
    ObservableList obsStores = FXCollections.observableArrayList();
    ComboBox<String> cmboStores = new ComboBox<>(obsStores);
    ObservableList obsEmployeeType = FXCollections.observableArrayList();
    ComboBox<String> cmboEmployeeTypes = new ComboBox<>(obsEmployeeType);
    Button btnCreateEmployee = new Button("Create Employee");
    Label lblStore = new Label("Stores: ");
    
    public CreateEmployee(GroupProject484 parentForm, String[] names) {
        this.parent = parentForm;
        this.CreateEmployeeID = "CE" + nextID;
        nextID++;
        obsEmployeeType.add("Regular");
        obsEmployeeType.add("Admin");
        for (String s: names) {
            obsStores.add(s);
        }
        
        GridPane employeePane = new GridPane();
        employeePane.setAlignment(Pos.CENTER);
        employeePane.setVgap(10);
        employeePane.setHgap(10);
        
        // CSS for controls
        employeePane.setStyle("-fx-background-color: lightgrey;");
        lblCreateNewEmployee.setStyle("-fx-font-size: 11pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");
        lblFirstName2.setStyle("-fx-font-size: 11pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");
        lblLastName2.setStyle("-fx-font-size: 11pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");
        lblPhone2.setStyle("-fx-font-size: 11pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");
        lblStreetAddress2.setStyle("-fx-font-size: 11pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");
        lblCity2.setStyle("-fx-font-size: 11pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");
        lblState2.setStyle("-fx-font-size: 11pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");
        lblZip2.setStyle("-fx-font-size: 11pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");
        lblCompensation.setStyle("-fx-font-size: 11pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");
        lblEmployeeType.setStyle("-fx-font-size: 11pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");
        lblStore.setStyle("-fx-font-size: 11pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");
        
        txtFirstName2.setStyle("-fx-font-family: \"Segoe UI Semibold\"; -fx-border-color: black;");
        txtLastName2.setStyle("-fx-font-family: \"Segoe UI Semibold\"; -fx-border-color: black;");
        txtPhone2.setStyle("-fx-font-family: \"Segoe UI Semibold\"; -fx-border-color: black;");
        txtStreetAddress2.setStyle("-fx-font-family: \"Segoe UI Semibold\"; -fx-border-color: black;");
        txtCity2.setStyle("-fx-font-family: \"Segoe UI Semibold\"; -fx-border-color: black;");
        txtState2.setStyle("-fx-font-family: \"Segoe UI Semibold\"; -fx-border-color: black;");
        txtZip2.setStyle("-fx-font-family: \"Segoe UI Semibold\"; -fx-border-color: black;");
        
        btnCreateEmployee.setStyle("-fx-padding: 5 22 5 22; -fx-border-color: #1F39F2; -fx-border-width: 2; -fx-background-radius: 0; -fx-background-color: #ED1C26; -fx-font-family: \"Segoe UI\", Helvetica, Arial, sans-serif; -fx-font-size: 14pt; -fx-text-fill: white; -fx-background-insets: 0 0 0 0, 0, 1, 2; -fx-font-weight: bold;");
        
        ToggleGroup tglPay = new ToggleGroup();
        rdoSalary.setStyle("-fx-font-size: 11pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");
        rdoHourly.setStyle("-fx-font-size: 11pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");
        rdoSalary.setToggleGroup(tglPay);
        rdoHourly.setToggleGroup(tglPay);
        cmboEmployeeTypes.setStyle("-fx-padding: 3 0 2 7; -fx-cell-size: 1.66667em; -fx-font-family: \"Segoe UI Semibold\"; -fx-border-color: black;");
        cmboStores.setStyle("-fx-padding: 3 0 2 7; -fx-cell-size: 1.66667em; -fx-font-family: \"Segoe UI Semibold\"; -fx-border-color: black;");
        
        // Adding controls
        employeePane.add(lblCreateNewEmployee, 1, 1, 2, 1);
        employeePane.add(lblFirstName2, 1, 2);
        employeePane.add(txtFirstName2, 2, 2);
        employeePane.add(lblLastName2, 1, 3);
        employeePane.add(txtLastName2, 2, 3);
        employeePane.add(lblPhone2, 1, 4);
        employeePane.add(txtPhone2, 2, 4);
        employeePane.add(lblStreetAddress2, 1, 5);
        employeePane.add(txtStreetAddress2, 2, 5);
        employeePane.add(lblCity2, 1, 6);
        employeePane.add(txtCity2, 2, 6);
        employeePane.add(lblState2, 1, 7);
        employeePane.add(txtState2, 2, 7);
        employeePane.add(lblZip2, 1, 8);
        employeePane.add(txtZip2, 2, 8);
        employeePane.add(rdoSalary, 1, 9);
        employeePane.add(rdoHourly, 2, 9);
        employeePane.add(lblCompensation, 1, 10);
        employeePane.add(txtCompensation, 2, 10);
        employeePane.add(lblEmployeeType, 1, 11);
        employeePane.add(cmboEmployeeTypes, 2, 11);
        employeePane.add(lblStore, 1, 12);
        employeePane.add(cmboStores, 2, 12);
        employeePane.add(btnCreateEmployee, 1, 13, 2, 1);
        
        Scene primaryScene = new Scene(employeePane, 800, 600);
        Stage primaryStage = new Stage();
        primaryStage.setScene(primaryScene);
        primaryStage.setTitle("Create Employee");
        primaryStage.show();
        primaryStage.setResizable(false);
        
        btnCreateEmployee.setOnAction(e -> {
            String name = txtFirstName2.getText() + " " + txtLastName2.getText();
            String phone = txtPhone2.getText();
            String address = txtStreetAddress2.getText();
            String city = txtCity2.getText();
            String state = txtState2.getText();
            String zip = txtZip2.getText();
            double compensation = Double.parseDouble(txtCompensation.getText());
            int type = cmboEmployeeTypes.getSelectionModel().getSelectedIndex();
            int storeIndex = cmboStores.getSelectionModel().getSelectedIndex();
            boolean isHourly;
            if (rdoSalary.isSelected()) {
                isHourly = false;
            }else if(rdoHourly.isSelected()) {
                isHourly = true;
            } else {
                isHourly = false;
            }
            parent.create_Employee(name, address, city, state, zip, phone, type, storeIndex, isHourly, compensation);
            primaryStage.close();
        });
        
    }
}
