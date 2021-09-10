package week1;

public class ExampleThree {
    public static void main(String[] args) {
     //   System.out.println("This is ''very'' important") //double quotes encapsulate string literal putting a quote within a string literal gets Java UPSET
     System.out.println("This is \"very\" important");
     //System.out.println("This is \very important");// \v is not a valid escape sequence
     System.out.println("This\n is\n very important");// the important escapes are \\, \", (\n NEW LINE)
    }

}