package groupproject484;

import groupproject484.Employee;
import groupproject484.Store;
import groupproject484.Supplier;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.sql.*;
import oracle.jdbc.pool.*;

public class GroupProject484 extends Application {

    // All ArrayLists for storage
    public ArrayList<Product> productList = new ArrayList<>();
    public ArrayList<Store> storeList = new ArrayList<>();
    public ArrayList<Employee> employeeList = new ArrayList<>();
    public ArrayList<Supplier> supplierList = new ArrayList<>();
    public ArrayList<ClubMember> memberList = new ArrayList<>();
    public ArrayList<Expense> expenseList = new ArrayList<>();

    // Class Level Controls
    // Panes
    GridPane homePane = new GridPane();
    GridPane overallPane = new GridPane();
    GridPane loginPane = new GridPane();
    GridPane createPane = new GridPane();
    GridPane editPane = new GridPane();
    GridPane inventoryPane = new GridPane();
    GridPane payrollPane = new GridPane();
    GridPane reportPane = new GridPane();
    TabPane tabPane = new TabPane();

    // Tabs
    Tab homeTab = new Tab("Home");
    Tab inventoryTab = new Tab("Inventory");
    Tab payrollTab = new Tab("Payroll");
    Tab reportTab = new Tab("Reports");

    // Login Controls
    Label lblUsername = new Label("Username:");
    TextField txtUsername = new TextField();
    Label lblPassword = new Label("Password:");
    PasswordField txtPassword = new PasswordField();
    Button btnLogin = new Button("Login");

    // Home Controls
    Label lblEmployeeOfTheMonth = new Label("Congrats to Jeremy Ezell!\nEmployee of the Month!");
    Label lblPicnic = new Label("Reminder: Company Picnic August 27th at Percel Park!");

    // Inventory Controls
    Label lblManageInventory = new Label("-Manage Inventory-");
    Label lblQuantity3 = new Label("Quantity:");
    TextField txtQuantity3 = new TextField();
    ObservableList obsProducts = FXCollections.observableArrayList();
    ComboBox<String> cmboProducts4 = new ComboBox<>(obsProducts);
    Label lblProducts4 = new Label("Products:");
    TextArea inventory = new TextArea();
    RadioButton rdoIncreaseStock = new RadioButton("Increase Stock");
    RadioButton rdoDecreaseStock = new RadioButton("Decrease Stock");
    Button btnUpdateInventory = new Button("Update Inventory");
    Label lblCreateNewProduct = new Label("-Create New Product-");
    Label lblProductName = new Label("Name:");
    TextField txtProductName = new TextField();
    Label lblProductPrice = new Label("Price:");
    TextField txtProductPrice = new TextField();
    Button btnCreateProduct = new Button("Create Product");
    Label lblViewImage = new Label("-View Image-");
    Label lblProducts5 = new Label("Products:");
    ComboBox<String> cmboProducts5 = new ComboBox<>(obsProducts);
    Button btnViewImage = new Button("View Image");
    Label lblStore = new Label("Stores:");
    Label lblSuppliers = new Label("Suppliers:");
    ObservableList obsSuppliers = FXCollections.observableArrayList();
    ComboBox<String> cmboSuppliers = new ComboBox<>(obsSuppliers);
    ObservableList obsStores = FXCollections.observableArrayList();
    ComboBox<String> cmboStores = new ComboBox<>(obsStores);

    // Payroll Controls
    Label lblEnterWorkHours = new Label("-Manually Enter Work Hours-");
    Label lblMonth = new Label("Month:");
    ObservableList obsMonths = FXCollections.observableArrayList();
    ComboBox<String> cmboMonths = new ComboBox<>(obsMonths);
    Label lblDays = new Label("Day:");
    ObservableList obsDays = FXCollections.observableArrayList();
    ComboBox<String> cmboDays = new ComboBox<>(obsDays);
    Label lblHoursWorked = new Label("Hours Worked:");
    TextField txtHoursWorked = new TextField();
    Button btnEnterHours = new Button("Enter Hours");
    Label lblClockInOrOut = new Label("-Clock In/Out-");
    Button btnClockIn = new Button("Clock In");
    Button btnClockOut = new Button("Clock Out");
    // Report Controls
    Label lblGenerateReports = new Label("-Generate Report-");
    Label lblReports = new Label("Reports:");
    ObservableList obsReports = FXCollections.observableArrayList();
    ComboBox<String> cmboReports = new ComboBox<>(obsReports);
    Button btnGenerateReport = new Button("Generate Report");
    TextArea report = new TextArea();
    // Tab Controls
    
    ResultSet dbResults;
    Connection dbConn;
    Statement commStmt;
    PreparedStatement pst;

