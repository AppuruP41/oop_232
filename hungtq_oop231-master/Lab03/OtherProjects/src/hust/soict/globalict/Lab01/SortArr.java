import java.util.Scanner;
public class SortArr {
    public static void main(String[] args) {
        int n;
        int average;
        int sum = 0;

        System.out.println("Enter n: ");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        System.out.println("The sorted array is: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        
        average = sum / n;
        System.out.println("\nAverage of the array is: " + average);
        System.out.println("Sum of the array is: " + sum);
    }
}
