package sg.edu.nus.iss;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartDB {

    List<String> itemsToSave = new ArrayList<String>();
    String[] itemToSave;

    //previous shoppingCart functions

    public static void list(ArrayList<String>cartItems){
        int i = 1;
        if (cartItems.size()>0){
            for (String item: cartItems){
                System.out.println(i + ". "+ item);
                i++;
            }
        }else{
            System.out.println("your cart is empty");
        }

    }

    public static void add(String itemToAdd, ArrayList<String>cartItems){
        String[] secondInputItems = itemToAdd.split(" ");
        for (String item:secondInputItems){
                                //check if cart already contains the item
            if (cartItems.contains(item)){
                System.out.println("you already have "+item + " in your cart.");
            }else{
                cartItems.add(item);
                System.out.println(item+" added to cart");
            }
        }
    }

    public static void delete(ArrayList<String>cartItems, int deleteNumber){
        if (deleteNumber!=0 && deleteNumber<=cartItems.size()){
            System.out.println(cartItems.get(deleteNumber-1) + " removed from cart");
            cartItems.remove(deleteNumber-1);
        }else{
            System.out.println("Incorrect item index");
        }
    }

    public static void save(String dirPath, ArrayList<String>cartItems) throws IOException{
        FileWriter filewriter = new FileWriter(dirPath, false);
        for (String item: cartItems){
            filewriter.write(item + "\n");
        }
        filewriter.flush();
        filewriter.close();
        System.out.println("Your cart has been saved");
    }

    public static void login(String dirPath ,String userName, ArrayList<String> cartItems) throws IOException{
        File userFile = new File(dirPath);
        if (userFile.exists()){
            // need to read the items inside
            // and add them to cartItems
            FileReader fr = new FileReader(dirPath);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            //reset the cartItems when logging in
            cartItems.removeAll(cartItems);
            while (line!=null){
                line=br.readLine();
                if (line!=null){
                    cartItems.add(line);
                }
            }
            System.out.println(userName + ", your cart contains the following items");
            ShoppingCartDB.list(cartItems);
            br.close();
            fr.close();
        }else{
            //clear all cartItems when logging in
            cartItems.removeAll(cartItems);
            userFile.createNewFile();
            System.out.println(userName + ", your cart is empty");
  
        }
    }

    public static void users(File directory){
        if (directory.list().length>0){
            System.out.println("The following users are registered");
            for (String user: directory.list()){
                System.out.println(user.toString());
            }
        }
    }

}
