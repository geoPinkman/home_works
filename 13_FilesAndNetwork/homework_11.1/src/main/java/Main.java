
public class Main {
    public static void main(String[] args) {
//        File testFile = new File("/users/pigeon/Desktop/test.txt");
//        System.out.println(testFile.getParentFile());
//        if (testFile.isDirectory()) {
//            System.out.println(testFile.length());
//        } else {
//            File qq = new File(testFile.getParent());
//            System.out.println(qq.isDirectory());
//            for(File ff : qq.listFiles()) {
//                if (!ff.isDirectory())
//                System.out.println(ff.getName() + " - " + ff.length());
//            }
//        }
        //System.out.println(FileUtils.calculateFolderSize("/users/pigeon/Desktop/test.txt"));
        long start = System.currentTimeMillis();
        System.out.println(FileUtils.calculateFolderSize("/users/pigeon/Desktop/"));
        System.out.println(System.currentTimeMillis() - start + " ms");
        System.out.println("***");
        start = System.currentTimeMillis();
        System.out.println(FileUtils.calcFolderSizeStreamAPI("/users/pigeon/Desktop"));
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}
