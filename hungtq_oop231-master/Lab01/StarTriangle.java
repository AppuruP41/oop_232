import java.util.Scanner;
public class StarTriangle {
    public static void main(String[] args) {
        int n ;
        System.out.println("Enter n (height): ");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        if ( n < 0 ) {
            System.out.println("Invalid input");
            System.exit(0);
        }
        System.out.println("The star triangle with height " + n + " is: ");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");   
            }
            for (int k = 1; k <= 2*i - 1; k++) {
                System.out.print("*");
            }        
            System.out.println();
        }
    }
}
