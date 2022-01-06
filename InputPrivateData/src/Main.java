import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String inputText, tempText;
        int spaceIndex;

        System.out.println("Введите Фамилию Имя Отчество и нажмите Enter");
        inputText = sc.nextLine();
        System.out.println(inputText);
        spaceIndex = inputText.indexOf(' ');
        tempText = inputText.substring(0, spaceIndex);
        System.out.println("Фамилия: " + tempText);
        tempText = inputText.substring(spaceIndex + 1);
        inputText = tempText;
        spaceIndex = inputText.indexOf(' ');
        tempText = inputText.substring(0, spaceIndex);
        System.out.println("Имя: " + tempText);
        tempText = inputText.substring(spaceIndex + 1);
        System.out.println("Отчество: " + tempText);
    }
}

