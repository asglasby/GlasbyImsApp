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

/**
 *
 * @author aglasby
 */
public class Inhouse extends Part{
    protected IntegerProperty machineID;    
    
    // Constructors
    public Inhouse() {
        partId = new SimpleIntegerProperty();
        partName = new SimpleStringProperty(); 
        partPrice = new SimpleDoubleProperty();
        partInStock = new SimpleIntegerProperty();
        partMin = new SimpleIntegerProperty();
        partMax = new SimpleIntegerProperty();
        machineID = new SimpleIntegerProperty(0);        
    }
    
    public Inhouse(int partID, String name, double price, int inStock, int min, int max, int machineID){   
        this.partId = new SimpleIntegerProperty(partID);        
        this.partName = new SimpleStringProperty(name);
        this.partPrice = new SimpleDoubleProperty(price);
        this.partInStock = new SimpleIntegerProperty(inStock);
        this.partMin = new SimpleIntegerProperty(min);
        this.partMax = new SimpleIntegerProperty(max); 
        this.machineID = new SimpleIntegerProperty(machineID);
    }  
    
    // Accessors and Mutators - getters and setters  
    public int getMachineID() {
        return machineID.get();
    }
    
    public void setMachineID(Integer machineID){        
        this.machineID = new SimpleIntegerProperty(machineID);
    }
    
    public IntegerProperty machineIdProperty(){
        return machineID;
    }    
}
