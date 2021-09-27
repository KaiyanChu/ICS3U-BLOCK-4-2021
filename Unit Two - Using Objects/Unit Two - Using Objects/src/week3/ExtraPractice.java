package week3;

public class ExtraPractice {
       
            public static void main(String[] args) {
                exampleOne();
                exampleTwo();
                exampleThree();
                exampleFour(1,20);
                exampleSeven("hi", "hello");
                exampleFive("hello");
                exampleSix("hello","llo");
                exampleEight(4,5,4,6);
                exampleNine(3,4);
                exampleTen("hello");

                
            }
            public static void exampleOne(){
                int randomNum = (int) (Math.random()*100)+1;
                System.out.println(randomNum);
            }
            public static void exampleTwo(){
                int randomNum = (int)(Math.random()*(50+50+1))-50;
                System.out.println(randomNum);
            }
            public static void exampleThree(){
                int randomNum = (int)(Math.random()*(6-1+1))+1;
                System.out.println(randomNum);

            }
            public static void exampleFour(int upper, int lower){
                int randomNum = (int)(Math.random()*(upper-lower+1))+lower;
                System.out.println(randomNum);
            }
            public static String exampleFive(String str) {
                return str.substring(0, str.indexOf("e")) + str.substring(str.indexOf("e") + 1);
            }
            public static String exampleSix(String str, String remove) {
                return str.substring(0, str.indexOf(remove)) + str.substring(str.indexOf(remove) + remove.length());
            }
            public static int  exampleSeven(String str1, String str2){
                int length = str1.length() + str2.length();
                return length;
            }
            public static double exampleEight(int x1, int y1, int x2, int y2){
                double slope = (double)(y2 - y1)/(x2-x1);
                return slope;
            }
            public static double exampleNine(int radius, int height){
                double volume = Math.PI*(Math.pow(radius,2))*height;
                return volume;
            }
            public static String exampleTen(String str){
                int index = (int)(Math.random()*str.length());
                str = str.substring(0,index)  + str.substring(index+1);
                return str;
            }

        }


