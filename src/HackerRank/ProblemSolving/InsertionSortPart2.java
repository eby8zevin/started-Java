package HackerRank.ProblemSolving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result81 {

    /*
     * Complete the 'insertionSort2' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */

    public static void insertionSort2(int n, List<Integer> arr) {
        // Write your code here
        Integer[] numbers = new Integer[n];
        numbers = arr.toArray(numbers);
        for (int i = 1; i < n; i++) {
            int a = numbers[i];
            int j = i - 1;
            while (j >= 0 && numbers[j] > a) {
                numbers[j + 1] = numbers[j];
                j = j - 1;
            }
            numbers[j + 1] = a;
            for (Integer x : numbers) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}

public class InsertionSortPart2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result81.insertionSort2(n, arr);

        bufferedReader.close();
    }
}
