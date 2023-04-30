package sg.edu.nus.iss;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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



    //new methods for reading, writing,  GET TO THIS LATER

    // public void save(String[] itemsToSave, String savedUser){
    //     this.itemsToSave = itemsToSave;
    // }

    public static void login(String dirPath ,String userName) throws IOException{
        File userFile = new File(dirPath);
        if (userFile.exists()){
            System.out.println(userName + " already exists");
            // need to read items inside
            FileReader fr = new FileReader(dirPath);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while (line!=null){
                System.out.println(line);
                line=br.readLine();
            }
            br.close();
            fr.close();

        }else{
            userFile.createNewFile();
            System.out.println(userName + ", your cart is empty");
        }
    }

    public static void users(File directory){
        for (String user: directory.list()){
            System.out.println(user.toString());
        }
    }

}
