package HackerRank.ProblemSolving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result8 {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here
        Collections.sort(arr);

        long maxVal = 0;
        long minVal = 0;
        int j = 1;

        for (int i = 0; i < arr.size() - 1; i++, j++) {
            maxVal += arr.get(j);
            minVal += arr.get(i);
        }
        System.out.println(minVal + " " + maxVal);
    }
}

public class MiniMaxSum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result8.miniMaxSum(arr);

        bufferedReader.close();
    }
}
