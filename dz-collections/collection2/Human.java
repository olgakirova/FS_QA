import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;


public class Human {
    String name;
    int age;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        String s = this.name;
        s += ":";
        s += this.age;

        return s;
    }


    public static void main(String[] args) {

        Comparator<Human> humanNameComparator = new Comparator<Human>() {
            @Override
            public int compare(Human h1, Human h2) {
                return h1.name.compareTo(h2.name);
            }
        };

        ArrayList<Human> list = new ArrayList<>();
        list.add(new Human("Ann", 45));
        list.add(new Human("Kate", 20));
        list.add(new Human("George", 27));
        list.add(new Human("Lisa", 56));
        list.add(new Human("Max", 5));
        System.out.println(list);
        list.sort(humanNameComparator);
        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);
    }
}

