package week2;

public class ModulusExample {
    public static void main(String[] args) {
        int num = 5672;
        int num1 = num / 1000; //5
        int num2 = num % 1000 /100; //6
        int num3 = num/10 % 10;//7
        int num4 = num % 10; //2
      System.out.println(num1 + num2 + num3 + num4);
    }
}
