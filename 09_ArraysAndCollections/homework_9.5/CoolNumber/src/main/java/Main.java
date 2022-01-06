import java.util.*;

public class Main {
    /*
    TODO:
     - реализовать методы класса CoolNumbers
     - посчитать время поиска введимого номера в консоль в каждой из структуры данных
     - проанализоровать полученные данные
     */

    public static void main(String[] args) {
        String myNumber = "А737УА125";
        long startPoint;
        List<String> ofNumbers = new ArrayList<>(CoolNumbers.generateCoolNumbers());
        startPoint = System.currentTimeMillis();
        System.out.println(CoolNumbers.bruteForceSearchInList(ofNumbers, myNumber));
        System.out.println(System.currentTimeMillis() - startPoint + " ms bruteforce searching");

        ofNumbers = CoolNumbers.getSortedList();
        startPoint = System.currentTimeMillis();
        System.out.println(CoolNumbers.binarySearchInList(ofNumbers, myNumber));
        System.out.println(System.currentTimeMillis() - startPoint + " ms binary searching");

        HashSet<String> setNumbers = new HashSet<>(ofNumbers);
        startPoint = System.currentTimeMillis();
        System.out.println(CoolNumbers.searchInHashSet(setNumbers, myNumber));
        System.out.println(System.currentTimeMillis() - startPoint + " ms hashSet searching");

        TreeSet<String> treeSet = new TreeSet<>(setNumbers);
        startPoint = System.currentTimeMillis();
        System.out.println(CoolNumbers.searchInTreeSet(treeSet, myNumber));
        System.out.println(System.currentTimeMillis() - startPoint + " ms treeSet searching");

    }

}
