import java.util.Scanner;
public class DisplayMonth {
    public static void main(String[] args) {
        String month;
        int year;
        int year_status;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter year: ");
        year = sc.nextInt();
        if ( year < 0 ) {
            System.out.println("Invalid input, year must be > 0");
            System.exit(0);
        }
        if ( year % 4 == 0 ) {
            if ( year % 100 == 0 ) {
                if ( year % 400 == 0 ) {
                    year_status = 1;
                } else {
                    year_status = 0;
                }
            } else {
                year_status = 1;
            }
        } else {
            year_status = 0;
        }
        System.out.println("year_status: " + year_status);
        sc.nextLine();
        System.out.println("Enter month: ");
        month = sc.nextLine().toLowerCase();
       
        switch (month) {
            case "january":
            case "jan.":
            case "jan":
            case "1":
                System.out.println("31 days");
                break;
            case "february":
            case "feb.":
            case "feb":
            case "2":
                System.out.println(year_status == 1 ? "29 days" : "28 days");
                break;
            case "march":
            case "mar.":
            case "mar":
            case "3":
                System.out.println("31 days");
                break;
            case "april":
            case "apr.":
            case "apr":
            case "4":
                System.out.println("30 days");
                break;
            case "may":
            case "5":
                System.out.println("31 days");
                break;
            case "june":
            case "jun.":
            case "jun":
            case "6":
                System.out.println("30 days");
                break;
            case "july":
            case "jul.":
            case "jul":
            case "7":
                System.out.println("31 days");
                break;
            case "august":
            case "aug.":
            case "aug":
            case "8":
                System.out.println("31 days");
                break;
            case "september":
            case "sep.":
            case "sep":
            case "9":
                System.out.println("30 days");
                break;
            case "october":
            case "oct.":
            case "oct":
            case "10":
                System.out.println("31 days");
                break;
            case "november":
            case "nov.":
            case "nov":
            case "11":
                System.out.println("30 days");
                break;
            case "december":
            case "dec.":
            case "dec":
            case "12":
                System.out.println("31 days");
                break;
            default:
                System.out.println("Invalid month input");
                break;
        }       
    }   
}
