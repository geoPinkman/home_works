public class TwoDimensionalArray {
    public static char symbol = 'X';
    public static char space = ' ';

    //TODO: Написать метод, который создаст двумерный массив char заданного размера.
    // массив должен содержать символ symbol по диагоналям, пример для size = 3
    // [X,  , X]
    // [ , X,  ]
    // [X,  , X]

    public static char[][] getTwoDimensionalArray(int size) {
        char[][] testArray = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                testArray[i][j] = space;
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    testArray[i][j] = symbol;
                    testArray[i][size - 1 - j] = symbol;
                }
            }
        }
        return testArray;
    }
}
