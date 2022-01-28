package main.java;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Arrays;

public class Main {
    public static final int NEW_WIDTH = 300;

    public static void main(String[] args) {
        String srcFolder = "/users/pigeon/Desktop/src";
        String dstFolder = "/users/pigeon/Desktop/dst";

        File srcDir = new File(srcFolder);

        File[] files = srcDir.listFiles();
        try {
            int middle = files.length / 2;
            File[] files1 = new File[middle];
            File[] files2 = new File[files.length - middle];

            System.arraycopy(files, 0, files1, 0, files1.length);
            System.arraycopy(files, files1.length, files2, 0, files2.length);

            Resizer resizer1 = new Resizer(files1, NEW_WIDTH, dstFolder);
            resizer1.run();
            Resizer resizer2 = new Resizer(files2, NEW_WIDTH, dstFolder);
            resizer2.run();
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }

    }
}
