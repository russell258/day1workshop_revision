package sg.edu.nus.iss;

import java.util.ArrayList;
// import java.io.Console;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
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
