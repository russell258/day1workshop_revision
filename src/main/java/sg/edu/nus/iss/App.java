package sg.edu.nus.iss;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
        // task 1: check if directory for shoppingcart, cartdb that holds all the users exist. else create it
        // if no args specified, use default directory db
        String dirName ="";

        if (args.length>0){
            dirName = args[0];
            }else{
                dirName = "cartDB";
                System.out.println("You have not passed in any argument so the default directory cartDB will be used");
            }
        File newDirectory = new File(dirName);
        if (!newDirectory.isDirectory()){
            newDirectory.mkdir();
        }
        System.out.println("Welcome to your shopping cart");
        //use scanner to ask for input and check first command
        //loop to keep asking for input
        Scanner scan = new Scanner(System.in);
        ArrayList<String> cartItems = new ArrayList<>();
        String commandInput = "";
        String secondInput = "";
        String dirPath = "";
        Integer deleteNumber = 0;

        while(!commandInput.equals("quit")){
        // call list method return list of files in the directory
            commandInput = scan.next().trim();
            if (commandInput.equals("users")){
                ShoppingCartDB.users(newDirectory);
            }

        // call login method
            if (commandInput.equals("login")){
                secondInput = scan.nextLine().trim();
                dirPath = newDirectory + File.separator + secondInput;
                ShoppingCartDB.login(dirPath, secondInput, cartItems);
            }
            
        // call add method
            if (commandInput.equals("list")){
                ShoppingCartDB.list(cartItems);
            }

            if (commandInput.equals("add")){
                secondInput = scan.nextLine().trim();
                if (!secondInput.equals("")){
                    secondInput = secondInput.trim().replaceAll(" +", " ");
                    ShoppingCartDB.add(secondInput, cartItems);
                }
            }

            if (commandInput.equals("delete")){
                secondInput=scan.nextLine().trim();
                if (secondInput.matches(".*\\d+.*")){
                    deleteNumber = Integer.parseInt(secondInput);
                    ShoppingCartDB.delete(cartItems, deleteNumber);
                }
            }
            //save, write from current arraylist into the user file and flush
            if (commandInput.equals("save")){

            }

        }
        scan.close();
    }
}
