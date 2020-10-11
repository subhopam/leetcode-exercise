import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;



class Result {

    /*
     * Complete the 'countDuplicate' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY numbers as parameter.
     */

    public static int countDuplicate(List<Integer> numbers) {
        // Write your code here
        int duplicateCount = 0;
        Map<Integer, Integer> freqCountMap = new HashMap<>();
        for (int i = 0; i < numbers.size(); i++) {
            if (!freqCountMap.isEmpty() && freqCountMap.containsKey(numbers.get(i))) {
                int count = freqCountMap.get(numbers.get(i));
                freqCountMap.put(numbers.get(i), ++count);
            } else {
                freqCountMap.put(numbers.get(i), 1);
            }
        }
        for (int key : freqCountMap.keySet()) {
            if (freqCountMap.get(key) > 1) {
                duplicateCount++;
            }
        }
        return duplicateCount;
    }

}

public class FindDuplicate {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("output.txt")));

        int numbersCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < numbersCount; i++) {
            int numbersItem = Integer.parseInt(bufferedReader.readLine().trim());
            numbers.add(numbersItem);
        }

        int result = Result.countDuplicate(numbers);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
