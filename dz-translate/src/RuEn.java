
import java.util.HashMap;

public class RuEn implements Translator {
    HashMap<String, String> map = new HashMap<>();

    public RuEn() {
        map.put("Привет", "Hello");
        map.put("Круто", "Cool");
        map.put("Кошка", "Cat");
    }

    public String execute(String word){
        return map.get(word);
    }

    public String toString() {
        return "RU -> EN";
    }
}
