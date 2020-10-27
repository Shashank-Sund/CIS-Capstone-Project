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

public class CreateTransaction {
    public GroupProject484 parent;
    private String CreateTransactionID;
    int nextID = 0;
        
    // Controls at class level
    Label lblAddToTransaction = new Label("-Add to Transaction-");
    Label lblProduct = new Label("Product:");
    ObservableList obsProducts = FXCollections.observableArrayList();
    ComboBox<String> cmboProducts = new ComboBox<>(obsProducts);
    Label lblQuantity = new Label("Quantity:");
    TextField txtQuantity = new TextField();
    Button btnAddToTransaction = new Button("Add to Transation");
    Label lblRemoveFromTransaction = new Label("-Remove From Transaction-");
    Label lblProducts2 = new Label("Product:");
    ComboBox<String> cmboProducts2 = new ComboBox<>(obsProducts);
    Label lblQuantity2 = new Label("Quantity:");
    TextField txtQuantity2 = new TextField();
    Button btnRemoveFromTransaction = new Button("Remove From Transaction");
    RadioButton rdoMember = new RadioButton("Thrifty Club Member? ");
    Button btnCompleteTransaction = new Button("Complete Transaction");
    Label lblpriceCheck = new Label("-Price Check-");
    Label lblProducts3 = new Label("Products:");
    ComboBox<String> cmboProducts3 = new ComboBox<>(obsProducts);
    Label lblPrice = new Label("Price:");
    TextField txtPrice = new TextField();
    TextArea txtReceipt = new TextArea();
    Label lblBlank = new Label("\t\t\t\t\t\t");
    Label lblBlank2 = new Label("\n\n\n");
    Button btnPriceCheck = new Button("Check Price");
    
    
    
