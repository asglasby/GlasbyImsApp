/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glasbyimsapp.view_controller;
import com.sun.glass.ui.Window;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.Alert;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import glasbyimsapp.model.Part;
import glasbyimsapp.model.Product;
import glasbyimsapp.model.Inhouse;
import glasbyimsapp.model.Outsourced;
import glasbyimsapp.model.Inventory;
import glasbyimsapp.GlasbyImsApp;
import java.util.Optional;
import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Modality;

/**
 *
 * @author aglasby
 */
public class InventoryController {
    @FXML
    private TextField partIdField;
    
    @FXML
    private TextField partNameField;
    
    @FXML
    private TextField partPriceField;
    
    @FXML
    private TextField partInStockField;
    
    @FXML
    private TextField partMinField;
    
    @FXML
    private TextField partMaxField;
    
    @FXML
    private TextField partMachineIdField;
    
    @FXML
    private TextField partCompanyNameField;
    
    @FXML
    private RadioButton outsourcedButton;
    
    @FXML
    private RadioButton inhouseButton;
    
    @FXML
    private ToggleGroup inOutRadioButtons;
    
    @FXML
    private Stage modifyPartStage;
    //private Stage modifyPartOutsourcedStage;
    @FXML
    public static Part part;
    private boolean saveClicked = false;
    
    @FXML
    private TextField productIdField;
    
    @FXML
    private TextField productNameField;
    
    @FXML
    private TextField productPriceField;
    
    @FXML
    private TextField productInStockField;
    
    @FXML
    private TextField productMinField;
    
    @FXML
    private TextField productMaxField;
    
    @FXML
    private TableView<Part> partsTable;
    
    @FXML
    private TableColumn<Part, Integer> partIdColumn; 
    
    @FXML
    private TableColumn<Part, String> partNameColumn;
    
    @FXML
    private TableColumn<Part, Integer> partInStockColumn; 
    
    @FXML
    private TableColumn<Part, Double> partPriceColumn;
    
    @FXML
    private TableView<Part> associatedPartsTable;
    
    @FXML
    private TableColumn<Part, Integer> apartIdColumn;
    
    @FXML
    private TableColumn<Part, String> apartNameColumn;
    
    @FXML
    private TableColumn<Part, Integer> apartInStockColumn;
    
    @FXML
    private TableColumn<Part, Double> apartPriceColumn; 
    
    @FXML
    private Stage modifyProductStage; 
    
    @FXML
    private Product product;
    
    @FXML
    public static GlasbyImsApp glasbyImsApp; 
    
    
    @FXML
    private ObservableList<Part> associatedParts = FXCollections.observableArrayList();

    @FXML
    private TableView<Part> ppartsTable; 
    
    @FXML
    private TableColumn<Part, Integer> ppartIdColumn;
    
    @FXML
    private TableColumn<Part, String> ppartNameColumn; 
    
    @FXML
    private TableColumn<Part, Integer> ppartInStockColumn;
    
    @FXML
    private TableColumn<Part, Double> ppartPriceColumn; 
  
    @FXML
    private TableView<Product> productsTable;
    
    @FXML
    private TableColumn<Product, Integer> productIdColumn;
    
    @FXML
    private TableColumn<Product, String> productNameColumn; 
    
    @FXML
    private TableColumn<Product, Integer> productInStockColumn; 
    
    @FXML
    private TableColumn<Product, Double> productPriceColumn; 
    
    @FXML 
    private Label ExitLabel; 
    
    @FXML
    private Label searchPartBtn;    
   
    @FXML
    private Button searchProductBtn;
    
    @FXML
    private Button addProductButton; 
    
    @FXML
    private Button modifyProductButton; 

    @FXML
    private Button exitButton;

    @FXML
    private TextField searchPartField;
    
    @FXML
    private TextField searchProductField;
    
    @FXML
    private Product tempProduct;

    @FXML
    private Product myProduct;
    private Button sendingButton = new Button();
    static boolean entered;
    
    @FXML
    public static boolean addPart;
    
    @FXML
    public static boolean addProduct;
    
    @FXML
    private Label addPartLabel;
    
    @FXML
    private Label partTypeLabel;  
    
