import java.util.Scanner;
public class ex225{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double num1 = Double.parseDouble(input.nextLine());
        double num2 = Double.parseDouble(input.nextLine());
        System.out.println("sum:" + (num1+num2));
        System.out.println("difference:" + Math.abs(num1-num2));
        System.out.println("product:" + (num1*num2));
        if (num2 != 0){
            System.out.println("quotient:" + (num1/num2));
        }
        else {
            System.out.println("Error");
        }
 
}
}
