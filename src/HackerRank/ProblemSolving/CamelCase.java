package HackerRank.ProblemSolving;

import java.io.*;

class Result59 {

    /*
     * Complete the 'camelcase' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int camelcase(String s) {
        // Write your code here
        String uc = s.toUpperCase();
        int l = s.length();
        int ans = 1;

        for (int i = 0; i < l; i++) {
            if (uc.charAt(i) == s.charAt(i)) ans++;
        }

        return ans;
    }
}

public class CamelCase {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        int result = Result59.camelcase(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