    @Override
    public void start(Stage primaryStage) {
        onLoad();
        
        /*These are used to create, pre-populate, and drop SQL tables*/
        
        dropTables();
        createStore();
        createProduct();
        createSupplier();
        createEmployee();
        createCredentials();
        createCustomer();
        prePop();
        
        // All CSS formating
        // Login Pane CSS
        loginPane.setStyle("-fx-background-color: lightgrey;");
        lblUsername.setStyle("-fx-font-size: 11pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");
        lblPassword.setStyle("-fx-font-size: 11pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");
        txtUsername.setStyle("-fx-font-family: \"Segoe UI Semibold\"; -fx-border-color: black;");
        txtPassword.setStyle("-fx-font-family: \"Segoe UI Semibold\"; -fx-border-color: black;");
        btnLogin.setStyle("-fx-padding: 5 22 5 22; -fx-border-color: #1F39F2; -fx-border-width: 2; -fx-background-radius: 0; -fx-background-color: #ED1C26; -fx-font-family: \"Segoe UI\", Helvetica, Arial, sans-serif; -fx-font-size: 16pt; -fx-text-fill: white; -fx-background-insets: 0 0 0 0, 0, 1, 2; -fx-font-weight: bold;");

        // Home page CSS
        homePane.setStyle("-fx-background-color: lightgrey;");
        lblEmployeeOfTheMonth.setStyle("-fx-font-size: 24pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");
        lblPicnic.setStyle("-fx-font-size: 24pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");

        // LoginPane
        loginPane.setAlignment(Pos.CENTER);
        loginPane.setVgap(10);
        loginPane.setHgap(10);
        loginPane.add(lblUsername, 0, 0);
        loginPane.add(txtUsername, 1, 0);
        loginPane.add(lblPassword, 0, 1);
        loginPane.add(txtPassword, 1, 1);
        loginPane.add(btnLogin, 1, 2, 2, 1);

        Scene loginScene = new Scene(loginPane, 300, 250);

        primaryStage.setTitle("ThriftyNet V 1.0.0");
        primaryStage.setScene(loginScene);
        primaryStage.show();
        primaryStage.setResizable(false);

        btnLogin.setOnAction(e -> {

            if (txtUsername.getText() == null) {
                System.out.println("Please enter a username!");
            } else if (txtPassword.getText() == null) {
                System.out.println("Please enter a password!");
            } else {
                String userEntry = txtUsername.getText();
                String passEntry = txtPassword.getText();

                int accesskey = passwordCheckDB(userEntry, passEntry);

                if (accesskey == 0) {
                    displayAlertWarning("Invalid Credentials", "The username or password is invalid.", "");
                } else {
                    
                    int empAccess = employeeTypeCheck(accesskey);

                    if (empAccess == 0) {
                        //Grants regular employee access
                        System.out.println("regular!");

                    } else if (empAccess == 1) {
                        //Grants admin access
                        System.out.println("admin!");

                        // Menu controls 
                        MenuBar mbrMainBar = new MenuBar();
                        Menu mnuCreate = new Menu("Create");
                        Menu mnuEdit = new Menu("Edit");
                        mbrMainBar.getMenus().addAll(mnuCreate, mnuEdit);

                        mnuCreate.getItems().add(new MenuItem("Create New Transaction"));
                        mnuCreate.getItems().add(new MenuItem("Create New Thrifty Club Member"));
                        mnuCreate.getItems().add(new MenuItem("Create New Employee"));
                        mnuCreate.getItems().add(new MenuItem("Create New Product"));
                        mnuCreate.getItems().add(new MenuItem("Create New Supplier"));
                        mnuCreate.getItems().add(new MenuItem("Create New Store"));
                        mnuCreate.getItems().add(new MenuItem("Create New Expense"));

                        mnuEdit.getItems().add(new MenuItem("Edit Existing Transaction"));
                        mnuEdit.getItems().add(new MenuItem("Edit Existing Thrifty Club Member"));
                        mnuEdit.getItems().add(new MenuItem("Edit Existing Employee"));
                        mnuEdit.getItems().add(new MenuItem("Edit Existing Product"));
                        mnuEdit.getItems().add(new MenuItem("Edit Existing Supplier"));
                        mnuEdit.getItems().add(new MenuItem("Edit Existing Store"));
                        mnuEdit.getItems().add(new MenuItem("Edit Existing Expense"));

                        // Home tab
                        StackPane logo = loadImage("https://i.ibb.co/LnqWBCG/thrifty.png");
                        logo.setMinWidth(800);
                        logo.setStyle("-fx-border-color: #1F39F2; -fx-border-width: 2;");
                        homePane.add(logo, 0, 0, 2, 1);
                        StackPane ezell = loadImage("https://i.ibb.co/cTN30Jg/ezell-jeremy-200x200.jpg");
                        homePane.add(ezell, 0, 1);
                        homePane.add(lblEmployeeOfTheMonth, 1, 1);
                        homePane.add(lblPicnic, 0, 2, 2, 1);
                        homePane.setHgap(180);
                        homePane.setVgap(17);

                        // Inventory Tab
                        inventoryPane.setAlignment(Pos.CENTER);
                        inventoryPane.setVgap(20);
                        inventoryPane.setHgap(10);
                        // Inventory Controls
                        inventoryPane.add(lblManageInventory, 0, 1, 2, 1);
                        inventoryPane.add(rdoIncreaseStock, 0, 2, 2, 1);
                        inventoryPane.add(rdoDecreaseStock, 0, 3, 2, 1);
                        ToggleGroup stock = new ToggleGroup();
                        rdoIncreaseStock.setToggleGroup(stock);
                        rdoDecreaseStock.setToggleGroup(stock);
                        inventoryPane.add(lblStore, 0, 4);
                        inventoryPane.add(cmboStores, 1, 4);
                        inventoryPane.add(lblProducts4, 0, 5);
                        inventoryPane.add(cmboProducts4, 1, 5);
                        inventoryPane.add(lblSuppliers, 0, 6);
                        inventoryPane.add(cmboSuppliers, 1, 6);
                        inventoryPane.add(lblQuantity3, 0, 7);
                        inventoryPane.add(txtQuantity3, 1, 7);
                        inventoryPane.add(btnUpdateInventory, 0, 8, 2, 1);
                        inventoryPane.add(lblProducts5, 0, 9);
                        inventoryPane.add(cmboProducts5, 1, 9);
                        inventoryPane.add(btnViewImage, 0, 10, 2, 1);
                        inventoryPane.add(inventory, 4, 0, 1, 12);

                        // Inventory CSS
                        inventoryPane.setStyle("-fx-background-color: lightgrey;");
                        lblManageInventory.setStyle("-fx-font-size: 11pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");
                        lblProducts4.setStyle("-fx-font-size: 11pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");
                        lblQuantity3.setStyle("-fx-font-size: 11pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");
                        lblViewImage.setStyle("-fx-font-size: 11pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");
                        lblProducts5.setStyle("-fx-font-size: 11pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");
                        lblStore.setStyle("-fx-font-size: 11pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");
                        lblSuppliers.setStyle("-fx-font-size: 11pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");

                        txtQuantity3.setStyle("-fx-font-family: \"Segoe UI Semibold\"; -fx-border-color: black;");
                        inventory.setStyle("-fx-font-family: \"Segoe UI Semibold\"; -fx-border-color: black;");

                        rdoIncreaseStock.setStyle("-fx-font-size: 11pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");
                        rdoDecreaseStock.setStyle("-fx-font-size: 11pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");

                        cmboProducts4.setStyle("-fx-padding: 3 0 2 7; -fx-cell-size: 1.66667em; -fx-font-family: \"Segoe UI Semibold\"; -fx-border-color: black;");
                        cmboProducts5.setStyle("-fx-padding: 3 0 2 7; -fx-cell-size: 1.66667em; -fx-font-family: \"Segoe UI Semibold\"; -fx-border-color: black;");
                        cmboStores.setStyle("-fx-padding: 3 0 2 7; -fx-cell-size: 1.66667em; -fx-font-family: \"Segoe UI Semibold\"; -fx-border-color: black;");
                        cmboSuppliers.setStyle("-fx-padding: 3 0 2 7; -fx-cell-size: 1.66667em; -fx-font-family: \"Segoe UI Semibold\"; -fx-border-color: black;");

                        btnUpdateInventory.setStyle("-fx-padding: 5 22 5 22; -fx-border-color: #1F39F2; -fx-border-width: 2; -fx-background-radius: 0; -fx-background-color: #ED1C26; -fx-font-family: \"Segoe UI\", Helvetica, Arial, sans-serif; -fx-font-size: 14pt; -fx-text-fill: white; -fx-background-insets: 0 0 0 0, 0, 1, 2; -fx-font-weight: bold;");
                        btnViewImage.setStyle("-fx-padding: 5 22 5 22; -fx-border-color: #1F39F2; -fx-border-width: 2; -fx-background-radius: 0; -fx-background-color: #ED1C26; -fx-font-family: \"Segoe UI\", Helvetica, Arial, sans-serif; -fx-font-size: 14pt; -fx-text-fill: white; -fx-background-insets: 0 0 0 0, 0, 1, 2; -fx-font-weight: bold;");

                        btnUpdateInventory.setOnAction(f -> {
                            int productPos = cmboProducts4.getSelectionModel().getSelectedIndex();
                            int storePos = cmboStores.getSelectionModel().getSelectedIndex();
                            int supplierPos = cmboSuppliers.getSelectionModel().getSelectedIndex();
                            int qty = Integer.parseInt(txtQuantity3.getText());

                            if (rdoIncreaseStock.isSelected()) {
                                storeList.get(storePos).increaseProduct(productList.get(productPos), qty, supplierList.get(supplierPos));
                            } else if (rdoDecreaseStock.isSelected()) {
                                storeList.get(storePos).decreaseProduct(productList.get(productPos), qty, supplierList.get(supplierPos));
                            }

                            displayInventory();
                        });

                        btnViewImage.setOnAction(f -> {

                        });
                        // Payroll Tab
                        payrollPane.setAlignment(Pos.CENTER);
                        payrollPane.setVgap(25);
                        payrollPane.setHgap(10);
                        // Payroll controls
                        payrollPane.add(lblClockInOrOut, 0, 0, 2, 1);
                        payrollPane.add(btnClockIn, 1, 1);
                        payrollPane.add(btnClockOut, 2, 1);
                        payrollPane.add(lblEnterWorkHours, 1, 3, 2, 1);
                        payrollPane.add(lblMonth, 1, 4);
                        payrollPane.add(cmboMonths, 2, 4);
                        payrollPane.add(lblDays, 3, 4);
                        payrollPane.add(cmboDays, 4, 4);
                        payrollPane.add(lblHoursWorked, 1, 5, 2, 1);
                        payrollPane.add(txtHoursWorked, 3, 5, 3, 1);
                        payrollPane.add(btnEnterHours, 1, 6, 2, 1);

                        // Payroll CSS
                        payrollPane.setStyle("-fx-background-color: lightgrey;");
                        lblClockInOrOut.setStyle("-fx-font-size: 11pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");
                        lblEnterWorkHours.setStyle("-fx-font-size: 11pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");
                        lblMonth.setStyle("-fx-font-size: 11pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");
                        lblDays.setStyle("-fx-font-size: 11pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");
                        lblHoursWorked.setStyle("-fx-font-size: 11pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");

                        txtHoursWorked.setStyle("-fx-font-family: \"Segoe UI Semibold\"; -fx-border-color: black;");

                        cmboMonths.setStyle("-fx-padding: 3 0 2 7; -fx-cell-size: 1.66667em; -fx-font-family: \"Segoe UI Semibold\"; -fx-border-color: black;");
                        cmboDays.setStyle("-fx-padding: 3 0 2 7; -fx-cell-size: 1.66667em; -fx-font-family: \"Segoe UI Semibold\"; -fx-border-color: black;");

                        btnClockIn.setStyle("-fx-padding: 5 22 5 22; -fx-border-color: #1F39F2; -fx-border-width: 2; -fx-background-radius: 0; -fx-background-color: #ED1C26; -fx-font-family: \"Segoe UI\", Helvetica, Arial, sans-serif; -fx-font-size: 14pt; -fx-text-fill: white; -fx-background-insets: 0 0 0 0, 0, 1, 2; -fx-font-weight: bold;");
                        btnClockOut.setStyle("-fx-padding: 5 22 5 22; -fx-border-color: #1F39F2; -fx-border-width: 2; -fx-background-radius: 0; -fx-background-color: #ED1C26; -fx-font-family: \"Segoe UI\", Helvetica, Arial, sans-serif; -fx-font-size: 14pt; -fx-text-fill: white; -fx-background-insets: 0 0 0 0, 0, 1, 2; -fx-font-weight: bold;");
                        btnEnterHours.setStyle("-fx-padding: 5 22 5 22; -fx-border-color: #1F39F2; -fx-border-width: 2; -fx-background-radius: 0; -fx-background-color: #ED1C26; -fx-font-family: \"Segoe UI\", Helvetica, Arial, sans-serif; -fx-font-size: 14pt; -fx-text-fill: white; -fx-background-insets: 0 0 0 0, 0, 1, 2; -fx-font-weight: bold;");

                        // Report Tab
                        reportPane.setAlignment(Pos.CENTER);
                        reportPane.setVgap(25);
                        reportPane.setHgap(10);
                        // Report Controls
                        reportPane.add(lblGenerateReports, 1, 1, 2, 1);
                        reportPane.add(lblReports, 1, 2);
                        reportPane.add(cmboReports, 2, 2);
                        reportPane.add(btnGenerateReport, 1, 3, 2, 1);
                        // Report CSS
                        reportPane.setStyle("-fx-background-color: lightgrey;");
                        lblGenerateReports.setStyle("-fx-font-size: 11pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");
                        lblReports.setStyle("-fx-font-size: 11pt; -fx-font-family: \"Segoe UI Semibold\"; -fx-text-fill: black; -fx-opacity: 1;");

                        cmboReports.setStyle("-fx-padding: 3 0 2 7; -fx-cell-size: 1.66667em; -fx-font-family: \"Segoe UI Semibold\"; -fx-border-color: black;");

                        btnGenerateReport.setStyle("-fx-padding: 5 22 5 22; -fx-border-color: #1F39F2; -fx-border-width: 2; -fx-background-radius: 0; -fx-background-color: #ED1C26; -fx-font-family: \"Segoe UI\", Helvetica, Arial, sans-serif; -fx-font-size: 14pt; -fx-text-fill: white; -fx-background-insets: 0 0 0 0, 0, 1, 2; -fx-font-weight: bold;");

                        // Menu Lambda Expressions
                        // Create Transaction
                        mbrMainBar.getMenus().get(0).getItems().get(0).setOnAction(f -> {
                            CreateTransaction chldForm = new CreateTransaction(this);
                        });

                        // Create New Member
                        mbrMainBar.getMenus().get(0).getItems().get(1).setOnAction(f -> {
                            CreateClubMember chldForm = new CreateClubMember(this);
                        });

                        // Create New Employee
                        mbrMainBar.getMenus().get(0).getItems().get(2).setOnAction(f -> {
                            String[] storeNames = new String[storeList.size()];
                            int i = 0;
                            for (Store s : storeList) {
                                storeNames[i] = s.getStoreName();
                                i++;
                            }
                            CreateEmployee chldForm = new CreateEmployee(this, storeNames);
                        });

                        // Create new product
                        mbrMainBar.getMenus().get(0).getItems().get(3).setOnAction(f -> {
                            CreateProduct chldForm = new CreateProduct(this);
                        });

                        // Create new supplier
                        mbrMainBar.getMenus().get(0).getItems().get(4).setOnAction(f -> {
                            CreateSupplier chldForm = new CreateSupplier(this);
                        });

                        // Create new Store
                        mbrMainBar.getMenus().get(0).getItems().get(5).setOnAction(f -> {
                            CreateStore chldForm = new CreateStore(this);
                        });

                        // Create new Expense
                        mbrMainBar.getMenus().get(0).getItems().get(6).setOnAction(f -> {
                            CreateExpense chldForm = new CreateExpense(this);
                        });

                        // Edit Transaction
                        mbrMainBar.getMenus().get(1).getItems().get(0).setOnAction(f -> {

                        });

                        // Edit Transaction
                        mbrMainBar.getMenus().get(1).getItems().get(6).setOnAction(f -> {
                            String[] expenseNames = new String[expenseList.size()];
                            int i = 0;
                            for (Expense exp : expenseList) {
                                expenseNames[i] = exp.getName();
                                i++;
                            }
                            EditExpense editExpense = new EditExpense(this, expenseList);
                        });

                        // Setting Tabs
                        homeTab.setContent(homePane);
                        homePane.setAlignment(Pos.CENTER);
                        inventoryTab.setContent(inventoryPane);
                        inventoryPane.setAlignment(Pos.CENTER);
                        payrollTab.setContent(payrollPane);
                        payrollPane.setAlignment(Pos.CENTER);
                        reportTab.setContent(reportPane);
                        reportPane.setAlignment(Pos.CENTER);

                        tabPane.getTabs().add(homeTab);
                        tabPane.getTabs().add(inventoryTab);
                        tabPane.getTabs().add(payrollTab);
                        tabPane.getTabs().add(reportTab);

                        homeTab.setClosable(false);
                        inventoryTab.setClosable(false);
                        payrollTab.setClosable(false);
                        reportTab.setClosable(false);

                        tabPane.setMinWidth(800);
                        overallPane.add(mbrMainBar, 0, 0, 2, 1);
                        overallPane.add(tabPane, 1, 1);

                        Scene overallScene = new Scene(overallPane, 800, 600);
                        primaryStage.setScene(overallScene);
                        primaryStage.show();
                        primaryStage.setResizable(false);
                    }
                }

            }

        });

    }

