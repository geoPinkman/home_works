import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Movements {
    final public short COLUMN_COUNT = 8;
    final public short COLUMN_PREFERENCES = 4;
    final public short COLUMN_INCOME = 6;
    final public short COLUMN_EXPENSE = 7;
    private List<ParseData> movement;
    final public String pathMovementCsv;
    public Movements(String pathMovementsCsv) {
        this.movement = new ArrayList<>();
        this.pathMovementCsv = pathMovementsCsv;
    }

    public double getExpenseSum() {
        double result = 0.0;
        List<ParseData> dataList = getParse();
        for (int i = 1; i < dataList.size(); i++) {
            result += Double
                    .parseDouble(dataList
                            .get(i)
                            .getExpense()
                            .replaceAll("\"","").replaceAll(",", "."));
        }
        return result;
    }

    public double getIncomeSum() {
        double result = 0.0;
        List<ParseData> dataList = getParse();
        for (int i = 1; i < dataList.size(); i++) {
            result += Double.parseDouble(dataList.get(i).getIncome());
        }
        return result;
    }

    public List<ParseData> getParse() {
        this.movement = new ArrayList<>();
        try {
            List<String> inList = Files.readAllLines(Paths.get(pathMovementCsv));
            for(String input : inList) {
                String[] test = input.split(",", COLUMN_COUNT);
                movement.add(new ParseData(test[COLUMN_PREFERENCES], test[COLUMN_INCOME], test[COLUMN_EXPENSE]));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return movement;
    }
}
