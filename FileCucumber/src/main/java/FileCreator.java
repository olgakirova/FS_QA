import java.io.File;
import java.io.IOException;

public class FileCreator {

    public String filename;

    public void create() {
        File f = new File(filename);

        try {
            f.createNewFile();
        } catch(IOException e) {
            // file not created
        }
    }


    public boolean isExists(String fn) {
        File f = new File(fn);
        boolean a =  f.exists();
        return a;
    }
}



