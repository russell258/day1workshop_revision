package sg.edu.nus.iss;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args ){


        //print out welcome to your shopping cart
        System.out.println("Welcome to your shopping cart!");

        //declare scanner for input or can use bufferedReader too
        Scanner scan = new Scanner(System.in);
        String input = "";
        String secondInput = "";
        int secondInt = 0;
        String[] addList = null;
        

        //declare arraylist shoppingcart for storing
        List <String> shoppingCart = new ArrayList<String>();

        //important to use .equals instead of != for string
        while (!input.equals("quit")){
            //put the input inside declare scan so no infinite loop and have scan input.
            // print ">" before scan
            System.out.print("> ");
            input = scan.next();
            //case for list
            if (input.equals("list")){
                if (shoppingCart.size()!=0){
                    int i=1;
                    for (String item: shoppingCart){
                        System.out.println(i + ". "+item);
                        i++;
                    }
                }else{
                    System.out.println("Your cart is empty");
                }
            }
            // case for add
            // split the multiple add inputs
            // remove the whitespace and commas
            // print out added or already have
            if (input.equals("add")){
                secondInput = scan.nextLine().trim().toLowerCase();
                if (!secondInput.isEmpty()){
                    //beautiful regex https://stackoverflow.com/questions/49089755/how-to-split-expression-by-comma-and-space-in-java
                    addList = secondInput.split("[ ,]+");

                    for (String addItem: addList){
                        if (shoppingCart.contains(addItem)){
                            System.out.println("You have "+ addItem + " in your cart");
                        }else{
                            shoppingCart.add(addItem);
                            System.out.println(addItem + " added to your cart");
                        }


                    }
                }else{
                    System.out.println("Please add something");
                }
            }

            //case for delete
            if (input.equals("delete")){
                secondInput = scan.nextLine();
                if (secondInput.isEmpty() || !secondInput.matches(".*\\d+.*")){
                    System.out.println("Incorrect input");
                }else{
                    secondInt = Integer.parseInt(secondInput.trim()) - 1;
                    if (secondInt >= shoppingCart.size()){
                        System.out.println("Incorrect item index");
                    }else{
                        System.out.println(shoppingCart.get(secondInt) + " removed from cart");
                        shoppingCart.remove(secondInt);
                    }
                }


            }

        }
        scan.close();
    }
}
