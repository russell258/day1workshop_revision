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
                        int i = 0;
                        System.out.println(i + ". " + item);
                    }
                }else{
                    System.out.println("Your cart is empty");
                }
            }


                    

        // case for add

                // secondInput = commandInput.substring(5);
                // System.out.println(secondInput);


        //case for delete

        }

        scan.close();
    }
}
