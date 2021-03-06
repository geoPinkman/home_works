package main.java;

import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Resizer implements Runnable {

    private File[] files;
    private int newWidth;
    private String dstFolder;
    private long start;

    public Resizer(File[] files, int newWidth, String dstFolder) {
        this.files = files;
        this.newWidth = newWidth;
        this.dstFolder = dstFolder;
        this.start = System.currentTimeMillis();
    }

    @Override
    public void run() {
        try {
            for (File file : files) {
                BufferedImage image = ImageIO.read(file);
                if (image == null) {
                    continue;
                }

                int newHeight = (int) Math.round(image.getHeight() / (image.getWidth() / (double) newWidth));
                BufferedImage newImage = Scalr.resize(image, newWidth, newHeight);
                File newFile = new File(dstFolder + "/" + file.getName());
                ImageIO.write(newImage, "jpg", newFile);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("Thread time : " + (System.currentTimeMillis() - start) + " ms");
    }
}
