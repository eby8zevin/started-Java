package HackerRank.ProblemSolving;

import java.io.*;
import java.util.Arrays;
import java.util.stream.IntStream;

class Result73 {

    /*
     * Complete the 'sherlockAndAnagrams' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int sherlockAndAnagrams(String s) {
        // Write your code here
        int length = s.length(); //Length of string
        int count = 0; // Anagrams count
        for (int i = 0; i < length; i++) { // At each index find all possible substring
            for (int subLength = 1; subLength < length; subLength++) { // For 1 to n-1 length of string
                String itrString = null;
                for (int k = i; k <= length - subLength; k++) { // Compare string of subLength
                    String subString = s.substring(k, k + subLength);
                    char[] chars = subString.toCharArray();
                    Arrays.sort(chars);
                    subString = new String(chars);
                    if (k == i) { //If i ==k i.e. This is the string to compare
                        itrString = subString;
                    } else { // Compare is this string is Anagrams
                        if (itrString.equals(subString)) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}

public class SherlockAndAnagrams {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = Result73.sherlockAndAnagrams(s);

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
