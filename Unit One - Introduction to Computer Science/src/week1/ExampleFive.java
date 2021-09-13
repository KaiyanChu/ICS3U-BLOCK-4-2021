/**
 * 
 */

package week1;

public class ExampleFive {
    public static void main(String[] args) {
        int markOne = 75, markTwo = 80, markThree = 87; //declared 3 intiger variables and assigned them values
       // double average = (markOne+markTwo+markThree)/3; //242/3 = 80 INTEGER MATH/ INTERGER DIVISION 


        double average = (markOne+markTwo+markThree)/3.0; // makes it 80.666x``
        System.out.println("the average is " + average);


//intiger vs double Division
        System.out.println(4 /5);    //0
        System.out.println(4.0 /5);  //0.8
        System.out.println(5 /4);    //1
        System.out.println(5 /4.0);  //1.25
        
// Modulus Operator %

System.out.println(13 /3);  //4
System.out.println(13 %3); //1 remainder
    }
}