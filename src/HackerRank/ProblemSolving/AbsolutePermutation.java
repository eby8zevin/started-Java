package HackerRank.ProblemSolving;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;

class Result52 {

    /*
     * Complete the 'absolutePermutation' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER k
     */

    public static List<Integer> absolutePermutation(int n, int k) {
        // Write your code here
        final List<Integer> ans = new ArrayList<>(n);
        final List<Integer> no = new ArrayList<>();
        no.add(-1);
        final List<Integer> ok = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            ok.add(i + 1);
        }

        for (int i = 0; i < n; i++) {
            int first = (i + 1 + k);
            int second = (i + 1 - k);

            if (second >= 1 && second <= n && ok.get(second - 1) != -1) {
                ans.add(second);
                ok.set(second - 1, -1);
            } else if (first >= 1 && first <= n && ok.get(first - 1) != -1) {
                ans.add(first);
                ok.set(first - 1, -1);
            } else {
                return no;
            }
        }

        return ans;
    }
}

public class AbsolutePermutation {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int k = Integer.parseInt(firstMultipleInput[1]);

                List<Integer> result = Result52.absolutePermutation(n, k);

                bufferedWriter.write(
                        result.stream()
                                .map(Object::toString)
                                .collect(joining(" "))
                                + "\n"
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
