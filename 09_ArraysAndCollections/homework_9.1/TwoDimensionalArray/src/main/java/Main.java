public class Main {
    public static void main(String[] args) {
        char[][] array = TwoDimensionalArray.getTwoDimensionalArray(8);
        for(char[] gg : array) {
            for(char qq : gg) {
                System.out.print(qq);
            }
            System.out.println();
        }
    }
}
