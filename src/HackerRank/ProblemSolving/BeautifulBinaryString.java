package HackerRank.ProblemSolving;

import java.io.*;

class Result65 {

    /*
     * Complete the 'beautifulBinaryString' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING b as parameter.
     */

    public static int beautifulBinaryString(String b) {
        // Write your code here
        int ans = 0;
        char[] chars = b.toCharArray();
        for (int i = 0; i < chars.length - 2; i++) {
            if (chars[i] == '0' && chars[i + 1] == '1' && chars[i + 2] == '0') {
                chars[i + 2] = '1';
                ans++;
            }
        }

        return ans;
    }
}

public class BeautifulBinaryString {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String b = bufferedReader.readLine();

        int result = Result65.beautifulBinaryString(b);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
