package HackerRank.ProblemSolving;

import java.io.*;
import java.util.stream.IntStream;

class Result77 {

    /*
     * Complete the 'morganAndString' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING a
     *  2. STRING b
     */

    public static String morganAndString(String A, String B) {
        // Write your code here
        int i = 0, j = 0;
        StringBuffer sb = new StringBuffer();

        while (i < A.length() && j < B.length()) {
            if (A.charAt(i) < B.charAt(j)) {
                sb.append(A.charAt(i++));
            } else if (A.charAt(i) > B.charAt(j)) {
                sb.append(B.charAt(j++));
            } else {
                int x = i, y = j;
                char a = A.charAt(i);
                for (; x < A.length() && y < B.length(); x++, y++) {
                    if (A.charAt(x) != B.charAt(y)) {
                        break;
                    } else if (A.charAt(x) > a) {
                        sb.append(A.substring(i, x)).append(B.substring(j, y));
                        i = x;
                        j = y;
                        a = A.charAt(x);
                    }
                }

                if (x == A.length()) {
                    sb.append(B.charAt(j));
                    j++;
                } else if (y == B.length()) {
                    sb.append(A.charAt(i));
                    i++;
                } else {
                    if (A.charAt(x) < B.charAt(y)) {
                        sb.append(A.charAt(i));
                        i++;
                    } else {
                        sb.append(B.charAt(j));
                        j++;
                    }
                }
            }
        }

        sb.append(A.substring(i)).append(B.substring(j));
        return sb.toString();
    }
}

public class MorganAndAString {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String a = bufferedReader.readLine();

                String b = bufferedReader.readLine();

                String result = Result77.morganAndString(a, b);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
