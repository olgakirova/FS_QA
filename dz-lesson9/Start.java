public class Start {

    public static void main (String[] args) {

        CharSequence chars = new MyCharSequence("YesYesYes");
        System.out.println("chars = " + chars);
        System.out.println("chars.charAt(7) = " + chars.charAt(7));
        System.out.println("chars.length() = " + chars.length());
        System.out.println("chars.subSequence(0,5) = " + chars.subSequence(0,5));

    }
}
