package HackerRank.ProblemSolving;

import java.io.*;
import java.util.stream.IntStream;

class Result61 {

    /*
     * Complete the 'funnyString' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String funnyString(String s) {
        // Write your code here
        int len = s.length();

        for (int i = 0; i < len - 1; i++) {
            int dif = Math.abs(s.charAt(i) - s.charAt(i + 1));
            int revDif = Math.abs(s.charAt(len - i - 1) - s.charAt(len - i - 2));

            if (dif != revDif) return "Not Funny";
        }

        return "Funny";
    }
}

public class FunnyString {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = Result61.funnyString(s);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
