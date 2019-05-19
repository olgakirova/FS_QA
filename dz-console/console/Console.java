
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

    public static void exe_reverse1(String[] arguments){
        String s = arguments[1];
        String m1 = sp.reverse1(s);
        System.out.println("reverse1: " + m1);
    }

    public static void exe_reverse2(String[] arguments){
        String s = arguments[1];
        String m2 = sp.reverse2(s);
        System.out.println("reverse2: " + m2);
    }

    public static void exe_del(String[] arguments){
        String s = arguments[1];
        String m3 = sp.del(s);
        System.out.println("del: '" + m3 + "'");

    }
    public static void exe_upper(String[] arguments){
        String s = arguments[1];
        String m4 = sp.upper(s);
        System.out.println("upper: '" + m4 + "'");
    }
    public static void exe_substring(String[] arguments){
        String s = arguments[1];
        int begin = Integer.parseInt( arguments[2] );
        int end = Integer.parseInt( arguments[3] );
        String m5 = sp.substring(s, begin, end);
        System.out.println("substring: '" + m5 + "'");
    }

    public static void exe_mkdir(String[] arguments){
        fp.mkdir(arguments[1]);
    }

    public static void exe_rmdir(String[] arguments){
        fp.rmdir(arguments[1]);
    }

    public static void exe_mkfile(String[] arguments) {

        fp.mkfile(arguments[1]);
    }

    public static void exe_wrstring(String[] arguments) {

        fp.wrstring(arguments[2], arguments[1]);
    }



    public static void execute(String[] arguments) {
        System.out.println("Execute:" + arguments[0]);

        String cmd = arguments[0];

        if (cmd.equals("reverse1")) {
            exe_reverse1(arguments);
            return;
        }

        if (cmd.equals("reverse2")) {
            exe_reverse2(arguments);
            return;
        }

        if  (cmd.equals("del")) {
            exe_del(arguments);
            return;
        }
        if  (cmd.equals("upper")) {
            exe_upper(arguments);
            return;
        }
        if  (cmd.equals("substring")) {
            exe_substring(arguments);
            return;
        }

        if (cmd.equals("mkdir")) {
            exe_mkdir(arguments);
            return;
        }

        if (cmd.equals("rmdir")) {
            exe_rmdir(arguments);
            return;
        }

        if (cmd.equals("mkfile")) {
            exe_mkfile(arguments);
            return;
        }

        if (cmd.equals("wrstring")) {
            exe_wrstring(arguments);
            return;
        }
    }

    public static void help() {
        String help = "reverse1 string\n" +
                "reverse2 string\n" +
                "del string\n" +
                "upper string\n" +
                "substring string begin end\n" +
                "mkdir path\n" +
                "rmdir path\n" +
                "mkfile filename\n" +
                "wrstring filename string\n";
        System.out.println( help );
    }

    public static void main(String[] args) {
        /*
        for (int i = 0; i < args.length; i++) {
            System.out.println( args[i] );
        }
         */

        if (args.length == 0) {
            help();
            return;
        }

        System.out.println("'" + args[0] + "'");
        Console.execute( args );
    }
}