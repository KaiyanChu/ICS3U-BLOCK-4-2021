package week10;

public class ArrayExamples {
    public static void main(String[] args) {
        exampleOne();
        exampleTwo();

        int[] arr = {5, 7, 3, 2, 5, 2};
        mystery(arr);

        
        int numOdd = numOdd(arr);
    }

    private static int numOdd(int[] arr) {
        int numOdd = 0;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i]%2 ==1)
                numOdd++;
        }
        return numOdd;
    
    }

    private static void mystery(int[] arr) {
        int index = (int)(Math.random()*arr.length);
        arr[index] = -arr[index];
    }

    private static void exampleTwo() {
        Animal[] animals = new Animal[3];
        animals[1] = new Animal();
        animals[1].eat();
    }

    private static void exampleOne() {
        int [] arr = new int[5]; //arrays are reference types //starts off with 0s in all the boxes     
        arr[4] = 2;
        arr[3] = 7;
        System.out.println(arr.length); //no round brackets
    }
     
}

