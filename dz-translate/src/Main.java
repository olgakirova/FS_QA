import java.util.Scanner;


public class Main {


    public static void main (String[] args) {

        Scanner in = new Scanner (System.in);
        Context context = new Context();
        context.setTranslator(new EnRu());

        for (;;) {
            System.out.println ("Enter word for translation:");
            String word = in.next();
            if (word.equals("?rus-eng")) {
                context.setTranslator(new RuEn());
                continue;

            }
            if (word.equals("?eng-rus")) {
                context.setTranslator(new EnRu());
                continue;
            }

            //System.out.println ("Word for translation" + " " + word);
            context.doTran(word);
        }

    }
}
