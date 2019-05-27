import java.util.HashMap;

public class EnRu implements Translator {
    HashMap<String, String> map = new HashMap<>();

    public EnRu() {
            map.put("Hello", "Привет");
            map.put("Cool", "Круто");
            map.put("Cat", "Кошка");
        }

    public String execute(String word){
        return map.get(word);
    }

    public String toString() {
        return "EN -> RU";
    }
}
