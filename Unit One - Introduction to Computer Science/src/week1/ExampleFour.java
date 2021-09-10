package week1;
/**Variables- Used to store informatoin / data / value 
 *       YOU NEED TO SPECIFY THE TYPE OF DATA YOU ARE GOING TO STORE
 * Primitive Data Types
 *       (int(integer(no decimal))/double(decimal)/char(character)/boolean(true or false))
 * Assignment / Assignment Operator - assigns a value to a variable (=)
 */
public class ExampleFour {
    public static void main(String[] args) {
        int markOne = 75, markTwo = 80, markThree = 87; //declared 3 intiger variables and assigned them values

        int average = (markOne + markTwo + markThree)/3;
        
        System.out.println("The average is " + average);
    }

}