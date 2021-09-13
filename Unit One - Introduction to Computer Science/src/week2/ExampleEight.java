package week2;
/**
 * final modifier makes it so that you cant change the variable 
 */
public class ExampleEight {
    public static void main(String[] args) {
        final int NUM_MARKS = 5;
    
        int markOne = 78, markTwo = 87, markThree = 64, markFour = 95, markFive = 84;
        
        double average = (double)(markOne + markTwo + markThree + markFour + markFive)/NUM_MARKS; //TYPECASTING you can treat ints as doubles by just putting it infront of it
    
        System.out.println("The Average is " + average);

        double y = 3.7;
        int x = (int)y;


        double z = (double)7;//explicit cast

        // int -> double // widening conversino
        // double -> int//  narrowing conversion

    //    boolean p = (int)true; you can't cast from boolean to int 

    }
   

}
 //