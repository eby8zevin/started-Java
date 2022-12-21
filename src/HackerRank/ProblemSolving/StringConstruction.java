package HackerRank.ProblemSolving;

import java.io.*;
import java.util.stream.IntStream;

class Result69 {

    /*
     * Complete the 'stringConstruction' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int stringConstruction(String s) {
        // Write your code here
        String p = "";
        for (int i = 0; i < s.length(); i++) {
            if (!p.contains(s.substring(i, i + 1))) {
                p = p.concat(s.substring(i, i + 1));
            }
        }
        return p.length();
    }
}

public class StringConstruction {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = Result69.stringConstruction(s);

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
