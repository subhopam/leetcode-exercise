import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class PowerSum {

    // Complete the powerSum function below.
    static int powerSum(int X, int N) {
        if (X == 0) return 0;
        if (X == 1) return 1;
        int count = 0;
        powerSumHelper(X, N, count);
        return count;
    }

    static void powerSumHelper(int X, int N, int count) {
        if (X < 0) return;

        if (X == 0) {
            count++;
            return;
        }

        int i = 1;
        while (i < Math.sqrt(X)) {
            X -= i ^ 2;
            powerSumHelper(X, N, count);
            i++;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int X = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int result = powerSum(X, N);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