    @FXML
    private boolean partTypeChanged;
    
    @FXML 
    private Part oldPart;
    
    @FXML
    private Part newPart;
    
    @FXML
    private boolean isModifiedPart;
    
    @FXML
    private boolean outsourcedSelected;
    
    @FXML
    private boolean inhouseSelected;
    
    
    public InventoryController(){        
    }
    
    @FXML
    private void initialize() {
    }    
    
    
    /**
    * Called to initialized the part and products on the Main Screen.
    */
    @FXML
    public void initializeColumns(){
        // Initialize the parts table with columns.
        partIdColumn.setCellValueFactory(cellData -> cellData.getValue().partIdProperty().asObject());
        partNameColumn.setCellValueFactory(cellData -> cellData.getValue().partNameProperty());
        partInStockColumn.setCellValueFactory(cellData -> cellData.getValue().partInStockProperty().asObject());
        partPriceColumn.setCellValueFactory(cellData -> cellData.getValue().partPriceProperty().asObject()); 
        
        // Intitialize the products table with columns.
        productIdColumn.setCellValueFactory(cellData -> cellData.getValue().productIdProperty().asObject());        
        productNameColumn.setCellValueFactory(cellData -> cellData.getValue().productNameProperty());
        productInStockColumn.setCellValueFactory(cellData -> cellData.getValue().productInStockProperty().asObject());
        productPriceColumn.setCellValueFactory(cellData -> cellData.getValue().productPriceProperty().asObject());  
        
        // add observable list data to the tables
        partsTable.setItems(glasbyImsApp.getPartData());
        productsTable.setItems(glasbyImsApp.getProductData());        
    }
    
    
    /**
    * Called to initialized the associated parts on the Add and Modify Product Screens.
    */
    @FXML
    public void initializeProductColumns(){
        apartIdColumn.setCellValueFactory(cellData -> cellData.getValue().partIdProperty().asObject());
        apartNameColumn.setCellValueFactory(cellData -> cellData.getValue().partNameProperty());
        apartInStockColumn.setCellValueFactory(cellData -> cellData.getValue().partInStockProperty().asObject());
        apartPriceColumn.setCellValueFactory(cellData -> cellData.getValue().partPriceProperty().asObject()); 
        
        ppartIdColumn.setCellValueFactory(cellData -> cellData.getValue().partIdProperty().asObject());
        ppartNameColumn.setCellValueFactory(cellData -> cellData.getValue().partNameProperty());
        ppartInStockColumn.setCellValueFactory(cellData -> cellData.getValue().partInStockProperty().asObject());
        ppartPriceColumn.setCellValueFactory(cellData -> cellData.getValue().partPriceProperty().asObject());        
        
        if(glasbyImsApp.getPartData() != null){
            ppartsTable.setItems(glasbyImsApp.getPartData());
        }       
    }
    
     /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param glasbyImsApp
     */
    public void setGlasbyImsApp(GlasbyImsApp glasbyImsApp){
        this.glasbyImsApp = glasbyImsApp;  
    }

    /**
     * Sets the stage of this editPartStage.
     * 
     * @param editProductStage
     */
    public void setEditProductStage(Stage editProductStage) {
        this.modifyProductStage = editProductStage;        
    }
    
    /**
     * Called when the user clicks on the Add Product button.
     */    
    @FXML
    public void handleNewProduct(){        
        Product tempProduct = new Product();
        addProduct = true;
        associatedParts.clear();
        tempProduct.associatedParts = associatedParts;
        boolean saveClicked = glasbyImsApp.showAddProduct(tempProduct);
        if(saveClicked){
            glasbyImsApp.getProductData().add(tempProduct);            
        }    
    }   
    
    /**
     * Called when the user clicks on the Modify Product button.
     */
    @FXML
    public void handleModifyProduct(){
        Product selectedProduct = productsTable.getSelectionModel().getSelectedItem();        
        addProduct = false;               
        if(selectedProduct !=null) {           
            boolean saveClicked = glasbyImsApp.showModifyProduct(selectedProduct);                                  
            if(saveClicked){ 
            productsTable.refresh();            
            }
        }else {
            // If nothing was selected alert the user.
            nothingSelected();            
        }
    }
    
