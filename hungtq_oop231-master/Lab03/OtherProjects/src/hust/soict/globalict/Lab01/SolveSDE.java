import java.util.Scanner;

public class SolveSDE {
     public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter coefficient a: ");
        double a = scanner.nextDouble();
        System.out.println("Enter coefficient b: ");
        double b = scanner.nextDouble();
        System.out.println("Enter coefficient c: ");
        double c = scanner.nextDouble();

        if(a == 0) {
            if(b == 0) {
                System.out.println("Infinite of or No solution");
            }
            else {
                System.out.println("The solution is x = " + (-c/b));
            }
        } else {
            double delta = b*b - 4*a*c;
            if(delta > 0) {
                System.out.println("There are 2 solution x1 = " + (-b - Math.sqrt(delta))/(2*a) + " x2 = " + (-b + Math.sqrt(delta))/(2*a) );
            } else if  (delta == 0) {
                System.out.println("There is 1 solution x = " + -b/(2*a));
            } else {
                System.out.println("There is no solution");
            }
        }
    }
}


