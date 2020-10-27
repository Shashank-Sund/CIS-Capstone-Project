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

public class CreateExpense {
    public GroupProject484 parent;
    private String CreateExpenseID;
    int nextID = 0;
    
    // Expense controls
    Label lblCreateNewExpense = new Label("-Create New Expense-");
    Label lblExpenseName = new Label("Expense Name:");
    TextField txtExpenseName = new TextField();
    Label lblExpenseAmount = new Label("Expense Amount:");
    TextField txtExpenseAmount = new TextField();
    ToggleGroup tglPaytime = new ToggleGroup();
    RadioButton rdoYearly = new RadioButton("Yearly");
    RadioButton rdoMonthly = new RadioButton("Monthly");
    Button btnCreateExpense = new Button("Create Expense");
    Label lblRemoveExpense = new Label("-Remove Expense-");
    Label lblExpenses = new Label("Expenses:");
    ObservableList obsExpenses = FXCollections.observableArrayList();
    ComboBox<String> cmboExpenses = new ComboBox<>(obsExpenses);
    Button btnRemoveExpense = new Button("Remove Expense");
    TextArea expenses = new TextArea();
    
    public CreateExpense(GroupProject484 parentForm) {
        this.parent = parentForm;
        this.CreateExpenseID = "CE" + nextID;
        nextID++;
        
        GridPane expensePane = new GridPane();
        expensePane.setAlignment(Pos.CENTER);
        expensePane.setVgap(10);
        expensePane.setHgap(10);
        
        //CSS controls
        expensePane.setStyle("-fx-background-color: lightgrey;");
        lblCreateNewExpense.setStyle("-fx-font-size: 11pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");
        lblExpenseName.setStyle("-fx-font-size: 11pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");
        lblExpenseAmount.setStyle("-fx-font-size: 11pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");
        
        txtExpenseName.setStyle("-fx-font-family: \"Segoe UI Semibold\"; -fx-border-color: black;");
        txtExpenseAmount.setStyle("-fx-font-family: \"Segoe UI Semibold\"; -fx-border-color: black;");
        
        rdoYearly.setStyle("-fx-font-size: 11pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");
        rdoMonthly.setStyle("-fx-font-size: 11pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");
        
        btnCreateExpense.setStyle("-fx-padding: 5 22 5 22; -fx-border-color: #1F39F2; -fx-border-width: 2; -fx-background-radius: 0; -fx-background-color: #ED1C26; -fx-font-family: \"Segoe UI\", Helvetica, Arial, sans-serif; -fx-font-size: 14pt; -fx-text-fill: white; -fx-background-insets: 0 0 0 0, 0, 1, 2; -fx-font-weight: bold;");
        
        // Expenses controls
        expensePane.add(lblCreateNewExpense, 1, 1, 2, 1);
        expensePane.add(lblExpenseName, 1, 2);
        expensePane.add(txtExpenseName, 2, 2);
        expensePane.add(lblExpenseAmount, 1, 3);
        expensePane.add(txtExpenseAmount, 2, 3);
        expensePane.add(rdoYearly, 1, 4);
        expensePane.add(rdoMonthly, 2, 4);
        expensePane.add(btnCreateExpense, 1, 5, 2, 1);
        
        rdoMonthly.setToggleGroup(tglPaytime);
        rdoYearly.setToggleGroup(tglPaytime);
        
        Scene primaryScene = new Scene(expensePane, 800, 600);
        Stage primaryStage = new Stage();
        primaryStage.setScene(primaryScene);
        primaryStage.setTitle("Create Expense");
        primaryStage.show();
        primaryStage.setResizable(false);

        btnCreateExpense.setOnAction(e -> {
           String name = txtExpenseName.getText();
           double amount = Double.parseDouble(txtExpenseAmount.getText());
           boolean isYearly;
           if (rdoYearly.isSelected()) {
               isYearly = true;
           } else if (rdoMonthly.isSelected()) {
               isYearly = false;
           } else {
               isYearly = false;
           }
           parent.create_Expense(name, amount, isYearly);
           primaryStage.close();
                     
        });
    }    
}
