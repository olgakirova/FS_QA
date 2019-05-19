import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class List {
    public static void main(String[] args) {
        int element = 100;
        ArrayList<Integer> list1 = new ArrayList<Integer>();


        for (int i = 0; i < element; i++) {
            int a = (int) (Math.random() * element);
            list1.add(a);
        }
        System.out.println(list1);
        Collections.sort(list1);
        System.out.println(list1);
        Collections.reverse(list1);
        System.out.println(list1);
    }
}

