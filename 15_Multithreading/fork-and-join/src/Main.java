import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) {
        Parse parse = new Parse("https://lenta.ru");
        try {
            new ForkJoinPool().invoke(new DirTree(parse));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}