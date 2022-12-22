package HackerRank.ProblemSolving;

import java.io.*;
import java.util.stream.IntStream;

class Result70 {

    /*
     * Complete the 'anagram' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int anagram(String s) {
        // Write your code here
        int c = 0;
        if (s.length() % 2 != 0) return -1;

        String s1 = "", s2 = "";
        for (int i = 0; i < s.length() / 2; i++) s1 += s.charAt(i);
        for (int i = s.length() / 2; i < s.length(); i++) s2 += s.charAt(i);

        int a[] = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            a[s1.charAt(i) - 'a']++;
            a[s2.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (a[i] > 0)
                c += a[i];
        }

        return c;
    }
}

public class Anagram {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = Result70.anagram(s);

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
