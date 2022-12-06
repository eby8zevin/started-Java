package HackerRank.ProblemSolving;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

class Result63 {

    /*
     * Complete the 'gemstones' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING_ARRAY arr as parameter.
     */

    public static int gemstones(List<String> arr) {
        // Write your code here
        int[] hash = new int[26];
        boolean[] visited = new boolean[26];

        for (String s : arr) {
            for (char ch : s.toCharArray())
                if (!visited[ch - 'a']) {
                    hash[ch - 'a']++;
                    visited[ch - 'a'] = true;
                }
            Arrays.fill(visited, false);
        }
        int gems = 0;
        for (int j : hash) if (j == arr.size()) gems++;
        return gems;
    }
}

public class Gemstones {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> arr = IntStream.range(0, n).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        int result = Result63.gemstones(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
