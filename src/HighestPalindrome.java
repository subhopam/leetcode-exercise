import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class HighestPalindrome {

    // Complete the highestValuePalindrome function below.
    static String highestValuePalindrome(String s, int n, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        int length = s.length();
        findPalindromes(s, k, 0, length - 1, pq);
        return String.valueOf(pq.poll());
    }

    static void findPalindromes(String s, int k, int start, int end, PriorityQueue<Integer> pq) {
        System.out.println(" input string = " + s);
        if (k == 0 && !isPalindrome(s, 0, s.length() - 1)) {
            return;
        }
        if (start >= end) {
            return;
        }
        if (isPalindrome(s, 0, s.length() - 1)) {
            pq.offer(Integer.valueOf(s));
            return;
        }
        //int n = s.length();

        System.out.println("i = " + start + " j= " + end);
        if (s.charAt(start) == s.charAt(end)) {
            findPalindromes(s.substring(++start, --end), k, start, end, pq);
        } else {
            //replace the charcters
            String afterReplacement = replace(s, start, end);
            findPalindromes(afterReplacement.substring(start + 1, end - 1), --k, start + 1, end - 1, pq); // TODO: replacement logic
            afterReplacement = replace(s, end, start);
            findPalindromes(afterReplacement.substring(start + 1, end - 1), --k, start + 1, end - 1, pq);
        }

    }

    public static boolean isPalindrome(String s, int start, int end) {
        if (start == end) {
            return true;
        }
        if ((start > end) || (s.charAt(start) != s.charAt(end - 1))) {
            return false;
        }
        return isPalindrome(s, start + 1, end - 1);
    }

    private static String replace(String s, int i, int j) {
        char[] charArr = s.toCharArray();
        char temp = charArr[i]; charArr[i] = charArr[j]; charArr[j] = temp;
        return new String(charArr);

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        String s = scanner.nextLine();

        String result = highestValuePalindrome(s, n, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