    public static void main(String[] args) {
        launch(args);
    }

    public void displayInventory() {
        String inventoryString = "";
        for (Store s : storeList) {
            int i = 0;
            for (Product p : s.inventoryProducts) {
                inventoryString += "Store: " + s.getStoreName() + "\t\tProduct Name: "
                        + s.inventoryProducts.get(i).getName() + "\t\tQuantity: " + s.associatedQuantity.get(i) + "\t\tSupplier: "
                        + s.associatedSuppliers.get(i).getSupplierName() + "\n";
                i++;
            }

        }
        inventory.setText(inventoryString);
    }

    public StackPane loadImage(String url) {
        StackPane sp = new StackPane();
        Image img = new Image(url);
        ImageView imgView = new ImageView(img);
        sp.getChildren().add(imgView);

        return sp;
    }

    public void create_Product(String name, double price, String desc, String category, String URL) {
        Product prod = new Product(name, price, desc, category, URL);
        productList.add(prod);
        obsProducts.add(prod.getName());
        displayAlertInfo("Notification", "Product Created", "Success");
    }

    public void create_Store(String name, String street, String city, String state, String zip) {
        Store store = new Store(name, street, city, state, zip);
        storeList.add(store);
        obsStores.add(store.getStoreName());
        displayAlertInfo("Notification", "Store Created", "Success");
    }

