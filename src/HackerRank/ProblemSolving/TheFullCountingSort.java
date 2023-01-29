package HackerRank.ProblemSolving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

// Java 15
class Result86 {

    /*
     * Complete the 'countSort' function below.
     *
     * The function accepts 2D_STRING_ARRAY arr as parameter.
     */

    public static void countSort(List<List<String>> arr) {
        // Write your code here
        // change the first half of the strings to "-"
        for (int i = 0; i < arr.size() / 2; i++) {
            List<String> tempList = arr.get(i);
            tempList.set(1, "-");
            arr.set(i, tempList);
        }
        // order the list
        arr.sort(Comparator.comparingInt(s -> Integer.parseInt(s.get(0))));
        // make a stringJoiner
        StringJoiner stringJoiner = new StringJoiner(" ");
        for (List<String> element : arr) {
            stringJoiner.add(element.get(1));
        }
        System.out.println(stringJoiner);
    }
}

public class TheFullCountingSort {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<String>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        Result86.countSort(arr);

        bufferedReader.close();
    }
}
