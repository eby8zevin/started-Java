package HackerRank.ProblemSolving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Result44 {

    /*
     * Complete the 'kaprekarNumbers' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER p
     *  2. INTEGER q
     */

    public static void kaprekarNumbers(int p, int q) {
        // Write your code here
        List<Integer> list = new ArrayList<>();
        for (int i = p; i <= q; i++) {
            if (isKaprekar(i)) {
                list.add(i);
            }
        }

        if (list.isEmpty()) {
            System.out.println("INVALID RANGE");
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                System.out.print(list.get(i));
                continue;
            }
            System.out.print(list.get(i) + " ");
        }
    }

    public static boolean isKaprekar(int i) {
        long sqrt = (long) i * i;

        if (i == 1) {
            return true;
        }

        String str = String.valueOf(sqrt);
        if (str.length() > 1) {
            String s1 = str.substring(0, str.length() / 2);
            String s2 = str.substring(str.length() / 2);

            return Integer.parseInt(s1) + Integer.parseInt(s2) == i;
        }

        return false;
    }
}

public class ModifiedKaprekarNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int p = Integer.parseInt(bufferedReader.readLine().trim());

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        Result44.kaprekarNumbers(p, q);

        bufferedReader.close();
    }
}
