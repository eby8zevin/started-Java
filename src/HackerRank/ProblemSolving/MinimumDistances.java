package HackerRank.ProblemSolving;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result47 {

    /*
     * Complete the 'minimumDistances' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int minimumDistances(List<Integer> a) {
        // Write your code here
        int minDistance = Integer.MAX_VALUE;
        int currentDistance;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.size(); i++) {
            if (map.containsKey(a.get(i))) {
                currentDistance = Math.abs(i - map.get(a.get(i)));
                if (currentDistance < minDistance) {
                    minDistance = currentDistance;
                }
            } else {
                map.put(a.get(i), i);
            }
        }

        if (minDistance == Integer.MAX_VALUE) return -1;
        else return minDistance;
    }
}

public class MinimumDistances {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result47.minimumDistances(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
