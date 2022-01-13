import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStream;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Structure moscowMetro = new Structure();

        String json = gson.toJson(moscowMetro.createMetro());
        try{
            FileWriter fw = new FileWriter("result/Metro.JSON");
            fw.write(json);
            fw.flush();
            fw.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}