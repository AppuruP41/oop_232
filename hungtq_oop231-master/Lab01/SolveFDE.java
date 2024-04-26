import java.util.Scanner;

public class SolveFDE {
    public static void main(String[] args) {
        double a, b;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a: ");
        a = sc.nextDouble();
        if (a == 0) {
            System.out.println("a must be different from 0");
            System.exit(0);
        }
        System.out.println("Enter b: ");
        b = sc.nextDouble();
        System.out.println("The solution is: " + (-b/a));
    }
}
