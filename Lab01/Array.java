import java.util.Scanner;
import java.util.Arrays;
public class Array {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter size of array: ");
        int n  = keyboard.nextInt();
        int[] arr = new int[n];
        for (int i =0; i < n; i++) {
            arr[i] = keyboard.nextInt();
        }

       
        Arrays.sort(arr);
        int sum = 0;
        System.out.print("Sorted array: ");
        for (int i =0; i < n; i++) {
            sum += arr[i];
            System.out.print(arr[i] + " ");
        }

        System.out.println("\nSum: " + sum);
        System.out.println("Average: " + (double)sum/n);
       
    }
}
