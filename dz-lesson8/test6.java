import java.util.Scanner;

public class test6 {
 

public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter k: ");
        int k = in.nextInt();
        int r = 0;
        boolean exist = false;

        for (int i = 0; r <=k; i ++){
            r += i;
            if (r == k){
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

