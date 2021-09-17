package week2;

public class StringExamples {
    public static void main(String[] args) {
        String s1 = "Max"; //string literal
        String s2 = "Fred"; //string literal
        String s3 = "Max";
        String s4 = new String("Kyle"); //string object
        String s5 = new String("Max");

        System.out.println(s1.length()); //length returns the number of charactchters in a string 
        System.out.println(s1.equals(s5));
        System.out.println(s1.equals("max"));
    
        System.out.println("Brad".indexOf("ra")); //index of brad is 1
        System.out.println(s2.indexOf("Red")); //Red is not in fred so it retursn -1
        
        String x = "ABCDEF";
        System.out.println(x.substring(2)); //returns until the end 
        System.out.println(x.substring(2,4)); //returns until 4 it doesn't include the other index //[ is incluseve] (exclusive)
    }
}
 