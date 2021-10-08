package week5;

import jdk.tools.jlink.internal.SymLinkResourcePoolEntry;

public class FormatingString {
    //5:7.345
    //5:07.345]
public static void main(String[] args) {
    
    int minutes = 5;
    double seconds = 7.5;

    System.out.println("" + minutes + ":" + seconds);

    //placeholder
//%d placeholder for integers
//%s placeholder for strings
//%f placehor for doubles
    System.out.printf("%d:%.3f", minutes, seconds);
}
    

}
