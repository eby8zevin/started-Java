package HackerRank.ProblemSolving;

import java.io.*;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result39 {

    /*
     * Complete the 'cavityMap' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY grid as parameter.
     */

    public static List<String> cavityMap(List<String> grid) {
        // Write your code here
        for (int i = 1; i < grid.size() - 1; i++) {
            int len = grid.get(i).length() - 1;
            for (int j = 1; j < len; j++) {
                int cellUp = grid.get(i - 1).charAt(j) - 48;
                int cellDown = grid.get(i + 1).charAt(j) - 48;
                int cellLeft = grid.get(i).charAt(j - 1) - 48;
                int cellRight = grid.get(i).charAt(j + 1) - 48;
                int cell = grid.get(i).charAt(j) - 48;

                if (cell > cellUp && cell > cellDown && cell > cellLeft && cell > cellRight) {
                    char[] ch = grid.get(i).toCharArray();
                    ch[j] = 'X';
                    grid.remove(i);
                    grid.add(i, String.valueOf(ch));
                }
            }
        }

        return grid;
    }
}

public class CavityMap {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> grid = IntStream.range(0, n).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        List<String> result = Result39.cavityMap(grid);

        bufferedWriter.write(
                result.stream()
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
