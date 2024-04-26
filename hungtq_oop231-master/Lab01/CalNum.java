import java.util.Scanner;

public class CalNum {
    public static void main(String[] args) {
        double num1, num2;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first number");
        num1 = sc.nextDouble();
        System.out.println("Enter the second number");
        num2 = sc.nextDouble();
        System.out.println("The sum of the two numbers is " + (num1 + num2));
        System.out.println("The difference of the two numbers is " + (num1 - num2));
        System.out.println("The product of the two numbers is " + (num1 * num2));
        if(num2 != 0) {
            System.out.println("The quotient of the two numbers is " + (num1 / num2));
        } else {
            System.out.println("Division by zero is not allowed.");
        }
    }
}