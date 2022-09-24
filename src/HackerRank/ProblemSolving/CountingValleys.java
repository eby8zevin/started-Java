package HackerRank.ProblemSolving;

import java.io.*;

class Result23 {

    /*
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     */

    public static int countingValleys(int steps, String path) {
        // Write your code here
        int numOfValleys = 0;
        int currentLevel = 0;
        boolean flagIn = false;

        for (int i = 0; i < steps; i++) {
            if (path.charAt(i) == 'U') currentLevel++;
            if (path.charAt(i) == 'D') currentLevel--;
            if (currentLevel < 0) {
                flagIn = true;
            }

            if (flagIn && currentLevel == 0) {
                flagIn = false;
                numOfValleys++;
            }
        }

        return numOfValleys;
    }
}

public class CountingValleys {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int steps = Integer.parseInt(bufferedReader.readLine().trim());

        String path = bufferedReader.readLine();

        int result = Result23.countingValleys(steps, path);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
