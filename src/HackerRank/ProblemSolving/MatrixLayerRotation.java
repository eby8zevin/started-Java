package HackerRank.ProblemSolving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result57 {
    public static void matrixRotation(List<List<Integer>> matrix, int r) {
        // Initialization
        int rows = matrix.size();
        int cols = matrix.get(0).size();

        // Compute number of rings to rotate
        int rings = rows > cols ? cols / 2 : rows / 2;

        // Iterate through rings
        for (int ring = 0; ring < rings; ring++) {
            // Compute the actual number of rows/cols to consider
            int arows = (rows - 2 * ring) - 1;
            int acols = (cols - 2 * ring) - 1;

            // This is the lenght of the ring
            int g = arows * 2 + acols * 2;

            // Initialize ring index
            int col = ring;
            int row = ring;

            // Compute the actual number of rotations (avoid infinite looping)
            int ar = r % g;

            // Rotate ring for 'ar' times
            while (ar-- > 0) {
                Integer previous = null;

                for (int c = 0; c <= g; c++) {
                    if (c <= arows)
                        row = ring + c;
                    else if (c > arows && c <= (acols + arows))
                        col += 1;
                    else if (c > (acols + arows) && c <= (2 * arows + acols))
                        row -= 1;
                    else
                        col -= 1;

                    Integer current = matrix.get(row).get(col);
                    matrix.get(row).set(col, previous);
                    previous = current;
                }
            }
        }

        // Print output
        for (List<Integer> list : matrix) {
            for (Integer i : list)
                System.out.print(String.format("%d ", i));
            System.out.println("");
        }
    }
}

public class MatrixLayerRotation {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(firstMultipleInput[0]);

        int n = Integer.parseInt(firstMultipleInput[1]);

        int r = Integer.parseInt(firstMultipleInput[2]);

        List<List<Integer>> matrix = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                matrix.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        Result57.matrixRotation(matrix, r);

        bufferedReader.close();
    }
}
