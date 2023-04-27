package sg.edu.nus.iss;

import java.io.File;
import java.util.ArrayList;
// import java.io.Console;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        
        // task 1: check if directory for shoppingcart, cartdb that holds all the users exist. else create it
        // if no args specified, use default directory db
        if (args.length>0){
            String dirPath = args[0];
            String fileName = args[1];
            String dirPathFileName = dirPath + File.separator + fileName;
            for (String arg: args){
                System.out.println(arg);
            }
        }else{
            String dirPathFileName = "C:" + File.separator + "data";
            System.out.println("You have not passed in any argument so the default directory db will be used");
        }


        // task 2:
        // scan keywords > login, list, add, delete, save, users
        
        // login
        //detect if file exists, otherwise create user file

        // save
        // write from current arraylist into the user file and flush

        // users
        // list all the files in the directory

        System.out.println("Welcome to your shopping cart");
        //Console con = System.console();
        Scanner scan = new Scanner(System.in);

        String commandInput = " ";
        String secondInput = " ";
        ArrayList<String> cartItems = new ArrayList<>();


        //loop to keep asking for input
        while(!commandInput.equals("quit")){
            //use scanner to ask for input and check first command
    
            commandInput = scan.next();

            // cases for list
            if (commandInput.equals("list")){
                if (cartItems.size()>0){
                    int i = 1;
                    for (String item: cartItems){
                        System.out.println(i + ". " + item);
                        i++;
                    }
                }else{
                    System.out.println("Your cart is empty");
                }
            }

            //case for add
            if (commandInput.equals("add")){
                // if add, scan line after the add
                // replace the commas with nothing
                secondInput = scan.nextLine().trim().replace(",","");
                //check that line after add is not empty
                if (!secondInput.equals("")){
                    //replace all additional spaces into one space and make each input an element 
                    secondInput = secondInput.trim().replaceAll(" +", " ");
                    String[] secondInputItems = secondInput.split(" ");
                    // add into cart and print out added
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
            }
            //case for delete
            if (commandInput.equals("delete")){
                // collect the index integer for deleting
                int deleteNumber = 0;
                deleteNumber = scan.nextInt();
                if (deleteNumber!=0 && deleteNumber<=cartItems.size()){
                    System.out.println(cartItems.get(deleteNumber-1) + " removed from cart");
                    cartItems.remove(deleteNumber-1);
                }else{
                    System.out.println("Incorrect item index");
                }
            }
        }

        scan.close();
    }
}
