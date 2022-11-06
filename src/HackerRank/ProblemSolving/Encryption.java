package HackerRank.ProblemSolving;

import java.io.*;

class Result45 {

    /*
     * Complete the 'encryption' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String encryption(String s) {
        // Write your code here
        StringBuilder ss = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch != ' ') {
                ss.append(ch);
            }
        }

        int row = (int) Math.floor(Math.sqrt(ss.length()));
        int col = (int) Math.ceil(Math.sqrt(ss.length()));

        char[][] mat;
        if (row * col >= ss.length()) {
            mat = new char[row][col];
        } else {
            mat = new char[col][col];
            row = col;
        }

        int index = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (index >= ss.length()) {
                    mat[i][j] = ' ';
                    continue;
                }

                mat[i][j] = ss.charAt(index++);
            }
        }

        System.out.println(ss);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (mat[j][i] != ' ') {
                    ans.append(mat[j][i]);
                }
            }

            if (i != col - 1) {
                ans.append(" ");
            }
        }

        return ans.toString();
    }
}

public class Encryption {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result45.encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
