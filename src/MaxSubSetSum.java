import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MaxSubSetSum {

    // Complete the maxSubsetSum function below.
    static int maxSubsetSum(int[] arr) {
        int n = arr.length;
        int[] sumTable = new int[n + 1];
        Arrays.fill(sumTable, 0);
        sumTable[0] = 0;
        if (sumTable[n] != 0 || n == 0) {
            return 0;
        }
        for (int i = 2; i < n; i + 2) {
            //int j = arr[i - 1];
            sumTable[i] = Math.max(sumTable[i - 1], sumTable[i - 1] + arr[i], sumTable[i - 1] + arr[i - 2]);
            System.out.println("sumTable[" + i + "] = " + sumTable[i]);



        }
        return sumTable[n];
    }



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("output.txt")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = maxSubsetSum(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
