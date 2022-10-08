package HackerRank.ProblemSolving;

import java.io.*;
import java.util.stream.IntStream;

class Result30 {

    /*
     * Complete the 'findDigits' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER n as parameter.
     */

    public static int findDigits(int n) {
        // Write your code here
        int counter = 0;
        String strInt = Integer.toString(n);

        for (int i = 0; i < strInt.length(); i++) {
            int digit = (strInt.charAt(i) - 48);
            if (digit != 0 && n % digit == 0) counter++;
        }

        return counter;
    }
}

public class FindDigits {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                int result = Result30.findDigits(n);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
