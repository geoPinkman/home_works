import java.io.File;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) {
        File testFile = new File("/Users/pigeon/Desktop/fork-and-join/");
        try {
            new ForkJoinPool().invoke(new DirTree(testFile));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}