     /**
     * Called when the user clicks the save button.
     */
    @FXML
    private void handleProductSave(){
        if(isProductValid()){ 
            if(isAddProduct()){                
                product.setProductId(Integer.parseInt(productIdField.getText()));
            }            
            product.setProductName(productNameField.getText());
            product.setProductPrice(Double.parseDouble(productPriceField.getText()));
            product.setProductInStock(Integer.parseInt(productInStockField.getText()));
            product.setProductMin(Integer.parseInt(productMinField.getText()));
            product.setProductMax(Integer.parseInt(productMaxField.getText()));
            if(!product.associatedParts.isEmpty()){
                product.getAssociatedPartData().addAll(this.associatedParts);   
            }                       
            saveClicked = true;           
            modifyProductStage.close();
            //this.associatedParts.clear();
        }               
    }
    
    /**
     * Sets the product to be added or modified.
     * 
     * @param product
     */
    public void setInProduct(Product product){
        this.product = product;  
        productIdField.setText(Integer.toString(product.getProductId()));
        productNameField.setText(product.getProductName());
        productPriceField.setText(Double.toString(product.getProductPrice()));
        productInStockField.setText(Integer.toString(product.getProductInStock()));
        productMinField.setText(Integer.toString(product.getProductMin()));
        productMaxField.setText(Integer.toString(product.getProductMax()));
        
        if(!this.product.associatedParts.isEmpty()){
            associatedPartsTable.setItems(this.product.getAssociatedPartData());
        }             
    }    
    
    /**
     * Returns true if the user clicks the Save button, false otherwise.
     * 
     * @return
     */    
    public boolean isSaveClicked(){
        return saveClicked;
    }    
    
    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleProductCancel() {       
        // modifyProductStage.close();
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Cancel Confirmation");
        alert.setHeaderText("Please confirm that you want to cancel this action.");
        alert.setContentText("Are you sure you want to Cancel?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
        // ... user chose OK
         modifyProductStage.close();
        } else {
         // ... user chose CANCEL or closed the dialog
         modifyProductStage.show();
        }
    }
    
    /**
     * Called when the user clicks add part to a specific product.
     */
    @FXML
    public void handleAddAssociatedPart(){
        Part selectedPart = ppartsTable.getSelectionModel().getSelectedItem();        
        if(selectedPart !=null) {            
            product.associatedParts.add(selectedPart);            
            associatedPartsTable.setItems(product.associatedParts);            
        }else {
            // If nothing was selected alert the user.
            nothingSelected();            
        }        
    }

