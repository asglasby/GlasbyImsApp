/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glasbyimsapp.model;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 *
 * @author aglasby
 */

// This class is here for purposes of requirements.  Please refer to the Inventory Controller which replaces this class.
public class Inventory {
    public static ObservableList<Product> products = FXCollections.observableArrayList();
    public static ObservableList<Part> allParts = FXCollections.observableArrayList();
    
    private void addProduct(){
    }
    
    private boolean removeProduct(int productID){
        return true;
    }    
    
    private Product lookupProduct(int productID){        
        return products.get(productID);
    }    

    public void updateProduct(int productID){    
    }    

    public void addPart(Part part){    
    }    
   
    public boolean deletePart(Part part){
        return true;
    }

    public void updatePart(int partID){    
    }    
}
