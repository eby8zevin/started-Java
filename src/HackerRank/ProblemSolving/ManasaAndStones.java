package HackerRank.ProblemSolving;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;

class Result40 {

    /*
     * Complete the 'stones' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER a
     *  3. INTEGER b
     */

    public static List<Integer> stones(int n, int a, int b) {
        // Write your code here
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++)
            set.add(a * (n - 1 - i) + b * i);
        return new ArrayList<>(set);
    }
}

public class ManasaAndStones {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, T).forEach(TItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                int a = Integer.parseInt(bufferedReader.readLine().trim());

                int b = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> result = Result40.stones(n, a, b);

                bufferedWriter.write(
                        result.stream()
                                .map(Object::toString)
                                .collect(joining(" "))
                                + "\n"
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