    public CreateTransaction (GroupProject484 parentForm) {
        this.parent = parentForm;
        this.CreateTransactionID = "CT" + nextID;
        nextID++;
        
        GridPane transactionPane = new GridPane();
        transactionPane.setAlignment(Pos.CENTER);
        transactionPane.setVgap(10);
        transactionPane.setHgap(10);
        
        // CSS for create transaction
        transactionPane.setStyle("-fx-background-color: lightgrey;");
        txtQuantity.setStyle("-fx-font-family: \"Segoe UI Semibold\"; -fx-border-color: black;");
        txtQuantity2.setStyle("-fx-font-family: \"Segoe UI Semibold\"; -fx-border-color: black;");
        txtReceipt.setStyle("-fx-font-family: \"Segoe UI Semibold\"; -fx-border-color: black;");
        txtPrice.setStyle("-fx-font-family: \"Segoe UI Semibold\"; -fx-border-color: black;");
        
        lblProduct.setStyle("-fx-font-size: 11pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");
        lblQuantity.setStyle("-fx-font-size: 11pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");
        lblAddToTransaction.setStyle("-fx-font-size: 11pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");
        lblRemoveFromTransaction.setStyle("-fx-font-size: 11pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");
        lblProducts2.setStyle("-fx-font-size: 11pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");
        lblQuantity2.setStyle("-fx-font-size: 11pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");
        lblpriceCheck.setStyle("-fx-font-size: 11pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");
        lblPrice.setStyle("-fx-font-size: 11pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");
        lblProducts3.setStyle("-fx-font-size: 11pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");
        
        btnAddToTransaction.setStyle("-fx-padding: 5 22 5 22; -fx-border-color: #1F39F2; -fx-border-width: 2; -fx-background-radius: 0; -fx-background-color: #ED1C26; -fx-font-family: \"Segoe UI\", Helvetica, Arial, sans-serif; -fx-font-size: 14pt; -fx-text-fill: white; -fx-background-insets: 0 0 0 0, 0, 1, 2; -fx-font-weight: bold;");
        btnRemoveFromTransaction.setStyle("-fx-padding: 5 22 5 22; -fx-border-color: #1F39F2; -fx-border-width: 2; -fx-background-radius: 0; -fx-background-color: #ED1C26; -fx-font-family: \"Segoe UI\", Helvetica, Arial, sans-serif; -fx-font-size: 14pt; -fx-text-fill: white; -fx-background-insets: 0 0 0 0, 0, 1, 2; -fx-font-weight: bold;");
        btnCompleteTransaction.setStyle("-fx-padding: 5 22 5 22; -fx-border-color: #1F39F2; -fx-border-width: 2; -fx-background-radius: 0; -fx-background-color: #ED1C26; -fx-font-family: \"Segoe UI\", Helvetica, Arial, sans-serif; -fx-font-size: 14pt; -fx-text-fill: white; -fx-background-insets: 0 0 0 0, 0, 1, 2; -fx-font-weight: bold;");
        btnPriceCheck.setStyle("-fx-padding: 5 22 5 22; -fx-border-color: #1F39F2; -fx-border-width: 2; -fx-background-radius: 0; -fx-background-color: #ED1C26; -fx-font-family: \"Segoe UI\", Helvetica, Arial, sans-serif; -fx-font-size: 14pt; -fx-text-fill: white; -fx-background-insets: 0 0 0 0, 0, 1, 2; -fx-font-weight: bold;");
        
        rdoMember.setStyle("-fx-font-size: 11pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");
        
        cmboProducts.setStyle("-fx-padding: 3 0 2 7; -fx-cell-size: 1.66667em; -fx-font-family: \"Segoe UI Semibold\"; -fx-border-color: black;");
        cmboProducts2.setStyle("-fx-padding: 3 0 2 7; -fx-cell-size: 1.66667em; -fx-font-family: \"Segoe UI Semibold\"; -fx-border-color: black;");
        cmboProducts3.setStyle("-fx-padding: 3 0 2 7; -fx-cell-size: 1.66667em; -fx-font-family: \"Segoe UI Semibold\"; -fx-border-color: black;");
        
        // transaction Pane adding
        //transactionPane.add(lblBlank2, 0 , 0);
        transactionPane.add(lblAddToTransaction, 0, 1, 2, 1);
        transactionPane.add(lblProduct, 0, 2);
        transactionPane.add(cmboProducts, 1, 2, 2 ,1);
        transactionPane.add(lblQuantity, 0, 3);
        transactionPane.add(txtQuantity, 1, 3);
        transactionPane.add(btnAddToTransaction, 0, 4, 2, 1);
        transactionPane.add(lblRemoveFromTransaction, 0, 5, 2, 1);
        transactionPane.add(lblProducts2, 0, 6);
        transactionPane.add(cmboProducts2, 1, 6, 2, 1);
        transactionPane.add(lblQuantity2, 0, 7);
        transactionPane.add(txtQuantity2, 1, 7);
        transactionPane.add(btnRemoveFromTransaction, 0, 8, 2, 1);
        transactionPane.add(rdoMember, 0, 9, 2, 1);
        transactionPane.add(btnCompleteTransaction, 0, 10, 2, 1);
        transactionPane.add(lblpriceCheck, 0 , 11);
        transactionPane.add(lblProducts3, 0 ,12);
        transactionPane.add(cmboProducts3, 1, 12, 2, 1);
        transactionPane.add(lblPrice, 0, 13);
        transactionPane.add(txtPrice, 1, 13);
        transactionPane.add(btnPriceCheck, 0, 14, 2, 1);
        txtReceipt.setMaxHeight(550);
        txtReceipt.setMinHeight(550);
        txtReceipt.setMaxWidth(300);
        transactionPane.add(txtReceipt, 4, 0, 4, 16);
        //transactionPane.add(lblBlank, 3, 1);
        
        Scene primaryScene = new Scene(transactionPane, 800, 600);
        Stage primaryStage = new Stage();
        primaryStage.setScene(primaryScene);
        primaryStage.setTitle("Create Transaction");
        primaryStage.show();
        primaryStage.setResizable(false);
    }
    
}
