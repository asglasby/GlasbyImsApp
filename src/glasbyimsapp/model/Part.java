/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glasbyimsapp.model;

/**
 *
 * @author aglasby
 */

import java.time.LocalDate;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.DoubleProperty;


public abstract class Part {
    public static int partNumber = 4;
    protected IntegerProperty partId;
    protected StringProperty partName;
    protected DoubleProperty partPrice;
    protected IntegerProperty partInStock;
    protected IntegerProperty partMin;
    protected IntegerProperty partMax;    
    
     // Accessors and Mutators - getters and setters    
    public int getPartId(){        
        return partId.get();
    }    
    
    public void setPartId(Integer partId){
        partId = partNumber++;
        this.partId = new SimpleIntegerProperty(partId);
    }
    
    public IntegerProperty partIdProperty() {        
        return partId;
    } 
    
    public String getPartName(){
        return partName.get();
    }
    
    public void setPartName(String partName){
        this.partName = new SimpleStringProperty(partName);
    }
    
    public StringProperty partNameProperty(){
        return partName;
    }    

    public double getPartPrice(){
        return partPrice.get();
    }
    
    public void setPartPrice(double partPrice){
        this.partPrice = new SimpleDoubleProperty(partPrice);
    }
    
    public DoubleProperty partPriceProperty(){
        return partPrice;
    }
    
    public int getPartInStock(){
        return partInStock.get();
    }
    
    public void setPartInStock(int partInStock){
        this.partInStock = new SimpleIntegerProperty(partInStock);
    }
    
    public IntegerProperty partInStockProperty(){
        return partInStock;
    }
    
    public int getPartMin(){
        return partMin.get();
    }
    
    public void setPartMin(int partMin){
        this.partMin = new SimpleIntegerProperty(partMin);
    }
    
    public IntegerProperty partMinProperty(){
        return partMin;
    }
    
    public int getPartMax(){
        return partMax.get();
    }
    
    public void setPartMax(int partMax){
        this.partMax = new SimpleIntegerProperty(partMax);
    }
    
    public IntegerProperty partMaxProperty(){
        return partMax;
    }

}

