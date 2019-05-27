import java.io.FileReader;
import java.io.*;


import org.everit.json.schema.SchemaException;
import org.everit.json.schema.ValidationException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import com.sun.xml.internal.fastinfoset.util.StringArray;
import org.everit.json.schema.loader.SchemaLoader;
import org.everit.json.schema.Schema;

import sun.misc.IOUtils;

import java.io.File;
import java.util.List;


public class Main {
    public class Friends {
        int count;
    }

    public class Animal {
        String animal_type;
        String name;
        int age;
        boolean has_tail;
        String[] colors;
        Friends friends;

        public String toString() {
            String ret = "";
            ret = animal_type + " " + name + " " + age + " " + has_tail + " ";

            ret += "(";
            for (int i = 0; i < colors.length; i++) {
                ret = ret + colors[i] + " ";
            }
            ret += ") ";
            ret += friends.count;

            return ret;
        }
    }

    // This function return String
    // that String contains the file
    public static String read_file(String filename) {
        String s = "";
        try {
            FileReader reader = new FileReader(filename);
            //char[] buffer;
            int c;

            while ((c = reader.read()) != -1) {
                s += (char) c;
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return s;
    }


    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }



        String name_schema1 = "/home/user1/schema1.json";
        String name_schema2 = "/home/user1/schema2.json";
        String name_s1 = "/home/user1/serial1.json";
        String name_s2 = "/home/user1/serial2.json";



        // read file
        String schema_str1 = read_file(name_schema1);
        String schema_str2 = read_file(name_schema2);
        String json_str1 = read_file(name_s1);
        String json_str2 = read_file(name_s2);



        JSONObject schema_obj1 = new JSONObject(new JSONTokener( schema_str1 ));
        JSONObject schema_obj2 = new JSONObject(new JSONTokener( schema_str2 ));
        JSONObject json_obj1 = new JSONObject(new JSONTokener( json_str1 ));
        JSONArray json_obj2 = new JSONArray(new JSONTokener( json_str2 ));


        Schema schema1 = null, schema2 = null;

        try {
            schema1 = SchemaLoader.load(schema_obj1);
            System.out.println("load s1 OK");
            schema2 = SchemaLoader.load(schema_obj2);
            System.out.println("load s2 OK");
        } catch (SchemaException e) {
            System.out.println("Cannot load schema! Error:");
            System.out.println(e);
            return;
        }

        try {
            schema1.validate(json_obj1);
            System.out.println("OK 1");

            schema2.validate(json_obj2);
            System.out.println("OK 2");

        } catch (ValidationException e) {
            System.out.println("ERROR ");
            System.out.println(e.toString() );
        }

        Gson gson = new Gson();

        Animal model = gson.fromJson(json_str1, Animal.class);
        List<Animal> list_model = gson.fromJson(json_str2, new TypeToken<List<Animal>>(){}.getType());

        System.out.println(model.toString());
        System.out.println(list_model.toString());


        Gson gson2 = new GsonBuilder().setPrettyPrinting().create();
        String json_model = gson2.toJson(model);

        String json_list_model = gson2.toJson(list_model);

        System.out.println("Json model:");
        System.out.println("---");
        System.out.println(json_model);
        System.out.println("---");


        System.out.println("Json list:");
        System.out.println("---");
        System.out.println(json_list_model);
        System.out.println("---");
    }
}