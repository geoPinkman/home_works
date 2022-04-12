import java.util.*;

public class Main {
    public static List<String> stringList = new ArrayList<>();
    public static int COUNT = 12;
    public static List<Long> y = new ArrayList<>();
    public static long ySum;
    public static double yAvg;
    public static List<Long> x1 = new ArrayList<>();
    public static long x1Sum;
    public static double x1Avg;
    public static List<Long> x2 = new ArrayList<>();
    public static long x2Sum;
    public static double x2Avg;
    public static List<Long> x1x2 = new ArrayList<>();
    public static long x1x2Sum;
    public static double x1x2Avg;
    public static List<Long> yx1 = new ArrayList<>();
    public static long yx1Sum;
    public static double yx1Avg;
    public static List<Long> yx2 = new ArrayList<>();
    public static long yx2Sum;
    public static double yx2Avg;
    public static List<Long> yy = new ArrayList<>();
    public static long yySum;
    public static double yyAvg;
    public static List<Long> x1x1 = new ArrayList<>();
    public static long x1x1Sum;
    public static double x1x1Avg;
    public static List<Long> x2x2 = new ArrayList<>();
    public static long x2x2Sum;
    public static double x2x2Avg;
    public static void main(String[] args) {

        stringList.add("сом");
        stringList.add("каракатица");
        stringList.add("бежим!");
        stringList.add("давай!");


        for(Map.Entry<String, List<Long>> test : getTimes(stringList).entrySet()) {
            int size = test.getValue().size();
            long result = 0;
            for (long sum : test.getValue()){
                result +=sum;
            }
            double avgTime = (double) result / size;
            System.out.println(test.getKey() + "\t" + avgTime + " ms");
        }
        ySum = getSum(y);
        yAvg = getAvg(ySum);

        x1Sum = getSum(x1);
        x1Avg = getAvg(x1Sum);

        x2Sum = getSum(x2);
        x2Avg = getAvg(x2Sum);

        x1x2Sum = getSum(x1x2);
        x1x2Avg = getAvg(x1x2Sum);

        yx1Sum = getSum(yx1);
        yx1Avg = getAvg(yx1Sum);

        yx2Sum = getSum(yx2);
        yx2Avg = getAvg(yx2Sum);

        yySum = getSum(yy);
        yyAvg = getAvg(yySum);

        x1x1Sum = getSum(x1x1);
        x1x1Avg = getAvg(x1x1Sum);

        x2x2Sum = getSum(x2x2);
        x2x2Avg = getAvg(x2x2Sum);

        double qy = getAvgDev(yyAvg, yAvg);
        double qx1 = getAvgDev(x1x1Avg, x1Avg);
        double qx2 = getAvgDev(x2x2Avg, x2Avg);

        double ryx1 = getPairCorrelationCoefficient(yx1Avg, yAvg, x1Avg, qy, qx1);
        double ryx2 = getPairCorrelationCoefficient(yx2Avg, yAvg, x2Avg, qy, qx2);
        double rx1x2 = getPairCorrelationCoefficient(x1x1Avg, x1Avg, x2Avg, qx1, qx2);

        double b1result = getResult(ryx1, ryx2, rx1x2);
        double b2result = getResult(ryx2, ryx1, rx1x2);

        System.out.println("Coefficient B1 = " + b1result + " Coefficient B2 = " + b2result);
    }

    public static Map<String, List<Long>> getTimes(List<String> words) {
        Scanner scanner = new Scanner(System.in);
        char inputData;
        long startTime;

        Map<String, List<Long>> map = new HashMap<>();
        for (int i = 0; i < COUNT; i++) {
            List<Long> times  = new ArrayList<>();
            String word = words.get(getIndex());
            char firstCharOfWord = word.charAt(0);
            System.out.println(word);
            startTime = System.currentTimeMillis();
            do {
                inputData = scanner.next().charAt(0);
            } while (inputData != firstCharOfWord);
            long finishTime = System.currentTimeMillis() - startTime;
            y.add(finishTime);
            x1.add((long) i);
            x2.add((long) word.length());
            x1x2.add(x1.get(i) * x2.get(i));
            yx1.add(y.get(i) * x1.get(i));
            yx2.add(y.get(i) * x2.get(i));
            yy.add(y.get(i) * y.get(i));
            x1x1.add(x1.get(i) * x1.get(i));
            x2x2.add(x2.get(i) * x2.get(i));
            if (map.containsKey(word)) {
                map.get(word).add(finishTime);
            } else {
                times.add(finishTime);
                map.put(word, times);
            }
        }
        return map;
    }

    public static int getIndex() {
        int index;
        index = (int) (Math.random() * stringList.size());
        return index;
    }

    public static long getSum(List<Long> list) {
        return list.stream().reduce(Long::sum).get();
    }

    public static long getAvg(Long methResult) {
        return methResult / COUNT;
    }

    public static double getAvgDev(double sqrSums, double sqrAvgSqr) {
        return Math.pow(sqrSums - Math.pow(sqrAvgSqr, 2), 0.5);
    }

    public static double getPairCorrelationCoefficient(double avgSum, double avgY, double avgX, double avgDev1, double avgDev2) {
        return (avgSum - avgY * avgX) / (avgDev1 * avgDev2);
    }

    public static double getResult(double ryx1, double ryx2, double rx1x2) {
        return (ryx1 - ryx2 * rx1x2) / (1 - Math.pow(rx1x2, 2));
    }
}

