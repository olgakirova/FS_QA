import java.lang.CharSequence;
public class MyCharSequence implements CharSequence{

    String b;

    public MyCharSequence (String a) {
        b = a;
    }

    public int length() {
        return b.length();
    }

    public char charAt(int var1) {
        return b.charAt(var1);
    }


    public CharSequence subSequence(int var1, int var2){
        return new MyCharSequence(b.substring(var1, var2));
    }

    public String toString() {
        return b;
    }

}
