import java.util.Scanner;

public class NumberOfDays {
    public static int getMonth(String [] listOfMonth, String month){
        for (int i = 0; i < listOfMonth.length; i++) {
            if (listOfMonth[i].equals(month)) {
                return i % 12 + 1;
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String [] months = {"January", "February" , "March",  "April", "May", "June", "July",
                            "August", "September", "October", "November", "December", "Jan.",
                            "Feb.", "Mar.", "Apr.", "May.", "June.", "July.", "Aug.", "Sept.",
                            " Oct.", "Nov.", "Dec.", "Jan", "Feb", "Mar", "Apr", "May", "Jun",
                            "Jul", "Aug", "Sep", "Oct", "Nov", "Dec", "1", "2", "3", "4", "5", "6",
                            "7", "8", "9", "10", "11", "12"};
        System.out.print("Enter month: ");
        String inputMonth = keyboard.next();
        System.out.print("Enter year: ");
        int year = keyboard.nextInt();
        int month = getMonth(months, inputMonth);
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println("This month has 31 days");
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println("This month has 30 days");
                break;
            case 2:
                if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0){
                    System.out.println("This month has 29 days");
                } else {
                    System.out.println("This month has 28 year");
                }
                break;
            default:
                System.out.println("Invalid month");
                break;
            }
    }
}
