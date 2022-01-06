import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    
    /* TODO:
        Пример вывода списка Email, после ввода команды LIST в консоль:
        test@test.com
        hello@mail.ru
        - каждый адрес с новой строки
        - список должен быть отсортирован по алфавиту
        - email в разных регистрах считается одинаковыми
           hello@skillbox.ru == HeLLO@SKILLbox.RU
        - вывод на печать должен быть в нижнем регистре
           hello@skillbox.ru
        Пример вывода сообщения об ошибке при неверном формате Email:
        "Неверный формат email"
    */

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        EmailList list = new EmailList();
        String input;
        do {
            input = reader.readLine();
            String reg = "add\\s";
            if (input.contains("add ")) {
                list.add(input.replaceFirst(reg, ""));
            }

            if (input.equals("list")) {
                for(String listed : list.getSortedEmails()) {
                    System.out.println(listed);
                }
            }
        } while (!input.equals("exit"));

            //TODO: write code here
    }
}
