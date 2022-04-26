package com.akademija.sejovjezbajavafx;

import connection.Product;
import controller.ProductController;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.math.BigDecimal;


public class MainApplication extends Application {

    private final ProductController productController = new ProductController();
    private final TableView<Product> productTableView = new TableView<>();
    private final TextField nameInput = new TextField();
    private final TextField quantityInStockInput = new TextField();
    private final TextField priceInput = new TextField();

    @Override
    public void start(Stage stage) {

        stage.setTitle("Products");
        configurTable();

        productTableView.setItems(productController.loadProducts());

        nameInput.setPromptText("Naziv proizvoda");
        nameInput.setMinWidth(100);
        quantityInStockInput.setPromptText("Količina");
        priceInput.setPromptText("Cijena");
        Button addButton = new Button("Dodaj");
        addButton.setOnAction(e->onAddButtomClick());
        Button deleteButton = new Button("Briši");
        deleteButton.setOnAction(e-> onDeleteButtonClick());
        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(nameInput, quantityInStockInput, priceInput, addButton, deleteButton);

        VBox vBox = new VBox(hBox);
        vBox.getChildren().add(productTableView);
        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.show();

    }

    private void onAddButtomClick (){
        Product product = new Product();
        product.setName(nameInput.getText());
        product.setQuantityInStock(Integer.parseInt(quantityInStockInput.getText()));
        product.setUnitPrice(new BigDecimal(priceInput.getText()));

        product = productController.addProduct(product);

        productTableView.getItems().add(product);
        nameInput.clear();
        quantityInStockInput.clear();
        priceInput.clear();
    }

    private void onDeleteButtonClick (){
        ObservableList<Product> selectedProducts = productTableView.getSelectionModel().getSelectedItems();
        productController.deleteSelectedProducts (selectedProducts);
        ObservableList<Product> allProducts = productTableView.getItems();
        allProducts.removeAll(selectedProducts);
    }

    private void configurTable(){

        TableColumn<Product, Integer> productIdColumn = new TableColumn<>("Product Id");
        productIdColumn.setCellValueFactory(new PropertyValueFactory<Product, Integer>("productId"));

        TableColumn<Product, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));

        TableColumn<Product, Integer> quantityInStockColumn = new TableColumn<>("Quantity In Stock");
        quantityInStockColumn.setCellValueFactory(new PropertyValueFactory<Product, Integer>("quantityInStock"));

        TableColumn<Product, BigDecimal> unitPriceColumn = new TableColumn<>("Unit Price");
        unitPriceColumn.setCellValueFactory(new PropertyValueFactory<Product, BigDecimal>("unitPrice"));

       productTableView.getColumns().addAll(productIdColumn, nameColumn, quantityInStockColumn, unitPriceColumn);

    }

    public static void main(String[] args) {
        launch();

    }
}

/*ProductDao productDao = new ProductDao();
        List<Product> productList = productDao.getAll();
        for (Product product : productList) {
            System.out.println(product);*/

//Primjer 1


//    FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("hello-view.fxml"));
//    Scene scene = new Scene(fxmlLoader.load(), 320, 240);
//        stage.setTitle("Hello!");
//        stage.setScene(scene);
//        stage.show();

/*
 VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(20);
        vBox.setPadding(new Insets(20, 20,20,20));
        Label label = new Label();
        Button button = new Button("Hello");
        button.setOnAction(new HelloButtonListner(label));
        vBox.getChildren().add(label);
        vBox.getChildren().add(button);
        Scene scene = new Scene(vBox, 320,240);
        stage.setScene(scene);
        stage.show();

        private class HelloButtonListner implements EventHandler<ActionEvent>{

        private final Label label;

        public HelloButtonListner(Label label) {
            this.label = label;
        }

        @Override
        public void handle(ActionEvent actionEvent) {
            label.setText("Dobrodošli na Java FX");
        }
    }

 */

/*
SimpleIntegerProperty integerProperty = new SimpleIntegerProperty(23);
        integerProperty.addListener((observableVelue, oldVelue, newVelue) -> {
            System.out.println("Stara " + oldVelue + " Nova " + newVelue);
        });

        integerProperty.set(24);
 */

/*
Primjer 2
private Button button;
button = new Button("Klikni me !");
        button.setOnAction(this::handleOnButtonClick);
        StackPane stackPane = new StackPane();
        ObservableList<Node> children = stackPane.getChildren();
        children.add(button);

        Scene scene = new Scene(stackPane, 320,240);
        stage.setScene(scene);
        stage.show();

         private void handleOnButtonClick (ActionEvent actionEvent){
        System.out.println("Desio se klik !");

    }
 */

/*
       Primjer 3

         /*private Scene scena1;
        private Scene scena2;*/

        /*GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Dobrodošli na online kupovinu");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label userName = new Label("User Name:");
        grid.add(userName, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Label passWord = new Label("Password:");
        grid.add(passWord, 0, 2);

        PasswordField passWordBox = new PasswordField();
        grid.add(passWordBox, 1, 2);


        Button button = new Button("Sign in");
        button.setOnAction(e-> stage.setScene(scena2));
        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.BOTTOM_RIGHT);
        hBox.getChildren().add(button);
        grid.add(hBox, 1, 4);
        scena1 = new Scene(grid, 400, 400);


        Button button1 = new Button("Vrati se na početnu stranu");
        button1.setOnAction(e-> stage.setScene(scena1));
        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(button1);
        scena2 = new Scene(stackPane, 600,600);

        stage.setScene(scena1);
        stage.setTitle("Sead Bander");
        stage.show();*/

 /*

        Primjer 4
        Label label = new Label("Dobrodosli na scenu 1");
        Button button = new Button("Idi na scenu 2");
        button.setOnAction(e-> stage.setScene(scena2));
        VBox vBox = new VBox(20);
        vBox.getChildren().addAll(label, button);
        vBox.setPadding(new Insets(40));
        scena1 = new Scene(vBox, 400, 400);

        Button backButton = new Button("Vrati se na scenu 1");
        backButton.setOnAction(e-> stage.setScene(scena1));
        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(backButton);
        scena2 = new Scene(stackPane, 400,400);

        stage.setScene(scena1);
        stage.setTitle("Vise scena");
        stage.show();*/