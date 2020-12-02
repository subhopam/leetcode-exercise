import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ConnectedCell {

    // Complete the connectedCell function below.
    static int connectedCell(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        boolean[][]visited = new boolean[row][column];
        int count = 0;
        int tempCount = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (!visited[i][j] && matrix[i][j] == 1) {
                    dfs(matrix, i, j, count, visited); //self


                }




            }
        }
        return count;

    }

    static int  dfs(int[][]matrix, int row, int column, int count, boolean[][] visited) {
        if (!isSafe(matrix, row, column, visited)) {
            return 0;



        }


        visited[row][column] = true;
        matrix[row][column] = 2;

        ++count;

        return findMax(count + dfs(matrix, row - 1, column - 1, count, visited), //NW
                       count + dfs(matrix, row - 1, column + 1, count, visited), //NE
                       count + dfs(matrix, row - 1, column, count, visited), // N
                       count + dfs(matrix, row + 1, column, count, visited), // S
                       count + dfs(matrix, row, column + 1, count, visited), // E
                       count + dfs(matrix, row, column - 1, count, visited), //W
                       count + dfs(matrix, row + 1, column + 1,  count, visited), //SE
                       count + dfs(matrix, row + 1, column - 1,  count, visited) //SW
                      );
    }


    public static int findMax(int a1, int a2, int a3, int a4, int a5, int a6, int a7, int a8) {
        //System.out.println(a1);
        return Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(a1, a2), a3), a4), a5), a6), a7), a8);
    }

    static boolean isSafe(int[][]matrix, int row, int column, boolean[][]visited) {
        int R = matrix.length;
        int C = matrix[0].length;
        //System.out.println("row= " + row + " column= " + column);
        if (row < R && row >= 0 && column < C && column >= 0 && !visited[row][column] && matrix[row][column] == 1) {
            return true;
        }
        return false;
    }



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] matrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] matrixRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < m; j++) {
                int matrixItem = Integer.parseInt(matrixRowItems[j]);
                matrix[i][j] = matrixItem;
            }
        }

        int result = connectedCell(matrix);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