    public void create_Employee(String name, String address, String city, String state, String zip, String phone, int type, int storeIndex, boolean isHourly, double compensation) {
        Employee emp = new Employee(name, address, city, state, zip, phone, type, storeList.get(storeIndex), isHourly, compensation);
        employeeList.add(emp);
        displayAlertInfo("Notification", "Employee Created", "Success");
    }

    public void create_Supplier(String name, String address, String city, String state, String zip, String contactName, String contactPhone, String contactEmail) {
        Supplier supp = new Supplier(name, address, city, state, zip, contactName, contactPhone, contactEmail);
        supplierList.add(supp);
        obsSuppliers.add(supp.getSupplierName());
        displayAlertInfo("Notification", "Supplier Created", "Success");

    }

    public void create_ClubMember(String name, String phone, String street, String city, String state, String zip) {
        ClubMember clbm = new ClubMember(name, phone, street, city, state, zip);
        memberList.add(clbm);
        displayAlertInfo("Notification", "Thrifty Club Member Created", "Success");
    }

    public void create_Expense(String name, double amount, boolean isYearly) {
        Expense exp = new Expense(name, amount, isYearly);
        expenseList.add(exp);
        displayAlertInfo("Notification", "Expense Created", "Success");
    }

    public void edit_Expense(String name, double amount, boolean isYearly, int index) {
        expenseList.get(index).setName(name);
        expenseList.get(index).setAmount(amount);
        expenseList.get(index).setIsYearly(isYearly);
    }

