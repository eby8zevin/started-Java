package HackerRank.ProblemSolving;

import java.io.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result21 {

    /*
     * Complete the 'sockMerchant' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY ar
     */

    public static int sockMerchant(int n, List<Integer> ar) {
        // Write your code here
        Set<Integer> sockSet = new HashSet<>();
        int pairCount = 0;

        for (Integer sock : ar) {
            if (sockSet.contains(sock)) {
                pairCount++;
                sockSet.remove(sock);
                continue;
            }
            sockSet.add(sock);
        }

        return pairCount;

        /*int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer sock : ar) {
            if(map.containsKey(sock)){
                map.put(sock, map.get(sock) + 1);
            } else {
                map.put(sock, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            result += entry.getValue()/2;
        }
        return result;*/
    }
}

public class SalesByMatch {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result21.sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
