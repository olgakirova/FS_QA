import java.util.Scanner;

public class test5 {



public static void main (String[] args) {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter a: ");
            int a = in.nextInt();

            System.out.println("Enter b: ");
            int b = in.nextInt();
            int cnt = 0;
            for (int i = a; i <= b; i ++) {

                if (i % 12 == 0 && i > 0) {
                    cnt++;
                }

            }
            System.out.println("Result: " + cnt);

        }


}
