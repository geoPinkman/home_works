package main.java;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static final int NEW_WIDTH = 400;

    public static void main(String[] args) {
        String srcFolder = "/users/pigeon/Desktop/src";
        String dstFolder = "/users/pigeon/Desktop/dst";

        File srcDir = new File(srcFolder);
        File[] files = srcDir.listFiles();

        List<File[]> test = filesList(3, files);
        for (File[] qq : test) {
            try {
                new Resizer(qq, NEW_WIDTH, dstFolder).run();
                System.out.println(qq.length);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static List<File[]> filesList (int coresCount, File[] files) {
        coresCount = Math.abs(coresCount);
        if (coresCount == 0) {
            coresCount = 1;
        }
        if (coresCount > files.length) {
            coresCount = files.length;
        }
        List<File[]> result = new ArrayList<>();
        int bandPoint = files.length / coresCount;
        int firstBlock = files.length % coresCount;
        File[] partOfList;
        for (int i = 0; i < coresCount; i++) {
            partOfList = new File[bandPoint + firstBlock];
            firstBlock = 0;
            int startPoint;
            if (i == 0) {
                startPoint = 0;
            } else {
                startPoint = files.length - partOfList.length * (coresCount - i);
            }
            System.arraycopy(files, startPoint, partOfList, 0, partOfList.length);
            result.add(partOfList);
        }
        return result;
    }
}
