package HackerRank.ProblemSolving;

import java.io.*;
import java.util.Arrays;
import java.util.stream.IntStream;

class Result48 {

    /*
     * Complete the 'biggerIsGreater' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING w as parameter.
     */

    public static String biggerIsGreater(String w) {
        // Write your code here
        int n = w.length();
        char[] c = w.toCharArray();

        StringBuilder sb = new StringBuilder();
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (c[j] > c[i]) {
                    sb.append(w, 0, i);

                    sb.append(c[j]);

                    String temp = w.substring(i, j) + w.substring(j + 1);
                    char[] c2 = temp.toCharArray();
                    Arrays.sort(c2);

                    sb.append(c2);

                    return sb.toString();
                }
            }
        }

        return "no answer";
    }
}

public class BiggerIsGreater {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, T).forEach(TItr -> {
            try {
                String w = bufferedReader.readLine();

                String result = Result48.biggerIsGreater(w);

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
