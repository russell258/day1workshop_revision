package sg.edu.nus.iss;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartDB {

    List<String> itemsToSave = new ArrayList<String>();
    String[] itemToSave;

    //previous shoppingCart functions

    public void list(ArrayList<String>cartItems){
        
    }

    public void add(){

    }

    public void delete(){

    }



    //new methods for reading, writing, 

    public void save(String[] itemsToSave, String savedUser){
        this.itemsToSave = itemsToSave;
    }

    public void login(){

    }

    public static void users(File directory){
        for (String user: directory.list()){
            System.out.println(user.toString());
        }
    }

}
