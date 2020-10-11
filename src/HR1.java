import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;



class Result {

    /*
     * Complete the 'findNumber' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arr
     *  2. INTEGER k
     */

    public static String findNumber(List<Integer> arr, int k) {
        // Write your code here
        Collections.sort(arr);
        System.out.println("arr == " + arr);
        int mid = (int)arr.size() / 2;
        System.out.println("mid == " + mid);
        int start = 0;
        int end = arr.size();
        if (k == arr.get(mid))
            return "YES";


        while (start < end) {
            if (k < arr.get(mid)) {
                end = mid;
            } else if (k > arr.get(mid)) {
                start = mid;
            }
            return findNumber(arr.subList(start, end), k);
        }
        return "NO";
    }

}

public class HR1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < arrCount; i++) {
            int arrItem = Integer.parseInt(bufferedReader.readLine().trim());
            arr.add(arrItem);
        }

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.findNumber(arr, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
