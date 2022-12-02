package HackerRank.ProblemSolving;

import java.io.*;

class Result60 {

    /*
     * Complete the 'pangrams' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String pangrams(String s) {
        // Write your code here
        int c = 26;
        int dp[] = new int[27];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            ch = Character.toLowerCase(ch);

            int idx = ch - 'a';
            if (idx < 0 || idx >= 26) continue;
            dp[idx]++;
            if (dp[idx] > 1) continue;
            c--;
            if (c == -0) return "pangram";
        }

        return "not pangram";
    }
}

public class Pangrams {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result60.pangrams(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
