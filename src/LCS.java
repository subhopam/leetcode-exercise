/**

A subsequence is a sequence that can be derived from another sequence by deleting some elements without changing the order of the remaining elements. Longest common subsequence (LCS) of 2 sequences is a subsequence, with maximal length, which is common to both the sequences.

Given two sequences of integers,  and , find the longest common subsequence and print it as a line of space-separated integers. If there are multiple common subsequences with the same maximum length, print any one of them.

In case multiple solutions exist, print any of them. It is guaranteed that at least one non-empty common subsequence will exist.


Function Description

Complete the longestCommonSubsequence function in the editor below. It should return an integer array of a longest common subsequence.

longestCommonSubsequence has the following parameter(s):

a: an array of integers
b: an array of integers
Input Format

The first line contains two space separated integers  and , the sizes of sequences  and .
The next line contains  space-separated integers .
The next line contains  space-separated integers .

Constraints





Constraints



Output Format

Print the longest common subsequence as a series of space-separated integers on one line. In case of multiple valid answers, print any one of them.

Sample Input

5 6
1 2 3 4 1
3 4 1 2 1 3
Sample Output

1 2 3
Explanation

There is no common subsequence with length larger than 3. And "1 2 3", "1 2 1", "3 4 1" are all correct answers


**/
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class LCS {

	// Complete the longestCommonSubsequence function below.
	static Integer[] longestCommonSubsequence(int[] a, int[] b) {

		int m = a.length;
		int n = b.length;
		int dp[][] = new int[m + 1][n + 1];
		lcs(a, b, m, n, dp);

		int resultLength = m > n ? n : m;

		List<Integer> finalResults = new LinkedList<>();
		int i = m; int j = n;

		while (i > 0 && j > 0) {
			if (a[i - 1] == b[j - 1]) {
				finalResults.add(a[i - 1]);
				i--;
				j--;
			} else {
				if (dp[i - 1][j] > dp[i][j - 1])
					i--;
				else
					j--;
			}
		}
		//List<Integer> fullFinalResults = finalResults.stream().filter(Objects::nonNull).collect(Collectors.toList());


		List<Integer> listWithoutNulls = finalResults.parallelStream()
		                                 .filter(Objects::nonNull)
		                                 .collect(Collectors.toList());
		Collections.reverse(listWithoutNulls);
		Integer[] result = new Integer[listWithoutNulls.size()];

		return listWithoutNulls.toArray(result);
	}

	static int lcs(int[] a, int[] b, int m, int n, int[][] dp) {


		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				} else if (a[i - 1] == b[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1];
				} else if (a[i - 1] != b[j - 1]) {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		System.out.println(Arrays.toString(dp));
		return dp[m][n];
	}


	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String[] nm = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nm[0]);

		int m = Integer.parseInt(nm[1]);

		int[] a = new int[n];

		String[] aItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int aItem = Integer.parseInt(aItems[i]);
			a[i] = aItem;
		}

		int[] b = new int[m];

		String[] bItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < m; i++) {
			int bItem = Integer.parseInt(bItems[i]);
			b[i] = bItem;
		}

		Integer[] result = longestCommonSubsequence(a, b);

		for (int i = 0; i < result.length; i++) {
			bufferedWriter.write(String.valueOf(result[i]));

			if (i != result.length - 1) {
				bufferedWriter.write(" ");
			}
		}

		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
