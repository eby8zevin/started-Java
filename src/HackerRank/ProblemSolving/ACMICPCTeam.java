package HackerRank.ProblemSolving;

import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result41 {

    /*
     * Complete the 'acmTeam' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts STRING_ARRAY topic as parameter.
     */

    public static List<Integer> acmTeam(List<String> topic) {
        // Write your code here
        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();
        int maxCount = 0;
        for (int i = 0; i < topic.size(); i++) {
            for (int j = i + 1; j < topic.size(); j++) {
                int count = 0;
                String s1 = topic.get(i);
                String s2 = topic.get(j);
                for (int k = 0; k < s1.length(); k++) {
                    if (s1.charAt(k) == '1' || s2.charAt(k) == '1')
                        count++;
                }

                if (count >= maxCount) {
                    maxCount = count;
                    list2.add(maxCount);
                }
            }
        }

        int maxFreq = Collections.frequency(list2, maxCount);
        list1.add(maxCount);
        list1.add(maxFreq);

        return list1;
    }
}

public class ACMICPCTeam {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<String> topic = IntStream.range(0, n).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        List<Integer> result = Result41.acmTeam(topic);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
