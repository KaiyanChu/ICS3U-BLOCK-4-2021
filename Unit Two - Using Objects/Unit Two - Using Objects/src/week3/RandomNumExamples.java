package week3;

public class RandomNumExamples {
    public static void main(String[] args) {
        for(int i =0; i<100; i ++){
        double r = Math.random();
        //System.out.println((int)r);

        int lower = -5;
        int upper = 5;

        int rand = (int)(r*(upper-lower+1))+lower;
        System.out.println(rand);


        String str = "Random Numbers"; //change a random cahracter in str to "x"
        int index = (int)(Math.random()*str.length());
        str = str.substring(0,index) + "x" + str.substring(index+1);
        System.out.println(str);
        
        

        }
    }
    
}
