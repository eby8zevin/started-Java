package HackerRank.ProblemSolving;

import java.io.*;

class Result66 {

    /*
     * Complete the 'makingAnagrams' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING s1
     *  2. STRING s2
     */

    public static int makingAnagrams(String s1, String s2) {
        // Write your code here
        int matchItem = 0;
        String subStr1 = s1;
        String subStr2 = s2;

        for (int i = 0; i < subStr1.length(); i++) {
            if (subStr2.contains("" + subStr1.charAt(i))) {
                int index = subStr2.indexOf(subStr1.charAt(i));
                subStr2 = subStr2.substring(0, index) + subStr2.substring(index + 1);
                matchItem++;
            }
        }

        int length1 = s1.length() - matchItem;
        int length2 = s2.length() - matchItem;
        return length1 + length2;
    }
}

public class MakingAnagrams {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s1 = bufferedReader.readLine();

        String s2 = bufferedReader.readLine();

        int result = Result66.makingAnagrams(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
