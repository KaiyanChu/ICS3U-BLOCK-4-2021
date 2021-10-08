package week5;

import java.util.Scanner;

public class UsingScanner {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
      //  exampleOne(in);
        exampleTwo(in);
        in.close();
    }
    private static void exampleOne(Scanner in) {

        System.out.println("Please enter your name: ");
        String name = in.nextLine();

        System.out.println("Hello " + name);
        
    }

    private static void exampleTwo(Scanner in) {

        System.out.println("Please enter a number: ");
        //double num = in.nextDouble();
        double num = Double.parseDouble(in.nextLine()); //will take a string and if it represents a double it will turn it into a double, if it doesnt it crasehs.


        boolean validInput = false; 

    while(!validInput){
        try{
       System.out.println(Math.pow(num,2));
       validInput = true; 
        
    }catch(Exception ex){
        System.out.println("Invalid Input, please enter a number");
    }

    }
}
}

