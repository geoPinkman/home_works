import java.util.ArrayList;
import java.util.List;

public class Main {
    private final static Integer INPUTS[][] = {{-6, -3, -2, -1, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20},
            {-6, -3, -2, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20},
            {-4, -3, -2, -1, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20},
            {-6, -5, -4, -3, -2, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20, 100, 101, 102, 103, 105},
            {1, 3, 4, 6, 7, 9, 20, 21}
    };

    private final static String[] RESULTS = {"-6,-3-1,3-5,7-11,14,15,17-20",
            "-6,-3,-2,0,1,3-5,7-11,14,15,17-20",
            "-4-1,3-5,7-11,14,15,17-20",
            "-6--2,0,1,3-5,7-11,14,15,17-20,100-103,105",
            "1,3,4,6,7,9,20,21"
    };

    public static void main(String[] args) {

//        for(int i = 0; i < INPUTS.length; i++){
//            var result = convertToIntervals(INPUTS[i]);
//            var expectedResult = RESULTS[i];
//            boolean correct = result.equalsIgnoreCase(expectedResult);
//            System.out.println("The result is " + (correct ? "correct. " : "incorrect. ") + "Result:" + result + " ExpectedResult:" + expectedResult);
//        }
        Integer[] test = {100, 101, 102, 103, 105};
        System.out.println("100, 101, 102, 103, 105");
        listOfArraysLength(test).forEach(integer -> System.out.print(integer + " "));
        System.out.println();
        for(Integer[] qq : getListOfArrays(test)) {
            for(int aa : qq) {
                System.out.print(aa + " ");
            }
        }
        System.out.println();
        System.out.print(convertToIntervals(test));
    }

    private static String convertToIntervals(Integer[] input) {
        String result = "";
        String temp = "";
        for(Integer[] resultSubString : getListOfArrays(input)) {
            if(resultSubString.length == 1) {
               temp = String.valueOf(resultSubString[0]);
            } else
            if (resultSubString.length == 2) {
                temp = resultSubString[0] + "," + resultSubString[1];
            }
            if (resultSubString.length > 2) {
                temp = resultSubString[0] + "-" + resultSubString[resultSubString.length - 1];
            }
            result += temp + ",";
        }

        return result.substring(0, result.length() - 1);
    }

    private static List<Integer> listOfArraysLength(Integer[] input) {
        List<Integer> test = new ArrayList<>();
        try {
            for (int i = 1; i <= input.length; i++) {
                int count = 1;
                if (i == input.length) {
                    count = 1;
                } else if (input[i] - input[i - 1] != 1) {
                    count = 1;
                } else {
                    while (input[i] - input[i - 1] == 1) {
                        count++;
                        i++;
                        if (i == input.length) {
                            break;
                        }
                    }
                }
                test.add(count);
            }
        }catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return test;
    }

    public static List<Integer[]> getListOfArrays(Integer[] input) {
        List<Integer[]> gg = new ArrayList<>();
        int startPoint = 0;
        for(int length : listOfArraysLength(input)) {
            Integer[] test = new Integer[length];
            System.arraycopy(input, startPoint, test, 0, length);
            gg.add(test);
            startPoint += length;
        }
        return gg;
    }


}