    /**
    * Called when deleting parts associated with a product.
    */
    @FXML
    public void handleDeleteAssociatedPart() throws IOException {
        int partSelected = associatedPartsTable.getSelectionModel().getSelectedIndex();        
        if(partSelected >= 0){
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Delete Confirmation");
            alert.setHeaderText("Please confirm that you want to delete this item.");
            alert.setContentText("Are you sure you want to Delete this item?");
            Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK){
                    // ... user chose OK        
                    associatedPartsTable.getItems().remove(partSelected);
                    associatedPartsTable.setItems(product.associatedParts); 
                }else{
                    modifyProductStage.show();
                }
        } else {
            nothingSelected();
        }             
    }     
    
    /**
    * Called when adding, modifying, or deleting parts associated with a product.
    */
    @FXML
    private ObservableList<Part> getAssociatedPartData(){
        return this.associatedParts;
    }
    
    
    /**
    * Called when an item is not selected when trying to modify or delete.
    */
    @FXML
    private void nothingSelected(){
        Alert nothingSelectedAlert = new Alert(AlertType.WARNING);
        nothingSelectedAlert.initOwner(glasbyImsApp.getPrimaryStage());
        nothingSelectedAlert.setTitle("Nothing was Selected");
        nothingSelectedAlert.setHeaderText("You must select an item");
        nothingSelectedAlert.setContentText("Please select and item");            
        nothingSelectedAlert.showAndWait();
    }
    
    /**
     * Validates the user input in the text fields.
     * 
     * @return true if the input is valid
     */    
    private boolean isProductValid(){        
        String errorMessage = "";        
        try{
            Integer checkInstockField = Integer.parseInt(productInStockField.getText());
            Integer checkMinField = Integer.parseInt(productMinField.getText());
            Integer checkMaxField = Integer.parseInt(productMaxField.getText());
            Double checkPriceField = Double.parseDouble(productPriceField.getText());            
            errorMessage += "";  
        }catch(NumberFormatException e){
            errorMessage += "You must enter only numbers greater than 0 in the Inv, Price, Min, Max, and Fields. ";
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(glasbyImsApp.getPrimaryStage());
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);
            alert.showAndWait();
            return false;
        }       
        
        if(productNameField.getText() == null || productNameField.getText().length() == 0){
            errorMessage = "Product Name is not valid. ";           
        }        
        if(Integer.parseInt(productInStockField.getText()) <= 0){
            errorMessage += "Please enter a number greater than 0 for the Inv value. ";            
        }
        if(Integer.parseInt(productInStockField.getText()) < Integer.parseInt(productMinField.getText()) || Integer.parseInt(productInStockField.getText()) > Integer.parseInt(productMaxField.getText())){
            errorMessage += "Inv number must be between minimum or maximum value. ";            
        }
        
        if(Integer.parseInt(productMinField.getText()) <= 0){
            errorMessage += "Please enter a number greater than 0 in the Min value. ";            
        }
        
        if(Integer.parseInt(productMinField.getText()) > Integer.parseInt(productMaxField.getText())){
            errorMessage += "Min value must be less than or equal to Max value. ";            
        }
        
        if(Integer.parseInt(productMaxField.getText()) <= 0){
            errorMessage += "Please enter a number greater than 0 in the Max value. ";           
        }
        
        if(Integer.parseInt(productMaxField.getText()) < Integer.parseInt(productMinField.getText())){
            errorMessage += "Max value must be greater than Min value. ";             
        }
        
        if(product.associatedParts.size() == 0){
            errorMessage += "You must add at least one part to your product. ";
        }
        
        double partsPrice = 0;
        for (Part associatedPart : product.associatedParts) {
            partsPrice = partsPrice + associatedPart.getPartPrice();
        }
        
        if(Double.parseDouble(productPriceField.getText()) < partsPrice){
            errorMessage += "Price must be greater than or equal to the total of all the parts. ";             
        }
        
         if(errorMessage.length() > 0){            
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(glasbyImsApp.getPrimaryStage());
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);
            alert.showAndWait();
            return false;           
        }       
        return true;
    }

    
   /**
   * Called when the user clicks on the Exit button.
   */    
   @FXML
   private void handleExitApp() throws Exception{
        // close the program window.        
        glasbyImsApp.getPrimaryStage().close();
    }   
   
    /**
     * Called when the user clicks on the Add Part button.
     */
    @FXML
    public void handleNewPart(){
        Part tempPart = new Inhouse();
        addPart = true;
        boolean saveClicked = glasbyImsApp.showModifyPart(tempPart);
        if(saveClicked){            
            glasbyImsApp.getPartData().add(tempPart);        
        }            
    }
    
    /**
    * Called to enable the text fields after the user clicks on either the inhouse or outsourced radio buttons.
    */
    @FXML
    public void enablePartTextFields(){
        partNameField.setDisable(false);
        partPriceField.setDisable(false);
        partInStockField.setDisable(false);
        partMinField.setDisable(false);
        partMaxField.setDisable(false);
        partMachineIdField.setDisable(false);
    }

