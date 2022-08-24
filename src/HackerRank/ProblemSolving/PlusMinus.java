package HackerRank.ProblemSolving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result6 {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
        // Write your code here
        int i;
        double plus = 0;
        double min = 0;
        double zero = 0;

        for (i = 0; i < arr.size(); i++) {
            if (arr.get(i) > 0) {
                plus = plus + 1;
            } else if (arr.get(i) < 0) {
                min = min + 1;
            } else if (arr.get(i) == 0) {
                zero = zero + 1;
            }
        }

        System.out.println(plus / arr.size());
        System.out.println(min / arr.size());
        System.out.println(zero / arr.size());
    }
}

public class PlusMinus {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result6.plusMinus(arr);

        bufferedReader.close();
    }
}
