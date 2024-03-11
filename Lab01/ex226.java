import java.util.Scanner;
public class ex226 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Choose 1 for FistDegree, 2 for Linear System equations, 3 for Second Degree");
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                Firstdegree();
                break;
            case 2:
                Linearsystem();
                break;
            case 3:
                Seconddegree();
                break;
            default:
                System.out.println("Choose 1, 2, 3 pls");
                break;
        }
    }

    private static void Firstdegree() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter coefficients: ");
        float a = input.nextFloat();
        float b = input.nextFloat();
        if (a == 0) {
            System.out.println("Error: the cofficient a must be != 0");
        }
        else {
            System.out.println("The solution x = " + (-b/a));
        }
    }

    private static void Linearsystem() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter cofficients in form a11 a12 b1: ");
        int a11 = input.nextInt(); int a12 = input.nextInt(); int b1 = input.nextInt();
        int a21 = input.nextInt(); int a22 = input.nextInt(); int b2 = input.nextInt();
        float D1 = b1*a22 - b2*a12;
        float D2 = b2*a11 - b1*a21;
        float D  = a11*a22 - a21*a12;

        if (D == 0) {
            if (D1==0 || D2==0) {
                System.out.println("Infinite Solution");
            }
            else {
                System.out.println("No Solution");
            }
        }
        else {
            System.out.println("The solution x = " + D1/D + " , y = " + D2/D);
        }        
    }

    private static void Seconddegree() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter cofficients:");
        int a = input.nextInt(); 
        int b = input.nextInt(); 
        int c = input.nextInt();
        if (a == 0) {
            System.out.println("The solution x = " + (-c/b));
        }
        else {
            double delta = Math.pow(b,2) - 4*a*c;
            if (delta < 0) {
                System.out.println("No solution");
            }
            else if (delta == 0) {
                System.out.println("Double root x = " + (-b/ (2*a)));
            }
            else {
                System.out.println("The solution x1 = " + ((-b - Math.sqrt(delta))/(2*a)) + " , x2 = " + ((-b + Math.sqrt(delta))/(2*a)));
            }
        }
    }
}