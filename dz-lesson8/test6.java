import java.util.Scanner;

public class test6 {
 

public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter k: ");
        int k = in.nextInt();
        int r = 0;
        boolean exist = false;

        if (k < 1) {
            System.out.println("incorrect k");
            return;
        }

        for (int i = 1; r <= k; i++) {
            r += i;
            System.out.println("try " + r);
            if (r == k) {
                exist = true;
                break;
            }
        }

        if (exist){
            System.out.println("Yes"); 
        }
        else {
            System.out.println("No");
        }
        
    }
}

