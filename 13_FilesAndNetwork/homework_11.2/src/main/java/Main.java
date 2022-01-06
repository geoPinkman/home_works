public class Main {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        FileUtils.copyFolder("/users/pigeon/Desktop/test0/", "/users/pigeon/Desktop/test1/");
        System.out.println(System.currentTimeMillis() - start);
    }
}
