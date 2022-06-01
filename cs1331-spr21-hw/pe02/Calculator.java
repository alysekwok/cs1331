import java.util.Scanner;

public class Calculator {
   public static void main(String[] args) {
       int firstNumber = 0;
       int secondNumber = 0;
       Scanner myScanner = new Scanner(System.in);

       System.out.println("Enter your first number:");
       firstNumber = myScanner.nextInt();

       System.out.println("Enter your second number:");
       secondNumber = myScanner.nextInt();

       System.out.println("Sum is " + (firstNumber + secondNumber));
       System.out.println("Difference is " + (firstNumber - secondNumber));
       System.out.println("Product is " + (firstNumber * secondNumber));
       System.out.println("Quotient is " + ((double) firstNumber / secondNumber));



   } 
}