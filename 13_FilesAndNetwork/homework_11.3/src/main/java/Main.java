import java.util.List;

public class Main {
    public static void main(String[] args) {
        Movements test = new Movements("/users/pigeon/Desktop/movementList.csv");
        List<ParseData> testy = test.getParse();
//        for(ParseData qq : testy) {
//            System.out.println(qq.getMoreInfo() + " - " + qq.getIncome() + " - " + qq.getExpense());
//        }

        System.out.println("Income: " + test.getIncomeSum());
        System.out.println("Expense: " + test.getExpenseSum());
//        String test = "0";
//        String test1 = "Приход";
//        System.out.println(test1.matches("[0-9]"));
    }
}
