import java.util.Scanner;
public class SumMatrix {
    public static void main(String[] args) {
        
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter the size of matrix: ");
        int row = keyboard.nextInt();
        int col = keyboard.nextInt();
        int[][] matrixA = new int[row][col];
        int[][] matrixB = new int[row][col];
        
        System.out.println("Enter coefficient for the first matrix: ");
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                matrixA[i][j] = keyboard.nextInt();
            }
        }

        System.out.println("Enter coefficient for the second matrix: ");
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                matrixB[i][j] = keyboard.nextInt();
            }
        }
        

        //calulate sum of two matrix
        System.out.println("Sum of two matrix: ");
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                System.out.print((matrixA[i][j] + matrixB[i][j]) + " ");
            }
            System.out.println();
        }
    }
}
