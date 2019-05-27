public class Context {
    Translator translator;


    public void setTranslator(Translator translator) {
        this.translator = translator;
        System.out.println(translator.toString());
    }

    public void doTran(String word) {
        if (translator == null) {
            return;
        }
        String tr = translator.execute(word);
        if (tr == null) {
            System.out.println("Not found. Switch language.");
            return;
        }

        System.out.println(tr);
    }

}
