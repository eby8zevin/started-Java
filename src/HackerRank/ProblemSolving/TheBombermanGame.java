package HackerRank.ProblemSolving;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result53 {

    /*
     * Complete the 'bomberMan' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. STRING_ARRAY grid
     */

    public static List<String> bomberMan(int n, List<String> grid) {
        // Write your code here
        char[][] newGrid = new char[grid.size()][grid.get(0).length()];
        for (int i = 0; i < newGrid.length; i++) {
            for (int j = 0; j < newGrid[0].length; j++) {
                newGrid[i][j] = grid.get(i).charAt(j);
            }
        }

        char[][] firstState = getStates(newGrid, false);
        char[][] secondState = getStates(firstState, false);

        boolean next = false;
        int state = -1;

        for (int i = 2; i <= n; i++) {
            if (state != 0) {
                state = 0;
                continue;
            }

            if (next) state = 1;
            else state = 2;
            next = !next;
        }

        if (state == -1) return grid;
        if (state == 0) return convertBack(firstState, true);
        if (next) return convertBack(firstState, false);
        return convertBack(secondState, false);
    }

    private static List<String> convertBack(char[][] grid, boolean empty) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            StringBuilder cur = new StringBuilder();
            for (int j = 0; j < grid[0].length; j++) {
                if (empty) cur.append('O');
                else cur.append(grid[i][j]);
            }

            res.add(cur.toString());
        }

        return res;
    }

    private static char[][] getStates(char[][] grid, boolean fill) {
        Set<Integer[]> bombs = new HashSet<>();
        char[][] newGrid = new char[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            newGrid[i] = grid[i].clone();
        }

        for (int i = 0; i < newGrid.length; i++) {
            for (int j = 0; j < newGrid[i].length; j++) {
                if (newGrid[i][j] == 'O') bombs.add(new Integer[]{i, j});
                else newGrid[i][j] = 'O';
            }
        }

        for (Integer[] bomb : bombs) {
            newGrid[bomb[0]][bomb[1]] = '.';
            if (bomb[0] - 1 >= 0) newGrid[bomb[0] - 1][bomb[1]] = '.';
            if (bomb[1] + 1 < newGrid[0].length) newGrid[bomb[0]][bomb[1] + 1] = '.';
            if (bomb[0] + 1 < newGrid.length) newGrid[bomb[0] + 1][bomb[1]] = '.';
            if (bomb[1] - 1 >= 0) newGrid[bomb[0]][bomb[1] - 1] = '.';
        }

        return newGrid;
    }
}

public class TheBombermanGame {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int r = Integer.parseInt(firstMultipleInput[0]);

        int c = Integer.parseInt(firstMultipleInput[1]);

        int n = Integer.parseInt(firstMultipleInput[2]);

        List<String> grid = IntStream.range(0, r).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        List<String> result = Result53.bomberMan(n, grid);

        bufferedWriter.write(
                result.stream()
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
