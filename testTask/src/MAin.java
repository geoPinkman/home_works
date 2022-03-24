import java.util.*;

public class MAin {

    public static String[] getWordAsArray(String word) {
       return word.split(" ");
    }

    public static int equal(String word1, String word2) {
        String[] arr1 = getWordAsArray(word1);
        String[] arr2 = getWordAsArray(word2);
        int result;
        int count = 0;
        for (String nString : arr1) {
            for (String mString : arr2) {
                if (nString.equals(mString)) {
                    count++;
                    break;
                }
                if (count != 0) {
                    break;
                }
            }
        }
        if (count != 0) {
            result = 1;
        } else {
            result = 0;
        }
        return result;
    }

    public static void equalWords(List<String> listN, List<String> listM) {
        int res = 0;
        for (String stringN : listN) {
            for (String stringM : listM) {
                res = equal(stringN, stringM);
                res += res;
                if (res != 0) {
                    System.out.println(stringN + ":" + stringM);
                    break;
                }
            }
            if (res == 0) {
                System.out.println(stringN + ":?");
            }
        }

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<String> nList = new ArrayList<>();
        List<String> mList = new ArrayList<>();

//        nList.add("шуруп");
//        nList.add("гвоздь");
//        nList.add("корыто для воды");
//        nList.add("синяя краска");
//
//        mList.add("шуруп 3х1.5");
//        mList.add("синяя");
//        mList.add("ведро для воды");

        for (int i = 0; i <= 1; i++) {
            System.out.println("count of lines: ");
            int count = scanner.nextInt();
            System.out.println("insert not null lines, pls");
            while (count >= 0) {
                count--;
                String line = scanner.nextLine();
                if (i == 0) {
                    nList.add(line.trim());
                }
                else {
                    mList.add(line.trim());
                }
            }
        }
        equalWords(nList, mList);
    }
}
