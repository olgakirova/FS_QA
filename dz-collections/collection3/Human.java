import java.util.Set;
import java.util.TreeSet;
import java.util.Comparator;

public class Human implements Comparable {

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

    public int compareTo (Object human_name) {
        Human h = (Human) human_name;
        return name.compareTo(h.name);
    }


    public static void main (String[]args){
        Human human1 = new Human("Ann", 45);
        Human human2 = new Human("Kate", 20);
        Human human3 = new Human("George", 27);
        Human human4 = new Human("Lisa", 56);
        Human human5 = new Human("Max", 5);

        Set<Human> set = new TreeSet<>();
        set.add(human1);
        set.add(human2);
        set.add(human3);
        set.add(human4);
        set.add(human5);

        System.out.println(set);
    }

}