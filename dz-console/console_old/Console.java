
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.Scanner;


public class Console {
    static Scanner in = new Scanner(System.in);
    static StringProcess sp = new StringProcess();
    static FileProcess fp = new FileProcess();


    public static String get_string() {
        System.out.println("Enter your string:");
        String s = in.nextLine();
        System.out.println("entered: '" + s + "'");
        return s;
    }

    public static String get_path() {
        System.out.println("Enter path:");
        String s = in.nextLine();
        System.out.println("entered: '" + s + "'");
        return s;
    }

    public static void exe_reverse1(){
        String s = get_string();
        String m1 = sp.reverse1(s);
        System.out.println("reverse1: " + m1);
    }

    public static void exe_reverse2(){
        String s = get_string();
        String m2 = sp.reverse2(s);
        System.out.println("reverse2: " + m2);
    }

    public static void exe_del(){
        String s = get_string();
        String m3 = sp.del(s);
        System.out.println("del: '" + m3 + "'");

    }
    public static void exe_upper(){
        String s = get_string();
        String m4 = sp.upper(s);
        System.out.println("upper: '" + m4 + "'");
    }
    public static void exe_substring(){
        String s = get_string();
        System.out.println("Enter begin (int):");
        int begin = in.nextInt();
        System.out.println("Enter end (int):");
        int end = in.nextInt();
        String m5 = sp.substring(s, begin, end);
        System.out.println("substring: '" + m5 + "'");
    }

    public static void exe_mkdir(){

        String s = get_path();
        fp.mkdir(s);
    }

    public static void exe_mkfile() {
        String s = get_path();
        fp.mkfile(s);
    }

    public static void exe_wrstring() {
        String line = get_string();
        String path = get_path();

        fp.wrstring(line, path);
    }



    public static void execute(String cmd) {
        Scanner in = new Scanner(System.in);
        System.out.println("Execute:" + cmd);

        if (cmd.equals("reverse1")) {
            exe_reverse1();
            return;
        }

        if (cmd.equals("reverse2")) {
            exe_reverse2();
            return;
        }

        if  (cmd.equals("del")) {
            exe_del();
            return;
        }
        if  (cmd.equals("upper")) {
            exe_upper();
            return;
        }
        if  (cmd.equals("substring")) {
            exe_substring();
            return;
        }

        if (cmd.equals("mkdir")) {
            exe_mkdir();
            return;
        }

        if (cmd.equals("mkfile")) {
            exe_mkfile();
            return;
        }

        if (cmd.equals("wrstring")) {
            exe_wrstring();
            return;
        }
    }


    public static void main(String[] args) {

        for (int i = 0; i < args.length; ++i) {
            System.out.println( args[i] );
        }

        Scanner in = new Scanner(System.in);
        System.out.println("Please, enter command:");
        String command = in.nextLine();
        System.out.println("'"+ command+ "'");
        Console.execute(command);
    }
}