    // Display Alert
    public void displayAlertInfo(String title, String header, String context) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(context);
        alert.showAndWait();
    }
    
    public void displayAlertWarning(String title, String header, String context) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(context);
        alert.showAndWait();
    }
    
    public void sendDBCommand(String query)
    {
        String URL = "jdbc:oracle:thin:@localhost:1521:XE";
        String userID = "javauser";
        String userPassword = "javapass";
        OracleDataSource ds;
        System.out.println(query);
        try
        {         
        ds = new OracleDataSource();
        
        ds.setURL(URL);
        
        dbConn = ds.getConnection(userID, userPassword);
        
        commStmt = dbConn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        
        dbResults = commStmt.executeQuery(query);
        }
        catch (SQLException e)
        {
            System.out.println(e.toString());
        }
    }
    
    public int passwordCheckDB(String userEntry, String passEntry){
        
        String sqlQuery = "SELECT * FROM JAVAUSER.CREDENTIALS";
        sendDBCommand(sqlQuery);
        int employeeID = 0;
        
        try
        {
            while(dbResults.next())
            {                
               int empID = (dbResults.getInt(1));
               String username = dbResults.getString(2);
               String password = dbResults.getString(3);
               
               if ((userEntry.equals(username)) && (passEntry.equals(password)))
                   employeeID = empID;
            }     
        }
        catch (SQLException sqle)
        {
            //txtOutput.setText(sqle.toString());
        }
        return employeeID;
    }
    
    public int employeeTypeCheck(int acceskey)
    {
        String sqlQuery = "SELECT * FROM JAVAUSER.EMPLOYEE";
        sendDBCommand(sqlQuery);
        int employeeAccess = 0;
        
        try
        {
            while (dbResults.next()) {

                if (acceskey == dbResults.getInt(1)) {
                    int empType = dbResults.getInt(11);

                    if (empType == 1) {
                        employeeAccess = 1;
                        break;
                    } else if (empType == 0) {
                        employeeAccess = 0;
                        break;
                    }
                }

            }
        }
        catch (SQLException sqle)
        {
            //txtOutput.setText(sqle.toString());
        }
        
        return employeeAccess;
    }
    
    
    
    
    public void createCredentials()
    {
        String crCredentials = "CREATE TABLE CREDENTIALS(" 
                +"employee_ID INT NOT NULL,"
                +"username VARCHAR(50)," 
                +"password VARCHAR(30),"  
                +"CONSTRAINT PK_CREDENTIALS PRIMARY KEY (employee_ID),"
                +"CONSTRAINT FK_CREDENTIALS FOREIGN KEY (employee_ID) REFERENCES Employee (employee_ID))";
        sendDBCommand(crCredentials);
    }
    
    public void createEmployee()
    {
        String crEmployee = "CREATE TABLE EMPLOYEE(" 
                +"employee_ID INT NOT NULL,"
                +"employee_first_name VARCHAR(50),"
                +"employee_last_name VARCHAR(50),"
                +"employee_phone VARCHAR(10),"
                +"employee_street VARCHAR(50)," 
                +"employee_city VARCHAR(50)," 
                +"employee_state VARCHAR(50)," 
                +"employee_zip VARCHAR(50),"
                +"isHourly VARCHAR(50),"
                +"employee_compensation FLOAT,"
                +"employee_type INT,"
                +"store_ID INT NOT NULL,"
                +"CONSTRAINT PK_EMPLOYEE PRIMARY KEY (employee_ID),"
                +"CONSTRAINT FK_EMPLOYEE FOREIGN KEY (store_ID) REFERENCES Store (store_ID))";
                
        sendDBCommand(crEmployee);
    }
    
    public void createProduct()
    {
        String crProduct = "CREATE TABLE PRODUCT(" 
                +"product_ID INT NOT NULL,"
                +"product_name VARCHAR(50),"  
                +"product_price VARCHAR(60),"
                +"product_description VARCHAR(60),"
                +"product_category VARCHAR(50)," 
                +"product_file_path VARCHAR(50)," 
                +"CONSTRAINT PK_PRODUCT PRIMARY KEY (product_ID))";    
        sendDBCommand(crProduct);
    }
    
    public void createSupplier()
    {
        String crSupplier = "CREATE TABLE SUPPLIER(" 
                +"supplier_ID INT NOT NULL,"
                +"supplier_name VARCHAR(50),"
                +"supplier_street VARCHAR(50)," 
                +"supplier_city VARCHAR(50)," 
                +"supplier_state VARCHAR(50)," 
                +"supplier_zip VARCHAR(50),"
                +"contact_name VARCHAR(50),"
                +"contact_phone VARCHAR(10),"
                +"contact_email VARCHAR(50),"
                +"CONSTRAINT PK_SUPPLIER PRIMARY KEY (supplier_ID))";    
        sendDBCommand(crSupplier);
    }
    
    public void createStore()
    {
        String crStore = "CREATE TABLE STORE(" 
                +"store_ID INT NOT NULL,"
                +"store_name VARCHAR(50),"
                +"store_street VARCHAR(50)," 
                +"store_city VARCHAR(50)," 
                +"store_state VARCHAR(50)," 
                +"store_zip VARCHAR(50),"
                +"CONSTRAINT PK_STORE PRIMARY KEY (store_ID))";    
        sendDBCommand(crStore);
    }
    
    public void createCustomer()
    {
        String crCustomer = "CREATE TABLE CUSTOMER(" 
                +"customer_ID INT NOT NULL,"
                +"customer_name VARCHAR(50),"
                +"customer_phone VARCHAR(10)," 
                +"customer_type VARCHAR(50)," 
                +"customer_email VARCHAR(50)," 
                +"CONSTRAINT PK_CUSTOMER PRIMARY KEY (customer_ID))";    
        sendDBCommand(crCustomer);
    }
    
    //FOR TESTING
    public void prePop()
    {
        
        String inStore1 = "INSERT INTO JAVAUSER.STORE (store_ID,store_name,store_street,store_city,store_state,store_zip) "
               + "VALUES (1,'H-town store','25 Jareddfdfd Drive','Rvifdfdlle','NJ','08691')";
        sendDBCommand(inStore1);
        
        String inEmployee1 = "INSERT INTO JAVAUSER.EMPLOYEE (employee_ID,employee_first_name,employee_last_name,employee_phone,employee_street,employee_city,employee_state,employee_zip,isHourly,employee_compensation,employee_type,store_ID) "
               + "VALUES (1,'Shashank','Sundararaman','7325136001','25 Jared Drive','Rville','NJ','08691','true',25,'1','1')";
        sendDBCommand(inEmployee1);

        //insert statements for testing
        String inCredentials1 = "INSERT INTO JAVAUSER.CREDENTIALS (employee_ID,username,password) "
               + "VALUES (1,'javauser','javapass')";
        sendDBCommand(inCredentials1);
        
        String inEmployee2 = "INSERT INTO JAVAUSER.EMPLOYEE (employee_ID,employee_first_name,employee_last_name,employee_phone,employee_street,employee_city,employee_state,employee_zip,isHourly,employee_compensation,employee_type,store_ID) "
               + "VALUES (2,'Jeremy','Ezell','7325136401','25 Jaredo Drive','Rville','NJ','08691','true',25,'0','1')";
        sendDBCommand(inEmployee2);
        
        String inCredentials2 = "INSERT INTO JAVAUSER.CREDENTIALS (employee_ID,username,password) "
               + "VALUES (2,'ezell','javapass2')";
        sendDBCommand(inCredentials2);
        

    }
    
    public void dropTables()
    {
        String dropStore = "DROP TABLE STORE";
        String dropProd = "DROP TABLE PRODUCT";
        String dropSupp = "DROP TABLE SUPPLIER"; 
        String dropCred = "DROP TABLE CREDENTIALS";
        String dropEmp = "DROP TABLE EMPLOYEE";
        String dropCust = "DROP TABLE CUSTOMER";
        
        sendDBCommand(dropProd);
        sendDBCommand(dropSupp);
        sendDBCommand(dropCred);
        sendDBCommand(dropEmp);
        sendDBCommand(dropStore);
        sendDBCommand(dropCust);
    }

    public void onLoad() {
        Store store = new Store("Thrify Harrisonburg", "1869 Port Republic Road", "Harrisonburg", "VA", "22801");
        Store store1 = new Store("Thrify New Market", "241 Main Street", "New Market", "VA", "23451");
        Store store2 = new Store("Thrify Staunton", "242 W. Broad Street", "Staunton", "VA", "21451");
        Store store3 = new Store("Thrify Waynesboro", "366 Staples Mill Road", "Waynesboro", "VA", "25641");
        Store store4 = new Store("Thrify Charlottesville", "330 Square Court", "Charlottesville", "VA", "12345");

        obsStores.add(store.getStoreName());
        obsStores.add(store1.getStoreName());
        obsStores.add(store2.getStoreName());
        obsStores.add(store3.getStoreName());
        obsStores.add(store4.getStoreName());

        storeList.add(store);
        storeList.add(store1);
        storeList.add(store2);
        storeList.add(store3);
        storeList.add(store4);

        Product prod = new Product("Cheetos", 1.00, "The cheesiest snack", "Snacks", "https://i.ibb.co/vLGh3qw/00028400433181-0.jpg");
        Product prod1 = new Product("Apple", 0.30, "Red, crunchy fruit", "Fruit", "https://i.ibb.co/QkmwmNW/8-TEbenojc.jpg");
        Product prod2 = new Product("Orange", 0.40, "Straight from Florida", "Fruit", "https://i.ibb.co/rb5mhmR/fruit-orange.jpg");
        Product prod3 = new Product("Coca-Cola 6-pack", 3.00, "Original Classic taste", "Soda", "https://i.ibb.co/m6GsdgZ/GUEST-9de8872b-bd33-4793-b6eb-f58de3d3e90a-fmt-webp-amp-qlt-80-amp-wid-1400.png");
        Product prod4 = new Product("Golden Monkey 6-pack", 5.00, "After 6 of these, you will see more than just golden monkeys", "Beer and Wine", "https://i.ibb.co/KFYw46L/victory-golden-monkey-81469-1535659025-1280-1280.jpg");

        obsProducts.add(prod.getName());
        obsProducts.add(prod1.getName());
        obsProducts.add(prod2.getName());
        obsProducts.add(prod3.getName());
        obsProducts.add(prod4.getName());

        productList.add(prod);
        productList.add(prod1);
        productList.add(prod2);
        productList.add(prod3);
        productList.add(prod4);

        Employee emp = new Employee("Jeremy Ezell", "484 Java Lane", "Harrisonburg", "VA", "22802", "5403314842", 0, store, true, 12.00);
        Employee emp1 = new Employee("John Doe", "234 Main Stret", "Harrisonburg", "VA", "22802", "5403314842", 1, store1, false, 33333);
        Employee emp2 = new Employee("Jane Doe", "234 Main Street", "Harrisonburg", "VA", "22802", "5403314842", 0, store2, true, 12.00);
        Employee emp3 = new Employee("Alvin Kamara", "41 Saints Way", "Harrisonburg", "VA", "22802", "5403314842", 1, store3, false, 44444);
        Employee emp4 = new Employee("Alexandria Ocasio-Cortz", "123 Green Park", "Harrisonburg", "VA", "22802", "5403314842", 0, store4, true, 15.00);

        employeeList.add(emp);
        employeeList.add(emp2);
        employeeList.add(emp3);
        employeeList.add(emp4);

        Supplier supp = new Supplier("PFG", "454 Powder Street", "Seattle", "WA", "45781", "Russel Wilson", "russwils@seahawks.nfl", "7715324482");
        Supplier supp1 = new Supplier("Big Apple Foods", "454 Fruit Fly Street", "Albany", "NY", "54321", "Bob Boxley", "bigbob@baf.org", "4215871234");
        Supplier supp2 = new Supplier("Snack Heaven", "870 Glenside Avenue", "Kanasas City", "MO", "98765", "Ricky Bobby", "shakebake1@rickybobby.nas", "3214567777");

        obsSuppliers.add(supp.getSupplierName());
        obsSuppliers.add(supp1.getSupplierName());
        obsSuppliers.add(supp2.getSupplierName());

        supplierList.add(supp);
        supplierList.add(supp1);
        supplierList.add(supp2);
    }

}
