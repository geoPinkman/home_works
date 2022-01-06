import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

public class FileUtils {

    public static long calculateFolderSize(String path) {
        File getFile = new File(path);
        File getDir;
        if (getFile.isDirectory()) {
            getDir = getFile;
        } else {
            getDir = new File(getFile.getParent());
        }
        long testResult = 0;
        for(File rollFilesInThisDir : getDir.listFiles()) {
            if (!rollFilesInThisDir.isDirectory()) {
                //System.out.println(rollFilesInThisDir.getName() + " - " + rollFilesInThisDir.length() + " Bytes");
                testResult += rollFilesInThisDir.length();
            } else {
                testResult += calculateFolderSize(rollFilesInThisDir.getPath());
            }
        }
        return testResult;
    }

    public static long calcFolderSizeStreamAPI(String path) {
        long result = 0;
        try {
            result = Files.walk(Paths.get(path))
                    .filter(Files::isRegularFile)
                    .mapToLong(value -> value.toFile().length())
                    .sum();
        } catch (Exception e) {
            e.getStackTrace();
        }
        return result;
    }
}
