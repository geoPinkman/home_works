import java.util.Scanner;

public class Loader {
    public static void main(String[] args) {

        // CONSTANTS

        final char WHITE_SPACE = 32;
        final char ZERO_NUMBER = 48;
        final char NINE_NUMBER = 57;

        // 1st task of 4.4 module

        String alphabet = " abcdefghijklmnopqrstuvwxyz ABCDEFGHIJKLMNOPQRSTUVWXYZ " +
                "абвгдеёжзийклмнопрстуфхцчшщъыьэюя АБВГДЕЁЖЗИКЛМНОПРСТУФЧЦЧШЩЪЫЬЭЮЯ " +
                "0123456789";
        for (int i = 0; i < alphabet.length(); i++) {
            char ch = alphabet.charAt(i);
            if (ch == WHITE_SPACE){
                System.out.println("");
            }
            int index = (int) ch;
            System.out.print(Character.toString(ch) + ": " + index + "; ");
        }
        System.out.println("");

        // 2nd task of 4.4 module

        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
        System.out.println(text);

        int salary, startIndex, endIndex, sumSalary = 0;

        String tempText, number;


        for (int i = 0; i < text.length(); ) {
            char ch = text.charAt(i);
            if (!(ZERO_NUMBER <= ch && ch <= NINE_NUMBER)){
                i++;
            }
            else {
                startIndex = i;
                tempText = text.substring(startIndex);
                endIndex = tempText.indexOf(' ');
                number = tempText.substring(0, endIndex);
                salary = Integer.parseInt(number);
                System.out.println(salary);
                sumSalary += salary;
                i = i + number.length();
            }
        }
        System.out.println("Total salary: " + sumSalary);

    }
}






