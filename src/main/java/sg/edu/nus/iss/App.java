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
                    for (String item: cartItems){
                        int i = 1;
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
                secondInput = scan.nextLine().trim();
                
                //check that line after add is not empty
                if (!secondInput.equals("")){

                    //replace the commas with nothinig and make each input an element 
                    secondInput = secondInput.trim().replace(",", "");
                    String[] secondInputItems = secondInput.split(" ");
                    
                    // add into cart and print out added
                    for (String item:secondInputItems){
                        //check if cart already contains the item
                        if (cartItems.contains(item)){
                            System.out.println("you have "+item + " in your cart.");
                        }else{
                            cartItems.add(item);
                            System.out.println(item+" added to cart");
                        }

                    }

                }

            }


        //case for delete

        }

        scan.close();
    }
}
