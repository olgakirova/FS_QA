
public class test1 {

public static void main (String[] args) {
    for (int i = 99; i > 0; i = i-1) {
        String s = "s";
        String p = "s";

        if (i == 1){
            s = "";
        }

        if (i == 2){
            p = "";
        }

        System.out.println("");
        System.out.println(i + " bottle" + s + " of beer on the wall,");
        System.out.println(i + " bottle" + s + " of beer!");
        System.out.println("Take one down, pass it around,");
        System.out.println((i-1) + " bottle" + p + " of beer!");


    }

    System.out.print("\nNo more bottles of beer on the wall,\n" +
            "No more bottles of beer!\n" +
            "Go to the store and buy some more,\n" +
            "99 bottles of beer on the wall.\n");
}
}
