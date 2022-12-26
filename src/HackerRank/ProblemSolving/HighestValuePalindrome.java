package HackerRank.ProblemSolving;

import java.io.*;
import java.util.HashSet;

class Result72 {

    /*
     * Complete the 'highestValuePalindrome' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER n
     *  3. INTEGER k
     */

    public static String highestValuePalindrome(String str, int n, int k) {
        // Write your code here
        StringBuilder strB = new StringBuilder(str);
        HashSet<Integer> visitedStore = new HashSet<>(n / 2);

        for (int i = 0; i < n / 2; i++) {

            if (str.charAt(i) != str.charAt(n - i - 1)) {
                int max = Math.max(str.charAt(i), str.charAt(n - i - 1));
                strB.setCharAt(i, (char) max);
                strB.setCharAt(n - i - 1, (char) max);
                visitedStore.add(i);
                k = k - 1;

                if (k < 0) {
                    System.out.println("-1");
                    return "-1";
                }
            }
        }

        for (int i = 0; i < n / 2; i++) {
            if (k > 0) {
                if (visitedStore.contains(i)) {

                    if (strB.charAt(i) == '9') {
                        continue;
                    } else {
                        strB.setCharAt(i, '9');
                        strB.setCharAt(n - i - 1, '9');
                        k = k - 1;
                    }

                } else if (k > 1) {
                    if (strB.charAt(i) == '9') {
                        continue;
                    } else {
                        strB.setCharAt(i, '9');
                        strB.setCharAt(n - i - 1, '9');
                        k = k - 2;
                    }
                }
            }

        }

        if (k > 0 && n % 2 == 1) {
            strB.setCharAt(n / 2, '9');
        }

        System.out.println(strB);
        return strB.toString();
    }
}

public class HighestValuePalindrome {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        String s = bufferedReader.readLine();

        String result = Result72.highestValuePalindrome(s, n, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
