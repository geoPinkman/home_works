public class Loader {

    public static void main(String[] args) {
        Friend vasya = new Friend("Вася");
        Friend vitya = new Friend("Витя");

        new Thread(() -> vasya.throwBallTo(vitya)).start();
        new Thread(() -> vitya.throwBallTo(vasya)).start();
    }
}