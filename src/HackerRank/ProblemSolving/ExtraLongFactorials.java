package HackerRank.ProblemSolving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

class Result31 {

    /*
     * Complete the 'extraLongFactorials' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void extraLongFactorials(int n) {
        // Write your code here
        BigInteger bigInt = BigInteger.ONE;
        while (n > 1) {
            bigInt = bigInt.multiply(BigInteger.valueOf(n));
            n--;
        }

        System.out.println(bigInt);
    }

}

public class ExtraLongFactorials {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        Result31.extraLongFactorials(n);

        bufferedReader.close();
    }
}
