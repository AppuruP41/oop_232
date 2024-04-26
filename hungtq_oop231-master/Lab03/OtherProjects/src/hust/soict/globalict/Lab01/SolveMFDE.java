import java.util.Scanner;

public class SolveMFDE {   
        public static void main(String[] args) {
            
            double a11, a12, a21, a22, b1, b2, x, y;
            Scanner sc = new Scanner(System.in);

            System.out.println("Java Program to find x from equation: a11x + a12y = b1 and a21x + a22y = b2");
            System.out.println("Enter a11: ");
            a11 = sc.nextDouble();
            System.out.println("Enter a12: ");
            a12 = sc.nextDouble();
            System.out.println("Enter a21: ");
            a21 = sc.nextDouble();
            System.out.println("Enter a22: ");
            a22 = sc.nextDouble();
            System.out.println("Enter b1: ");
            b1 = sc.nextDouble();
            System.out.println("Enter b2: ");
            b2 = sc.nextDouble();

            double det = a11*a22 - a12*a21;

            // vo so nghiem
            if (det == 0 ) {
                System.out.println("This equation has infinite solution");
                System.exit(0);
            }
            // vo nghiem 
            if ((det == 0) && (b1*a22 - b2*a12 != 0) && (a11*b2 - a21*b1 != 0)) {
                System.out.println("This equation has no solution");
                System.exit(0);
            }
            
            // co nghiem
            if ( det != 0 ) {
                x = (b1*a22 - b2*a12)/det;
                y = (a11*b2 - a21*b1)/det;
                System.out.println("The unique solution ( x , y ) is: " + x + " " + y);
            }           
        }
    }
