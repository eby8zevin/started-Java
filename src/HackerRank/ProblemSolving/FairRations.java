package HackerRank.ProblemSolving;

import java.io.*;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result38 {

    /*
     * Complete the 'fairRations' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER_ARRAY B as parameter.
     */

    public static String fairRations(List<Integer> B) {
        // Write your code here
        int counter = 0;

        for (int i : B) {
            if (i % 2 == 1) {
                counter++;
            }
        }

        String hold = counter % 2 == 1 ? "NO" : "YES";
        int realCounter = 0;

        if (hold.equals("YES")) {
            for (int i = 0; i < B.size(); i++) {
                if (B.get(i) % 2 == 1) {
                    if (B.get(i + 1) % 2 == 1) {
                        B.set(i, B.get(i) + 1);
                        B.set(i + 1, B.get(i + 1) + 1);
                        i++;
                        realCounter = realCounter + 2;
                    } else {
                        B.set(i, B.get(i) + 1);
                        B.set(i + 1, B.get(i + 1) + 1);
                        realCounter = realCounter + 2;
                    }
                }
            }
        }

        return counter % 2 == 1 ? "NO" : String.valueOf(realCounter);
    }
}

public class FairRations {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int N = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> B = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        String result = Result38.fairRations(B);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
