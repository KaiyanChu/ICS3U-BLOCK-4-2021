package week6;

public class ComparingObjects {
    public static void main(String[] args) {
        //when we compare (invisible) strings we (are) NEVER EVER EVER (getting back together) use ==

        //why?
        //if we dont instantiate an object then the variable stores NULL
        //otherwise the variable stores the adress of the actual object.
        
        //why?
        // when you use == you are comapring what is stored in the varibale
        //which is the adress (location in memory where the object is store);

        //equals meathod compares the sequence of the characters in the two objects

        String s1 = new String("hello");
        String s2 = new String("hello");
        
        System.out.println(s1.equals(s2));

        String str1 = "ABCD";
        String str2 = "BCD";

        System.out.println("A".compareTo("a"));
    }
}
