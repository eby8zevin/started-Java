package HackerRank.ProblemSolving;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

class Result54 {

    /*
     * Complete the 'twoPluses' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING_ARRAY grid as parameter.
     */

    public static int twoPluses(List<String> area) {
        // Write your code here
        int[][] grid = area.stream().map(row -> row.chars().map(x -> x == 'G' ? 1 : 0).toArray()).toArray(int[][]::new);
        List<Cross> crosses = new ArrayList<>();

        int width = grid[0].length;
        int height = grid.length;
        int maxArea = 0;

        for (int x = 1; x < width - 1; x++)
            for (int y = 1, halo = 1; y < height - 1; y++, halo = 1)
                if (grid[y][x] == 1)
                    while (x - halo >= 0 && grid[y][x - halo] == 1 &&
                            x + halo < width && grid[y][x + halo] == 1 &&
                            y - halo >= 0 && grid[y - halo][x] == 1 &&
                            y + halo < height && grid[y + halo][x] == 1)
                        crosses.add(new Cross(x, y, halo++));

        if (crosses.isEmpty())
            return Arrays.stream(grid).flatMapToInt(Arrays::stream).filter(a -> a == 1).findFirst().orElse(0);

        for (int i = 0; i < crosses.size() - 1; i++)
            for (int j = i + 1; j < crosses.size(); j++)
                if (!crosses.get(i).isOverlapping(crosses.get(j)))
                    maxArea = Math.max(crosses.get(i).area * crosses.get(j).area, maxArea);

        return Math.max(crosses.stream().max(Comparator.comparingInt(c -> c.area)).get().area, maxArea);
    }

    private static class Cross {
        private final int x, y, length, area;

        private Cross(int x, int y, int armLength) {
            this.x = x;
            this.y = y;
            this.length = armLength;
            this.area = armLength * 4 + 1;
        }

        private boolean isOverlapping(Cross other) {
            int deltaX = Math.abs(this.x - other.x);
            int deltaY = Math.abs(this.y - other.y);

            if (this.x == other.x && deltaY <= this.length + other.length) return true;
            if (this.y == other.y && deltaX <= this.length + other.length) return true;

            if (deltaX > Math.min(this.length, other.length) && deltaY > Math.min(this.length, other.length))
                return false;

            return (deltaX <= Math.max(this.length, other.length) && deltaY <= Math.max(this.length, other.length));
        }
    }
}

public class EmasSupercomputer {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<String> grid = IntStream.range(0, n).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        int result = Result54.twoPluses(grid);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
