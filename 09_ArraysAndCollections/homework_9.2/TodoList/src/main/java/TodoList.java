import java.util.ArrayList;

public class TodoList {

    private ArrayList<String> list;

    public TodoList() {
        this.list = new ArrayList<>();
    }

    public void add(String todo) {
        list.add(todo);
    }

    public void add(int index, String todo) {
        try {
            list.add(index, todo);
        } catch (Exception err) {
            System.out.println("Please, input correct number");
        }

    }

    public void edit(String todo, int index) {
        // TODO: заменить дело на index переданным todo индекс,
        //  проверьте возможность изменения

            try {
                list.add(index, todo);
            } catch (Exception err) {
                System.out.println("Please, input correct number");
            }

    }

    public void delete(int index) {
        // TODO: удалить дело находящееся по переданному индексу,
        //  проверьте возможность удаления дела

            try {
                list.remove(index);
            } catch (Exception err) {
                System.out.println("Please, input correct number");
            }

    }

    public ArrayList<String> getTodos() {
        // TODO: вернуть список дел
        return list;
    }


}