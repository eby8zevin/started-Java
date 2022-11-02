package HackerRank.ProblemSolving;

import java.io.*;

class Result43 {

    /*
     * Complete the 'timeInWords' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER h
     *  2. INTEGER m
     */

    public static String timeInWords(int h, int m) {
        // Write your code here
        String[] arr = {"o' clock", "one", "two", "three", "four", "five", "six",
                "seven", "eight", "nine", "ten", "eleven",
                "twelve", "thirteen", "fourteen", "quarter",
                "sixteen", "seventeen", "eighteen", "nineteen",
                "twenty", "twenty one", "twenty two", "twenty three",
                "twenty four", "twenty five", "twenty six", "twenty seven",
                "twenty eight", "twenty nine", "half"};

        if (m == 0) {
            return arr[h] + " " + arr[0];
        } else if (m == 15) {
            return arr[m] + " past " + arr[h];
        } else if (m == 1) {
            return arr[m] + " minute past " + arr[h];
        } else if (m < 30) {
            return arr[m] + " minutes past " + arr[h];
        } else if (m == 30) {
            return "half past " + arr[h];
        } else if (m == 45) {
            return "quarter to " + arr[h + 1];
        } else {
            return arr[60 - m] + " minutes to " + arr[h + 1];
        }
    }
}

public class TheTimeInWords {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int h = Integer.parseInt(bufferedReader.readLine().trim());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result43.timeInWords(h, m);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
