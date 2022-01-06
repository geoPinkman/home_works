import java.util.*;

public class CoolNumbers {
    final static int SIZE_OF_NUMBER = 1000;
    final static int SIZE_OF_REGION = 200;

    public static List<String> generateCoolNumbers() {
        List<String> test = new ArrayList<>();
        String result;
        for (int i = 0; i < getMirrorWords().size(); i++) {
            String data = getMirrorWords().get(i);
            String firstLetter = data.substring(0,1);
            String lastsLetters = data.substring(1,3);
            for (int j = 0; j < getMirrorNumbers().size(); j++) {
                String gosNumber = getMirrorNumbers().get(j);
                for (int k = 0; k < getNumbers(SIZE_OF_REGION).size(); k++) {
                    String region = getNumbers(SIZE_OF_REGION).get(k);
                    result = firstLetter.concat(gosNumber).concat(lastsLetters).concat(region);
                    test.add(result);
                }
            }
        }
        return test;
    }

    public static boolean isMirrorChar(String input) {
        final int firstIndex = 0;
        final int lastIndex = 2;
        return input.charAt(firstIndex) == input.charAt(lastIndex);
    }

    public static List<String> getNumbers(int size) {
        List<String> numbers = new ArrayList<>();
        for (int i = 1; i < size; i++) {
            String res = String.valueOf(i);
            while (res.length() < 3) {
                res = "0" + res;
            }
            numbers.add(res);
        }
        return numbers;
    }

    public static List<String> getMirrorNumbers() {
        List<String> massNumbers = new ArrayList<>(getNumbers(SIZE_OF_NUMBER));
        List<String> newMassNumber = new ArrayList<>();
        for (String number : massNumbers) {
            if(isMirrorChar(number)){
                newMassNumber.add(number);
            }
        }
        return newMassNumber;
    }

    public static List<String> getWord() {
        String [] letter = {"А", "В", "Е", "К", "М", "Н", "О", "Р", "С", "Т", "У", "Х"};
        List<String> word = new ArrayList<>();
        String res;
        for (String item : letter) {
            for (String s : letter) {
                for (String value : letter) {
                    res = item.concat(s).concat(value);
                    word.add(res);
                }
            }
        }
        return word;
    }

    public static List<String> getMirrorWords() {
        List<String> words = new ArrayList<>(getWord());
        List<String> mirror = new ArrayList<>();
        for(String word : words) {
            if (isMirrorChar(word)) {
                mirror.add(word);
            }
        }
        return mirror;
    }

    public static List<String> getSortedList() {
        List<String> numbers = new ArrayList<>(generateCoolNumbers());
        Collections.sort(numbers);
        return numbers;
    }


    public static boolean bruteForceSearchInList(List<String> list, String number) {
        List<String> numbers = new ArrayList<>(list);
        return (numbers.contains(number));
    }

    public static boolean binarySearchInList(List<String> sortedList, String number) {
        List<String> numbers = new ArrayList<>(sortedList);
        return Collections.binarySearch(numbers, number) > 0;
    }


    public static boolean searchInHashSet(HashSet<String> hashSet, String number) {
        Set<String> setNumbers = new HashSet<>(hashSet);
        return setNumbers.contains(number);
    }

    public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {
        Set<String> setNumbers = new TreeSet<>(treeSet);
        return setNumbers.contains(number);
    }

}
