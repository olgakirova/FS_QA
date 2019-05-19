import java.util.Scanner;

public class StringProcess {


    public String reverse1 (String a){
        String s = "";

        for (int i = a.length()-1; i >=  0 ; i --) {
            char q = a.charAt(i);
            s += q;
        }

        return  s;
    }
    public String reverse2 (String a) {

        StringBuilder s = new StringBuilder(a);
        s.reverse();
        String k = s.toString();
        return k;

    }

    public String del(String a){
        int cntleft = 0;
        int cntright = 0;
        for (int i = 0; i <= a.length()-1; i ++) {
            char q = a.charAt(i);

            if (q == ' ') {
                cntleft += 1;
            } else {
                break;
            }
        }


        for (int i = a.length()-1; i >= 0; i--) {
            char q = a.charAt(i);

            if (q == ' ') {
                cntright += 1;
            } else {
                break;
            }
        }

        String s = a.substring(cntleft, a.length()-cntright);

        return  s;



    }

    public String upper(String a) {
        String s = a.toUpperCase();
        return s;
    }


    public String substring (String a, int begin, int end) {
        if (begin >= end) {
            return "";
        }
        if (end >= a.length()) {
            end = a.length()-1;
        }
        String s = a.substring(begin, end);
        return s;
    }









}
