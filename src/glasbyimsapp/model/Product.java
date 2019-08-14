/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glasbyimsapp.model;

import java.util.ArrayList;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author aglasby
 */
public class Product {
    ArrayList<Part> associatedParts1 = new ArrayList<>();
    
    public ObservableList<Part> associatedParts = FXCollections.observableArrayList();
    
    public static int productNumber = 4;
    protected IntegerProperty productId;
    protected StringProperty productName;
    protected DoubleProperty productPrice;
    protected IntegerProperty productInStock;
    protected IntegerProperty productMin;
    protected IntegerProperty productMax;    
    
    // Constructors
    public Product(){
        this(0, "", 0.0, 0, 0, 0, null);
    }   
    
    public Product(int productId, String productName, double productPrice, int productInStock, int productMin, int productMax, ObservableList<Part> associatedParts){
        this.productId = new SimpleIntegerProperty(productId);        
        this.productName = new SimpleStringProperty(productName);
        this.productPrice = new SimpleDoubleProperty(productPrice);
        this.productInStock = new SimpleIntegerProperty(productInStock);
        this.productMin = new SimpleIntegerProperty(productMin);
        this.productMax = new SimpleIntegerProperty(productMax); 
        this.associatedParts = associatedParts;        
    }  
    
    public Product(int productId, String productName, double productPrice, int productInStock, int productMin, int productMax){
        this.productId = new SimpleIntegerProperty(productId);        
        this.productName = new SimpleStringProperty(productName);
        this.productPrice = new SimpleDoubleProperty(productPrice);
        this.productInStock = new SimpleIntegerProperty(productInStock);
        this.productMin = new SimpleIntegerProperty(productMin);
        this.productMax = new SimpleIntegerProperty(productMax);         
    }    
    
    // Accessors and Mutators - getters and setters
    public int getProductId(){
         return productId.get();
    }
    
    public void setProductId(Integer productId){
        productId = productNumber++;
        this.productId = new SimpleIntegerProperty(productId);
    }
    
    public IntegerProperty productIdProperty(){
        return productId;
    }
    
    public String getProductName(){
        return productName.get();
    }
    
    public void setProductName(String productName){
        this.productName = new SimpleStringProperty(productName);
    }
    
    public StringProperty productNameProperty(){
        return productName;
    }
    
    public Double getProductPrice(){
        return productPrice.get();
    }
    
    public void setProductPrice(double productPrice){
        this.productPrice = new SimpleDoubleProperty(productPrice);
    }
    
    public DoubleProperty productPriceProperty(){
        return productPrice;
    }
    
    public int getProductInStock(){
        return productInStock.get();
    }
    
    public void setProductInStock(int productInStock){
        this.productInStock = new SimpleIntegerProperty(productInStock);
    }
    
    public IntegerProperty productInStockProperty(){
        return productInStock;
    }
    
    public int getProductMin(){
        return productMin.get();
    }   
    
    public void setProductMin(int productMin){
        this.productMin = new SimpleIntegerProperty(productMin);
    }
    
    public IntegerProperty productMinProperty(){
        return productMin;
    }
    
     public int getProductMax(){
        return productMax.get();
    }   
    
    public void setProductMax(int productMax){
        this.productMax = new SimpleIntegerProperty(productMax);
    }
    
    public IntegerProperty productMaxProperty(){
        return productMax;
    }    

    public ObservableList<Part> addAssociatedPart(ObservableList<Part> associatedParts){        
        return associatedParts;
    }
    
    public ObservableList<Part> getAssociatedPartData(){
        return associatedParts;
    }
    
    public boolean removeAssociatedPart(int partID){
        return true;
    }

}
