import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileUtils {
    public static void copyFolder(String sourceDirectory, String destinationDirectory) {
        //sourceDirectory = "/users/pigeon/Desktop/test0/";
        File file = new File(sourceDirectory);
        //destinationDirectory = "/users/pigeon/Desktop/test1/";
        File copyFile = new File(destinationDirectory);
        try {
            FileInputStream is;
            FileOutputStream os;
            for (File test : file.listFiles()) {
                File copy= new File(copyFile.getAbsolutePath() + "/" + test.getName());
                if (test.isFile()) {
                    is = new FileInputStream(test.getAbsolutePath());
                    os = new FileOutputStream(copy.getAbsolutePath());
                    while (is.available() > 0) {
                        int stream = is.read();
                        os.write(stream);
                    }
                    os.flush();
                    os.close();
                }if (test.isDirectory()) {
                   copy.mkdir();
                   copyFolder(test.getAbsolutePath(), copy.getAbsolutePath());
                }
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
