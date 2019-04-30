import java.util.Scanner;


public class test4  {


public static void main(String[] args) {



    Scanner in = new Scanner(System.in);
    System.out.println("Enter k: ");
    int k = in.nextInt();
    if (k < 1 || k > 180) {
        System.out.println("k is wrong");
        return;
    }
    String a = "";
    for (int i = 0; i < 99; i ++ ) {
        int number = 10 + (int) (Math.random() * (99 - 10));

        a += number;
    }
    System.out.println("String = " + a);
    System.out.println("k elem = " + a.charAt(k));
    
    }
}

