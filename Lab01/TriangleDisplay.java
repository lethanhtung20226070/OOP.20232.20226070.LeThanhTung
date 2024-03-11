import java.util.Scanner;
public class TriangleDisplay {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int n = keyboard.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println(" ".repeat((2*n-1) -(n+i)) + "*".repeat(2*i + 1));
        }
    }
}