package HackerRank.ProblemSolving;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

class Result71 {

    /*
     * Complete the 'isValid' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isValid(String s) {
        // Write your code here
        Map<Character, Integer> sMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        int currentCharNum = sMap.get(s.charAt(0));
        int numberOfNo = 0;
        for (char i : sMap.keySet()) {
            if (sMap.get(i) != currentCharNum) {
                numberOfNo++;
                if (numberOfNo > 1) {
                    return "NO";
                }
            }
        }

        return "YES";
    }
}

public class SherlockAndTheValidString {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result71.isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
