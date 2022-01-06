import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static TodoList todoList = new TodoList();


    public static void main(String[] args) throws IOException, InterruptedException {
        // TODO: написать консольное приложение для работы со списком дел todoList
        /*

         */
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String inputString;
        setList();
        do {
            inputString = reader.readLine();
            if (inputString.equals("list")) {
                System.out.println("Your list is: ");
                for (int i = 0; i < todoList.getTodos().size(); i++) {
                    System.out.println((i + 1) + " - " + todoList.getTodos().get(i));
                }
                System.out.println("\t" + "***");
            }
            if (inputString.equals("add")) {
                System.out.println("Input your todo");
                String todo = reader.readLine();
                todoList.add(todo);
                System.out.println("\t" + "***");
            }
            if (inputString.equals("add+")) {
                for (int i = 0; i < todoList.getTodos().size(); i++) {
                    System.out.println((i + 1) + " - " + todoList.getTodos().get(i));
                }
                System.out.println("Input place in your list");
                int tempIndex = Integer.parseInt(reader.readLine());
                int index = tempIndex - 1;
                System.out.println("Add todo in this place");
                String todo = reader.readLine();
                todoList.edit(todo, index);
                System.out.println("\t" + "***");
            }
            if (inputString.equals("edit")) {
                System.out.println("Input your new todo");
                String todo = reader.readLine();
                System.out.println("Input place in list");
                int tempIndex = Integer.parseInt(reader.readLine());
                int index = tempIndex - 1;
                todoList.edit(todo, index);
                System.out.println("\t" + "***");
            }
            if (inputString.equals("delete")) {
                for (int i = 0; i < todoList.getTodos().size(); i++) {
                    System.out.println((i + 1) + " - " + todoList.getTodos().get(i));
                }
                System.out.println("Input place in list");
                int tempIndex = Integer.parseInt(reader.readLine());
                int index = tempIndex - 1;
                todoList.delete(index);
                System.out.println("\t" + "***");
            }
            if (inputString.equals("exit")) {
                System.out.println("bye - bye");
            }
        } while (!inputString.equals("exit"));
    }

    public static void setList() throws InterruptedException {
        System.out.println("Welcome to ToDo list redactor: ");
        Thread.sleep(350);
        System.out.println("\"LIST\"");
        Thread.sleep(250);
        System.out.println("\"ADD\"");
        Thread.sleep(250);
        System.out.println("\"ADD+\"");
        Thread.sleep(250);
        System.out.println("\"EDIT\"");
        Thread.sleep(250);
        System.out.println("\"DELETE\"");
        Thread.sleep(250);
        System.out.println(" or \"EXIT\" to escape.");
    }
}
