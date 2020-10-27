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

public class EditExpense {
    public GroupProject484 parent;
    private String CreateExpenseID;
    int nextID = 0;
    
    // Expense controls
    Label lblSelectExpense = new Label("Select Expense");    
    Label lblEditExpense = new Label("-Edit Expense-");
    Label lblExpenseName = new Label("Expense Name:");
    TextField txtExpenseName = new TextField();
    Label lblExpenseAmount = new Label("Expense Amount:");
    TextField txtExpenseAmount = new TextField();
    ToggleGroup tglPaytime = new ToggleGroup();
    RadioButton rdoYearly = new RadioButton("Yearly");
    RadioButton rdoMonthly = new RadioButton("Monthly");
    Button btnEditExpense = new Button("Edit Expense");
    Label lblRemoveExpense = new Label("-Remove Expense-");
    Label lblExpenses = new Label("Expenses:");
    ObservableList obsExpenses = FXCollections.observableArrayList();
    ComboBox<String> cmboExpenses = new ComboBox<>(obsExpenses);
    Button btnSelectExpense = new Button("Select Expense");
    TextArea expenses = new TextArea();
    
    int editIndex = 0;
    
    public EditExpense(GroupProject484 parentForm, ArrayList<Expense> exp) {
        this.parent = parentForm;
        this.CreateExpenseID = "EE" + nextID;
        nextID++;
        
        int i = 0;
        for (Expense e : exp) {
            obsExpenses.add(exp.get(i).getName());
            i++;
        }

        GridPane expensePane = new GridPane();
        expensePane.setAlignment(Pos.CENTER);
        expensePane.setVgap(10);
        expensePane.setHgap(10);
        
        //CSS controls
        expensePane.setStyle("-fx-background-color: lightgrey;");
        lblEditExpense.setStyle("-fx-font-size: 11pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");
        lblExpenseName.setStyle("-fx-font-size: 11pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");
        lblExpenseAmount.setStyle("-fx-font-size: 11pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");
        lblSelectExpense.setStyle("-fx-font-size: 11pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");
        lblExpenses.setStyle("-fx-font-size: 11pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");
        
        cmboExpenses.setStyle("-fx-padding: 3 0 2 7; -fx-cell-size: 1.66667em; -fx-font-family: \"Segoe UI Semibold\"; -fx-border-color: black;");
        
        txtExpenseName.setStyle("-fx-font-family: \"Segoe UI Semibold\"; -fx-border-color: black;");
        txtExpenseAmount.setStyle("-fx-font-family: \"Segoe UI Semibold\"; -fx-border-color: black;");
        
        rdoYearly.setStyle("-fx-font-size: 11pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");
        rdoMonthly.setStyle("-fx-font-size: 11pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");
        
        btnEditExpense.setStyle("-fx-padding: 5 22 5 22; -fx-border-color: #1F39F2; -fx-border-width: 2; -fx-background-radius: 0; -fx-background-color: #ED1C26; -fx-font-family: \"Segoe UI\", Helvetica, Arial, sans-serif; -fx-font-size: 14pt; -fx-text-fill: white; -fx-background-insets: 0 0 0 0, 0, 1, 2; -fx-font-weight: bold;");
        btnSelectExpense.setStyle("-fx-padding: 5 22 5 22; -fx-border-color: #1F39F2; -fx-border-width: 2; -fx-background-radius: 0; -fx-background-color: #ED1C26; -fx-font-family: \"Segoe UI\", Helvetica, Arial, sans-serif; -fx-font-size: 14pt; -fx-text-fill: white; -fx-background-insets: 0 0 0 0, 0, 1, 2; -fx-font-weight: bold;");
        // Expenses controls
        expensePane.add(lblSelectExpense, 1, 0, 2, 1);
        expensePane.add(lblExpenses, 1, 1);
        expensePane.add(cmboExpenses, 2, 1);
        expensePane.add(btnSelectExpense, 1, 2, 2 ,1);
        expensePane.add(lblEditExpense, 1, 3, 2, 1);
        expensePane.add(lblExpenseName, 1, 4);
        expensePane.add(txtExpenseName, 2, 4);
        txtExpenseName.setDisable(true);
        expensePane.add(lblExpenseAmount, 1, 5);
        expensePane.add(txtExpenseAmount, 2, 5);
        txtExpenseAmount.setDisable(true);
        expensePane.add(rdoYearly, 1, 6);
        rdoYearly.setDisable(true);
        expensePane.add(rdoMonthly, 2, 6);
        rdoMonthly.setDisable(true);
        expensePane.add(btnEditExpense, 1, 7, 2, 1);
        btnEditExpense.setDisable(true);
        
        rdoMonthly.setToggleGroup(tglPaytime);
        rdoYearly.setToggleGroup(tglPaytime);
        
        Scene primaryScene = new Scene(expensePane, 800, 600);
        Stage primaryStage = new Stage();
        primaryStage.setScene(primaryScene);
        primaryStage.setTitle("Edit Expense");
        primaryStage.show();
        primaryStage.setResizable(false);
        

        btnSelectExpense.setOnAction(e -> {
            txtExpenseName.setDisable(false);
            txtExpenseAmount.setDisable(false);
            rdoYearly.setDisable(false);
            rdoMonthly.setDisable(false);
            btnEditExpense.setDisable(false);
            
            int expensePos = cmboExpenses.getSelectionModel().getSelectedIndex();
            editIndex = expensePos;
            txtExpenseName.setText(exp.get(expensePos).getName());
            String amountString = "" + exp.get(expensePos).getAmount();
            txtExpenseAmount.setText(amountString);
            boolean tempBool = exp.get(expensePos).getIsYearly();
            if (tempBool) {
                rdoYearly.setSelected(true);
            } else if (tempBool == false) {
                rdoMonthly.setSelected(true);
            }            
        });

        btnEditExpense.setOnAction(e -> {
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
           parent.edit_Expense(name, amount, isYearly, editIndex);
           primaryStage.close();
                     
        });
    }    
}
