package HackerRank.ProblemSolving;

import java.io.*;

class Result10 {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
        // Write your code here
        String substring = s.substring(2, s.length() - 2);
        if (s.contains("PM")) {
            int i = Integer.parseInt(s.substring(0, 2));
            if (i < 12) {
                return i + 12 + substring;
            }
        }

        if (s.contains("AM")) {
            int i = Integer.parseInt(s.substring(0, 2));
            if (i == 12) {
                return "00" + substring;
            }
        }

        return s.substring(0, s.length() - 2);
    }
}

public class TimeConversion {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result10.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
