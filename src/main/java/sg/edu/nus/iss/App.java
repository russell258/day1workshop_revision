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
        String commandInput = "";
        String secondInput = "";
        String dirPath = "";
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
                ShoppingCartDB.login(dirPath, secondInput);
            }
            



        }
        scan.close();
    }
}




        // task 2:
        // scan keywords > login, list, add, delete, save, users
        
        // login
        //detect if file exists, otherwise create user file

        // save
        // write from current arraylist into the user file and flush



    //     System.out.println("Welcome to your shopping cart");
    //     //Console con = System.console();
  

    //     String commandInput = " ";
    //     String secondInput = " ";
    //     ArrayList<String> cartItems = new ArrayList<>();



    


    //         // cases for list
    //         if (commandInput.equals("list")){
    //             if (cartItems.size()>0){
    //                 int i = 1;
    //                 for (String item: cartItems){
    //                     System.out.println(i + ". " + item);
    //                     i++;
    //                 }
    //             }else{
    //                 System.out.println("Your cart is empty");
    //             }
    //         }

    //         //case for add
    //         if (commandInput.equals("add")){
    //             // if add, scan line after the add
    //             // replace the commas with nothing
    //             
    //             //check that line after add is not empty
    //             if (!secondInput.equals("")){
    //                 //replace all additional spaces into one space and make each input an element 
    //                 secondInput = secondInput.trim().replaceAll(" +", " ");
    //                 String[] secondInputItems = secondInput.split(" ");
    //                 // add into cart and print out added
    //                 for (String item:secondInputItems){
    //                     //check if cart already contains the item
    //                     if (cartItems.contains(item)){
    //                         System.out.println("you already have "+item + " in your cart.");
    //                     }else{
    //                         cartItems.add(item);
    //                         System.out.println(item+" added to cart");
    //                     }
    //                 }
    //             }
    //         }
    //         //case for delete
    //         if (commandInput.equals("delete")){
    //             // collect the index integer for deleting
    //             int deleteNumber = 0;
    //             deleteNumber = scan.nextInt();
    //             if (deleteNumber!=0 && deleteNumber<=cartItems.size()){
    //                 System.out.println(cartItems.get(deleteNumber-1) + " removed from cart");
    //                 cartItems.remove(deleteNumber-1);
    //             }else{
    //                 System.out.println("Incorrect item index");
    //             }
    //         }
    //     }

    //     scan.close();
//     }
// }
