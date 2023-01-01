package HackerRank.ProblemSolving;

import java.io.*;
import java.util.HashMap;

class Result75 {

    /*
     * Complete the 'steadyGene' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING gene as parameter.
     */

    public static int steadyGene(String gene) {
        // Write your code here
        HashMap<Character, Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < gene.length(); i++) {
            map.put(gene.charAt(i), map.get(gene.charAt(i)) == null ? 1 : map.get(gene.charAt(i)) + 1);
            System.out.println(map.get(gene.charAt(i)));
            if (map.get(gene.charAt(i)) > (gene.length() / 4)) {
                sum++;
            }
        }

        if (sum == 0) return 0;
        int result = gene.length();
        int fast = 0;
        int slow = 0;
        while (fast != gene.length()) {
            if (map.get(gene.charAt(fast)) > (gene.length() / 4)) {
                sum -= 1;
            }
            map.put(gene.charAt(fast), map.get(gene.charAt(fast)) - 1);

            if (sum == 0) {
                result = Math.min(result, fast - slow + 1);
                while (sum == 0) {
                    map.put(gene.charAt(slow), map.get(gene.charAt(slow)) + 1);

                    if (map.get(gene.charAt(slow)) > (gene.length() / 4)) {
                        sum++;
                    }

                    result = Math.min(result, fast - slow + 1);
                    slow++;
                }
            }
            fast++;
        }

        return result;
    }
}

public class BearAndSteadyGene {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String gene = bufferedReader.readLine();

        int result = Result75.steadyGene(gene);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
