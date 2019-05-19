import javax.imageio.IIOException;
import java.io.*;

public class FileProcess {


    public  void mkdir (String dir_name) {
        File dir = new File (dir_name);
        if (dir.isDirectory() == true) {
            System.out.println("Folder has existed already");
        }
        boolean created = dir.mkdir();
        if (created) {
            System.out.println("Folder has been created");
        }
    }

    public void wrstring (String line, String filename) {
        try
        {
            FileWriter writer = new FileWriter(filename);
            writer.write(line);
            writer.close();
        } catch (IOException e) {
            System.out.println ("MyException!");
            e.printStackTrace();
        }

    }

    public  void mkfile (String filename)
    {
        try {
            File file = new File(filename);
            if (file.createNewFile()){
                System.out.println ("New file is created!!");
            } else {
                System.out.println ("temp.txt already exists.");
            }

        } catch (IOException e) {
            System.out.println ("MyException!");
            e.printStackTrace();
        }
    }


}
