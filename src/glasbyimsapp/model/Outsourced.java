/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glasbyimsapp.model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author aglasby
 */
public class Outsourced extends Part{
    protected StringProperty companyName;
    
    // Constructors
    public Outsourced(){
        partId = new SimpleIntegerProperty();
        partName = new SimpleStringProperty(); 
        partPrice = new SimpleDoubleProperty();
        partInStock = new SimpleIntegerProperty();
        partMin = new SimpleIntegerProperty();
        partMax = new SimpleIntegerProperty();
        companyName = new SimpleStringProperty();        
    }
    
    public Outsourced(int partID, String name, double price, int inStock, int min, int max, String companyName){   
        this.partId = new SimpleIntegerProperty(partID);        
        this.partName = new SimpleStringProperty(name);
        this.partPrice = new SimpleDoubleProperty(price);
        this.partInStock = new SimpleIntegerProperty(inStock);
        this.partMin = new SimpleIntegerProperty(min);
        this.partMax = new SimpleIntegerProperty(max); 
        this.companyName = new SimpleStringProperty(companyName);
    }    
    
    // Accessors and Mutators - getters and setters  
    public String getCompanyName(){
        return companyName.get();       
    }
    
    public void setCompanyName(String companyName){
        this.companyName = new SimpleStringProperty(companyName);        
    }
    
    public StringProperty companyName(){
        return companyName;
    }    
}
