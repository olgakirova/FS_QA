


import java.util.Scanner;


public class test2  {


public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter number of players: " );
        int players = in.nextInt();
        System.out.println("Numbers of players " + players);
        if (players < 1 || players >2 ) {
            System.out.println("Good bye!");
            return;
        }

        int secret = (int) (Math.random() * 10);
        //System.out.println("secret: " + secret);
        boolean winner = false;
        int cnt = 0;
        int[] variant = new int[2];

        do {
            cnt ++;
            System.out.println("New try " + cnt);

            for (int i = 0; i < players; i++) {
                System.out.println("Enter  variant for " + (i+1));
                variant[i] = in.nextInt();
                if (secret == variant[i]) {
                    System.out.println("Winner is " + (i+1) + ", secret = " + secret );
                    winner = true;
                    break;
                }
            }
        }
        while (winner == false);
    }

}
