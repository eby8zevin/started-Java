package HackerRank.ProblemSolving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result56 {

    /*
     * Complete the 'almostSorted' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void almostSorted(List<Integer> arr) {
        // Write your code here
        List<Integer> sorted = arr.stream().sorted().collect(Collectors.toList());
        int first = -1, last = -1;
        int diff = 0;

        for (int i = 0; i < sorted.size(); i++)
            if (sorted.get(i) != arr.get(i)) {
                if (first == -1) first = i;
                else last = i;
                diff++;
            }

        if (diff == 0) System.out.println("yes");
        else if (diff == 2) System.out.println("yes\nswap " + (first + 1) + " " + (last + 1));
        else {
            for (int i = first; i < last; i++) {
                if (arr.get(i) < arr.get(i + 1)) {
                    System.out.println("no");
                    return;
                }
            }

            System.out.println("yes\nreverse " + (first + 1) + " " + (last + 1));
        }
    }
}

public class AlmostSorted {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result56.almostSorted(arr);

        bufferedReader.close();
    }
}
