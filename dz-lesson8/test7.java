import java.util.Scanner;
public class test7{
public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter month: ");
        int month = in.nextInt();

        String season = "";
        switch (month) {
            default:
                season = "Unknown";
                break;
            case 1:
            case 2:
            case 12:
                season = "Winter";
                break;

            case 3:
            case 4:
            case 5:
                season = "Spring";
                break;

            case 6:
            case 7:
            case 8:
                season = "Summer";
                break;

            case 9:
            case 10:
            case 11:
                season = "Autumn";
                break;
        }

        System.out.println(season);
    }
}
