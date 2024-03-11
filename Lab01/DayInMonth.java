import java.util.Scanner;
public class DayInMonth {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter Month");
        String strMonth = keyboard.nextLine();
        int Month = Month(strMonth);
        //System.out.println("Month: " + Month);
        if (Month == 0) {
            System.out.println("Month value must be != 0");
            System.exit(0);
        }
        
        System.out.println("Enter year:");
        String strYear = keyboard.nextLine();
        int Year = Year(strYear);
        if (Year == 0) {
            System.out.println("Year value must be != 0");
            System.exit(0);
        }
        boolean LeapYear = ((Year%4 == 0 && Year%100 != 0) || (Year%400 == 0)) ? true : false;

        System.out.println("Days in that Month: " + showResult(Month, Year,LeapYear));


    }
    private static int Month(String strMonth) {
        try {
            int Month = Integer.parseInt(strMonth);
            return (Month>=1 && Month<=12) ? Month : 0;
        }
        catch (NumberFormatException e) {
            if (strMonth.substring(0,3).equals("Jan")) {
                return 1;
            }
            else if (strMonth.substring(0,3).equals("Feb")) {
                return 2;
            }
            else if (strMonth.substring(0,3).equals("Mar")) {
                return 3;
            }
            else if (strMonth.substring(0,3).equals("Apr")) {
                return 4;
            }
            else if (strMonth.substring(0,3).equals("May")) {
                return 5;
            }
            else if (strMonth.substring(0,3).equals("Jun")) {
                return 6;
            }
            else if (strMonth.substring(0,3).equals("Jul")) {
                return 7;
            }
            else if (strMonth.substring(0,3).equals("Aug")) {
                return 8;
            }
            else if (strMonth.substring(0,3).equals("Sep")) {
                return 9;
            }
            else if (strMonth.substring(0,3).equals("Oct")) {
                return 10;
            }
            else if (strMonth.substring(0,3).equals("Nov")) {
                return 11;
            }
            else if (strMonth.substring(0,3).equals("Dec")) {
                return 12;
            }
            else {
                return 0;
            }
        }   

    }
    private static int Year(String strYear) {
        try {
            int Year = Integer.parseInt(strYear);
            return (strYear.length()==4) ? Year : 0;
        }
        catch (NumberFormatException e) {
            return 0;
        }
    }
    private static int showResult(int Month, int Year, boolean LeapYear) {
        switch (Month) {
            case 1:
                return 31;
            case 2:
                return (LeapYear==true) ? 28 : 29;
            case 3:
                return 31;
            case 4:
                return 30;
            case 5:
                return 31;
            case 6:
                return 30;
            case 7:
                return 31;
            case 8:
                return 31;
            case 9:
                return 30;
            case 10:
                return 31;
            case 11:
                return 30;
            case 12:
                return 31;
            default:
                return 0;
        }
    }
}