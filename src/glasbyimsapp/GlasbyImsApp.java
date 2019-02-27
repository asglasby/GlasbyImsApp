/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glasbyimsapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.RadioButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import java.io.IOException;
import glasbyimsapp.view_controller.InventoryController;
import glasbyimsapp.model.Part;
import glasbyimsapp.model.Inhouse;
import glasbyimsapp.model.Outsourced;
import glasbyimsapp.model.Product;
import glasbyimsapp.GlasbyImsApp;
import glasbyimsapp.model.Inventory;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;

/**
 *
 * @author aglasby
 */

public class GlasbyImsApp extends Application {
    private Stage primaryStage;
    private ObservableList<Part> partsData = FXCollections.observableArrayList();
    private ObservableList<Product> productsData = FXCollections.observableArrayList();
    
     // Contrsuctor
    public GlasbyImsApp(){        
        partsData.add(new Inhouse(1, "InhousePart1", 10.99, 3, 1, 5, 1));
        partsData.add(new Outsourced(2, "OutsourcePart1", 8.99, 2, 2, 4, "Glasby Inc."));
        partsData.add(new Inhouse(3, "InhousePart2", 7.99, 3, 3, 3, 2));        
               
        productsData.add(new Product(1, "Product1", 20.99, 2, 2, 2));
        productsData.add(new Product(2, "Product2", 30.99, 2, 2, 2));
        productsData.add(new Product(3, "Product3", 40.99, 2, 2, 2));
    }
    
    // Returns a an obervable list of Parts
    public ObservableList<Part> getPartData(){
        return partsData;    
    }
    
    // Returns a an obervable list of Products
    public ObservableList<Product> getProductData(){
        return productsData;    
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Glasby IMS App");
        showMainView();        
    }
    
    public void showMainView(){
        try {
            // Load main view
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(GlasbyImsApp.class.getResource("view_controller/MainScreen.fxml"));
            AnchorPane mainView = (AnchorPane) loader.load();            
            
            // Show the scene containing the Main view
            Scene scene = new Scene(mainView);
            primaryStage.setScene(scene);
            primaryStage.show();
            
            // Give the controller access to the GlasbyImsApp
            InventoryController controller = loader.getController();
            controller.setGlasbyImsApp(this);
            controller.initializeColumns();
        } catch (IOException e){
            e.printStackTrace();        
        }    
    }
    
//    @FXML
//    private RadioButton outsourcedButton;
    
    
    @FXML
    public boolean showModifyPart(Part part){

        try {
        // Load the fxml file and create a new stage for the modify screen.
        FXMLLoader loader = new FXMLLoader();        
        loader.setLocation(GlasbyImsApp.class.getResource("view_controller/AddModifyInhousePart.fxml"));        
        AnchorPane page = (AnchorPane)loader.load();
        
        // Create the stage.
        Stage modifyPart = new Stage();
        modifyPart.setTitle("Modify Part");        
        modifyPart.initModality(Modality.WINDOW_MODAL);
        modifyPart.initOwner(primaryStage);
        Scene scene = new Scene(page);
        modifyPart.setScene(scene);
        
        // Set the part into the controller.
        InventoryController controller = loader.getController();
        controller.setEditPartStage(modifyPart);
        controller.setInPart(part);
        
        // Show the dialog and wait until the user closes it 
        modifyPart.showAndWait();        
        return controller.isSaveClicked();        
        
        }catch (IOException e) {
            e.printStackTrace();
            return false;
        }   
    }
    
    @FXML
    public boolean showModifyProduct(Product product){
        try {
        // Load the fxml file and create a new stage for the modify screen.
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(GlasbyImsApp.class.getResource("view_controller/ModifyProduct.fxml"));
        
        AnchorPane page = (AnchorPane)loader.load();
        
        // Create the stage.
        Stage modifyProduct = new Stage();
        modifyProduct.setTitle("Modify Product");
        modifyProduct.initModality(Modality.WINDOW_MODAL);
        modifyProduct.initOwner(primaryStage);
        Scene scene = new Scene(page);
        modifyProduct.setScene(scene);
        
        // Set the product into the controller.
        InventoryController controller = loader.getController();
        //controller.initializeModify();
        controller.setEditProductStage(modifyProduct);        
        controller.setInProduct(product);
        controller.setGlasbyImsApp(this);
        controller.initializeProductColumns();        
        
        // Show the dialog and wait until the user closes it
        modifyProduct.showAndWait();        
        return controller.isSaveClicked();
        
        }catch (IOException e) {
            e.printStackTrace();
            return false;
        }    
    }
    
    @FXML
    public boolean showAddProduct(Product product){

        try {
        // Load the fxml file and create a new stage for the modify screen.
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(GlasbyImsApp.class.getResource("view_controller/AddModifyProduct.fxml"));
        
        AnchorPane page = (AnchorPane)loader.load();
        
        // Create the stage.
        Stage modifyProduct = new Stage();
        modifyProduct.setTitle("Add Product");
        modifyProduct.initModality(Modality.WINDOW_MODAL);
        modifyProduct.initOwner(primaryStage);
        Scene scene = new Scene(page);
        modifyProduct.setScene(scene);
        
        // Set the product into the controller.
        InventoryController controller = loader.getController();        
        controller.setEditProductStage(modifyProduct);        
        controller.setInProduct(product);
        controller.setGlasbyImsApp(this);
        controller.initializeProductColumns();        
        
        // Show the dialog and wait until the user closes it
        modifyProduct.showAndWait();        
        return controller.isSaveClicked();        
        
        }catch (IOException e) {
            e.printStackTrace();
            return false;
        }    
    }    
    
    public Stage getPrimaryStage() {
        return primaryStage;
    }    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
