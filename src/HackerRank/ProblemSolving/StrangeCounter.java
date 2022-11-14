package HackerRank.ProblemSolving;

import java.io.*;

class Result51 {

    /*
     * Complete the 'strangeCounter' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts LONG_INTEGER t as parameter.
     */

    public static long strangeCounter(long t) {
        // Write your code here
        long ans = 1, k = 3, total = 3;
        while (total < t) {

            k = k * 2;
            total += k;
        }

        return ans + (total - t);
    }
}

public class StrangeCounter {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        long t = Long.parseLong(bufferedReader.readLine().trim());

        long result = Result51.strangeCounter(t);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
