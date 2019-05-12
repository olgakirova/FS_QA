

import java.util.Scanner;


public class test3  {

public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter matrix size: " );
        int size = in.nextInt();
        int[] [] matrix = new int[size] [size];
        for (int i = 0; i < size; i ++) {
            for (int j = 0; j < size; j ++) {
            
                // random variant:
                //matrix[i][j] = (int) (Math.random() * 100);
                
                matrix[i][j] = (i*10) + j;
                System.out.printf("%02d ", matrix[i][j]);
            }
            System.out.println("");
        }
        System.out.println("New matrix");

        for (int i = 0; i < size; i ++) {
            for (int j = 0; j < size; j ++) {
                if (j > i) {
                    matrix[j][i] = matrix[j][i] + matrix[i][j];
                    matrix[i][j] = matrix[j][i] - matrix[i][j];
                    matrix[j][i] = matrix[j][i] - matrix[i][j];
                }
                System.out.printf("%02d ", matrix[i][j]);

            }
            System.out.println("");
        }
}
}