//    @FXML
//    private Part tempPart;
    
    /**
    * Called when the outsourced radio button is selected.
    */
    @FXML
    public void outsourcedSelected(){
        outsourcedSelected = true;
        enablePartTextFields();
        partTypeChanged = true;
        Part tempPart = new Outsourced();
        newPart = new Outsourced();
        partTypeLabel.setText("Company Name");   
        setInPart(part);                   
    }    
    
    /**
    * Called when the inhouse radio button is selected.
    */
    @FXML
    public void inhouseSelected(){
        inhouseSelected = true;
        enablePartTextFields();
        partTypeChanged = true;
        Part tempPart = new Inhouse();
        newPart = new Inhouse();
        partTypeLabel.setText("Machine ID");    
        setInPart(part);       
    }
    
    /**
     * Called when the user clicks on the Modify Part button.
     */
    @FXML
    public void handleModifyPart(){       
        Part selectedPart = partsTable.getSelectionModel().getSelectedItem();
         addPart = false;
         
        if(selectedPart !=null) {            
            boolean saveClicked = glasbyImsApp.showModifyPart(selectedPart); 
            
            if(saveClicked){
                if(isModifiedPart == true && partTypeChanged == true){
                    glasbyImsApp.getPartData().remove(selectedPart);
                }
            partsTable.refresh();            
            }
        }else {
            // If nothing was selected alert the user.
            nothingSelected();            
        }
    }
    
    /**
    * Called when the user clicks the Delete Part button.
    */
    @FXML
    public void handleDeletePart() throws IOException {
        int partSelected = partsTable.getSelectionModel().getSelectedIndex();        
        if(partSelected >= 0){
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Delete Confirmation");
            alert.setHeaderText("Please confirm that you want to delete this item.");
            alert.setContentText("Are you sure you want to Delete this item?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                // ... user chose OK        
                partsTable.getItems().remove(partSelected);
            }else{
                glasbyImsApp.getPrimaryStage().show();
            }         
        }else {
            nothingSelected();
        }             
    }     

    /**
    * Called when the user clicks the Delete Product button.
    */
    @FXML
    private void handleDeleteProduct() throws IOException {        
        Product selectedProduct = productsTable.getSelectionModel().getSelectedItem();
        int selectedIndex = productsTable.getSelectionModel().getSelectedIndex();        
        if (selectedIndex >= 0) {            
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Delete Confirmation");
            alert.setHeaderText("Please confirm that you want to delete this Product and all its associated parts. ");
            alert.setContentText("Are you sure you want to Delete this item?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                // ... user chose OK        
                productsTable.getItems().remove(selectedIndex); 
            }else{
                modifyProductStage.show();
            }                        
        } else {
            nothingSelected();
        }
    }    
    
    /**
    * Called when the user clicks the Search Part button.
    */
    @FXML
    private void handleSearchParts(){
        String searchPart = searchPartField.getText();
        FilteredList<Part> searchPartResult = handleSearchParts(searchPart);
         // Wrap the FilteredList in a SortedList.
        SortedList<Part> sortedPartData = new SortedList<>(searchPartResult);
        
        // Bind the SortedList comparator to the TableView comparator.  Otherwise, sorting the Tableviw would have no effect.
        sortedPartData.comparatorProperty().bind(partsTable.comparatorProperty());
        
        // Add sorted and filtered data to the table.
        partsTable.setItems(sortedPartData);    
    }
    
    public FilteredList<Part> handleSearchParts(String s){
        return glasbyImsApp.getPartData().filtered(p -> Integer.toString(p.getPartId()).equals(s)|| p.getPartName().toLowerCase().contains(s.toLowerCase()));
    }    
    
    /**
    * Called when the user clicks the Search Associated Parts button.
    */
    @FXML
    private void handleSearchPParts(){
        String searchPart = searchPartField.getText();
        FilteredList<Part> searchPartResult = handleSearchPParts(searchPart);
         // Wrap the FilteredList in a SortedList.
        SortedList<Part> sortedPartData = new SortedList<>(searchPartResult);
        
        // Bind the SortedList comparator to the TableView comparator.  Otherwise, sorting the Tableviw would have no effect.
        sortedPartData.comparatorProperty().bind(ppartsTable.comparatorProperty());
        
        // Add sorted and filtered data to the table.
        ppartsTable.setItems(sortedPartData);    
    }
    
    public FilteredList<Part> handleSearchPParts(String s){
        return glasbyImsApp.getPartData().filtered(p -> Integer.toString(p.getPartId()).equals(s)|| p.getPartName().toLowerCase().contains(s.toLowerCase()));
    }
    
    
    /**
    * Called when the user clicks the Search Product button.
    */    
    @FXML
    private void handleSearchProducts(){
        String searchProduct = searchProductField.getText();
        FilteredList<Product> searchProductResult = handleSearchProducts(searchProduct);
         // Wrap the FilteredList in a SortedList.
        SortedList<Product> sortedProductData = new SortedList<>(searchProductResult);
        
        // Bind the SortedList comparator to the TableView comparator.  Otherwise, sorting the Tableviw would have no effect.
        sortedProductData.comparatorProperty().bind(productsTable.comparatorProperty());
        
        // Add sorted and filtered data to the table.
        productsTable.setItems(sortedProductData); 
    }
    
    public FilteredList<Product> handleSearchProducts(String s){
        return glasbyImsApp.getProductData().filtered(p -> Integer.toString(p.getProductId()).equals(s) || p.getProductName().toLowerCase().contains(s.toLowerCase()));
    } 

     /**
     * Sets the stage of this editPartStage.
     * 
     * @param editPartStage
     */
    public void setEditPartStage(Stage editPartStage) {
        this.modifyPartStage = editPartStage;
    }

    
    /**
    * Set the Part to be Added or Modified - Called after the handleNewPart() or handleModifyPart() methods.
    */    
    @FXML
    public void setInPart(Part part){
        if(addPart == false){
            if(part instanceof Inhouse){
                this.partTypeLabel.setText("Machine Id");
            }else{
                this.partTypeLabel.setText("Company Name");
            }
            enablePartTextFields();
            this.addPartLabel.setText("ModifyPart");            
            if(partTypeChanged == true){
                if(outsourcedButton.isSelected()){
                    this.partTypeLabel.setText("Company Name");
                    oldPart = part;    
                    this.part = new Outsourced();		
                    partIdField.setText(Integer.toString(oldPart.getPartId()));
                    partNameField.setText(oldPart.getPartName());
                    partPriceField.setText(Double.toString(oldPart.getPartPrice()));
                    partInStockField.setText(Integer.toString(oldPart.getPartInStock()));
                    partMinField.setText(Integer.toString(oldPart.getPartMin()));
                    partMaxField.setText(Integer.toString(oldPart.getPartMax())); 
                    partMachineIdField.setText(((Outsourced)this.part).getCompanyName());
                    isModifiedPart = true;        
                }else{
                    this.partTypeLabel.setText("Machine Id");
                    oldPart = part;    
                    this.part = new Inhouse();		
                    partIdField.setText(Integer.toString(oldPart.getPartId()));
                    partNameField.setText(oldPart.getPartName());
                    partPriceField.setText(Double.toString(oldPart.getPartPrice()));
                    partInStockField.setText(Integer.toString(oldPart.getPartInStock()));
                    partMinField.setText(Integer.toString(oldPart.getPartMin()));
                    partMaxField.setText(Integer.toString(oldPart.getPartMax())); 
                    partMachineIdField.setText(Integer.toString(((Inhouse)this.part).getMachineID()));
                    isModifiedPart = true;                
                }
            }else{
                this.part = part; 
                partIdField.setText(Integer.toString(part.getPartId()));
                partNameField.setText(part.getPartName());
                partPriceField.setText(Double.toString(part.getPartPrice()));
                partInStockField.setText(Integer.toString(part.getPartInStock()));
                partMinField.setText(Integer.toString(part.getPartMin()));
                partMaxField.setText(Integer.toString(part.getPartMax()));
                if(part instanceof Outsourced){
                    partMachineIdField.setText(((Outsourced)part).getCompanyName());
                }else{
                    partMachineIdField.setText(Integer.toString(((Inhouse)part).getMachineID()));            
                }                
            }
        }else if(isAddPart() && partTypeChanged == true){
            oldPart = part; 
            if(inhouseSelected == true){
                this.part = new Inhouse();
            }else{
                this.part = new Outsourced();
            }            	
            partIdField.setText(Integer.toString(oldPart.getPartId()));
            partNameField.setText(oldPart.getPartName());
            partPriceField.setText(Double.toString(oldPart.getPartPrice()));
            partInStockField.setText(Integer.toString(oldPart.getPartInStock()));
            partMinField.setText(Integer.toString(oldPart.getPartMin()));
            partMaxField.setText(Integer.toString(oldPart.getPartMax()));
            
            if(this.part instanceof Outsourced){               
                  partMachineIdField.setText(((Outsourced)this.part).getCompanyName());
            }else{
                partMachineIdField.setText(Integer.toString(((Inhouse)this.part).getMachineID()));            
            }            
        }else{
            this.part = part; 
            partIdField.setText(Integer.toString(part.getPartId()));
            partNameField.setText(part.getPartName());
            partPriceField.setText(Double.toString(part.getPartPrice()));
            partInStockField.setText(Integer.toString(part.getPartInStock()));
            partMinField.setText(Integer.toString(part.getPartMin()));
            partMaxField.setText(Integer.toString(part.getPartMax()));
            if(part instanceof Outsourced){
                partMachineIdField.setText(((Outsourced)part).getCompanyName());
            }else{
                partMachineIdField.setText(Integer.toString(((Inhouse)part).getMachineID()));            
            }            
        }            
    }
    
    /**
    * Called when the user clicks the save button.
    */
    @FXML
    private void handlePartSave(){
        if(isPartValid()){           
            if(isAddPart() && partTypeChanged == true){
                addNewChangedTypePart();
                saveClicked = false;              
            }else if(isAddPart()){
                part.setPartId(part.getPartId());                
                part.setPartName(partNameField.getText());
                part.setPartPrice(Double.parseDouble(partPriceField.getText()));
                part.setPartInStock(Integer.parseInt(partInStockField.getText()));
                part.setPartMin(Integer.parseInt(partMinField.getText()));
                part.setPartMax(Integer.parseInt(partMaxField.getText()));
                if(part instanceof Inhouse){
                    ((Inhouse)part).setMachineID(Integer.parseInt(partMachineIdField.getText()));
                }else{
                    ((Outsourced)part).setCompanyName(partMachineIdField.getText());
                }
                saveClicked = true;
            }else if(isModifiedPart == true && partTypeChanged == true){
                part.setPartId(part.getPartId());  
                part.setPartName(partNameField.getText());
                part.setPartPrice(Double.parseDouble(partPriceField.getText()));
                part.setPartInStock(Integer.parseInt(partInStockField.getText()));
                part.setPartMin(Integer.parseInt(partMinField.getText()));
                part.setPartMax(Integer.parseInt(partMaxField.getText()));
                
                if(part instanceof Inhouse){
                    ((Inhouse)part).setMachineID(Integer.parseInt(partMachineIdField.getText()));
                  
                }else{
                    ((Outsourced)part).setCompanyName(partMachineIdField.getText());
                }
                glasbyImsApp.getPartData().remove(oldPart);
                glasbyImsApp.getPartData().add(part); 
                saveClicked = true;
            }
             else{
                part.setPartName(partNameField.getText());
                part.setPartPrice(Double.parseDouble(partPriceField.getText()));
                part.setPartInStock(Integer.parseInt(partInStockField.getText()));
                part.setPartMin(Integer.parseInt(partMinField.getText()));
                part.setPartMax(Integer.parseInt(partMaxField.getText()));
                
                if(part instanceof Inhouse){
                    ((Inhouse)part).setMachineID(Integer.parseInt(partMachineIdField.getText()));
                  
                }else{
                    ((Outsourced)part).setCompanyName(partMachineIdField.getText());
                }
                saveClicked = true;
            }            
            modifyPartStage.close();
        }
    }
    
    /**
    * Helper method for the setInPart.
    */
    @FXML
    private void addNewChangedTypePart(){
                part.setPartId(part.getPartId());  
                part.setPartName(partNameField.getText());
                part.setPartPrice(Double.parseDouble(partPriceField.getText()));
                part.setPartInStock(Integer.parseInt(partInStockField.getText()));
                part.setPartMin(Integer.parseInt(partMinField.getText()));
                part.setPartMax(Integer.parseInt(partMaxField.getText()));
                
                if(part instanceof Inhouse){
                    ((Inhouse)part).setMachineID(Integer.parseInt(partMachineIdField.getText()));
                  
                }else{
                    ((Outsourced)part).setCompanyName(partMachineIdField.getText());
                }
                glasbyImsApp.getPartData().remove(oldPart);
                glasbyImsApp.getPartData().add(part);
    }
    
    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handlePartCancel() {       
        confirmCancel();
    }
    
    
    /**
     * Called after the user clicks cancel to confirm the action.
    */
    @FXML
    private void confirmCancel(){
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Cancel Confirmation");
        alert.setHeaderText("Please confirm that you want to cancel this action.");
        alert.setContentText("Are you sure you want to Cancel?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
        // ... user chose OK
         modifyPartStage.close();
        } else {
         // ... user chose CANCEL or closed the dialog
         modifyPartStage.show();
        }
    }
    
    /**
     * Called after a handleDelete method to confirm the action.
     */
    @FXML
    private void confirmDelete(){
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Delete Confirmation");
        alert.setHeaderText("Please confirm that you want to delete this item.");
        alert.setContentText("Are you sure you want to Delete this item?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
        // ... user chose OK
         modifyPartStage.close();
        } else {
         // ... user chose CANCEL or closed the dialog
         modifyPartStage.show();
        }
    }
    
    /**
     * Validates the user input in the text fields.
     * 
     * @return true if the input is valid
     */    
    @FXML 
    private boolean isPartValid(){        
        String errorMessage = "";        
        try{
            Integer checkInstockField = Integer.parseInt(partInStockField.getText());
            Integer checkMinField = Integer.parseInt(partMinField.getText());
            Integer checkMaxField = Integer.parseInt(partMaxField.getText());
            Double checkPriceField = Double.parseDouble(partPriceField.getText());            
            errorMessage += "";            
        }catch(NumberFormatException e){
            errorMessage += "You must enter only numbers greater than 0 in the Inv, Price, Min, Max fields. ";
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(glasbyImsApp.getPrimaryStage());            
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);
            alert.showAndWait();
            return false;
        }
        
        if(part instanceof Inhouse){
            if(partPriceField.getText().length() > 0){            
                try{
                    Integer checkMachineIdField = Integer.parseInt(partMachineIdField.getText());
                }catch (NumberFormatException m){
                     errorMessage += "You must enter only numbers for the MachineId Field. ";
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.initOwner(glasbyImsApp.getPrimaryStage());            
                    alert.setTitle("Invalid Fields");
                    alert.setHeaderText("Please correct invalid fields");
                    alert.setContentText(errorMessage);
                    alert.showAndWait();
                    return false;
                }
            }
        }        
        if(partNameField.getText() == null || partNameField.getText().length() == 0){
            errorMessage = "Part Name is not valid. ";           
        }        
        if(Integer.parseInt(partInStockField.getText()) <= 0){
            errorMessage += "Please enter a number greater than 0 for the Inv value. ";            
        }
        if(Integer.parseInt(partInStockField.getText()) < Integer.parseInt(partMinField.getText()) || Integer.parseInt(partInStockField.getText()) > Integer.parseInt(partMaxField.getText())){
            errorMessage += "Inv number must be between minimum or maximum value. ";            
        }
        
        if(Integer.parseInt(partMinField.getText()) <= 0){
            errorMessage += "Please enter a number greater than 0 in the Min value. ";            
        }
        
        if(Integer.parseInt(partMinField.getText()) > Integer.parseInt(partMaxField.getText())){
            errorMessage += "Min value must be less than or equal to Max value. ";            
        }
        
        if(Integer.parseInt(partMaxField.getText()) <= 0){
            errorMessage += "Please enter a number greater than 0 in the Max value. ";           
        }
        
        if(Integer.parseInt(partMaxField.getText()) < Integer.parseInt(partMinField.getText())){
            errorMessage += "Max value must be greater than Min value. ";             
        }      
        
        if(errorMessage.length() > 0){           
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(glasbyImsApp.getPrimaryStage());            
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);
            alert.showAndWait();
            return false;            
        }       
        return true;
    }
    
    /**
     * Called when the user clicks handleNewPart().
     */
    public boolean isAddPart(){        
        return addPart;
    }
    
    /**
     * Called when the user clicks handleNewProduct().
     */
    public boolean isAddProduct(){
        return addProduct;
    }
    
}
