package HackerRank.ProblemSolving;

import java.io.*;

class Result67 {

    /*
     * Complete the 'gameOfThrones' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String gameOfThrones(String s) {
        // Write your code here
        int[] hash = new int[26];
        for (char ch : s.toCharArray()) hash[ch - 'a']++;

        int odd = 0;
        for (int i = 0; i < 26; i++)
            if (hash[i] % 2 != 0)
                if (odd > 0) return "NO";
                else odd++;
        return "YES";
    }
}

public class GameOfThronesI {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result67.gameOfThrones(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
