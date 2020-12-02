/**
In this problem, we'll use the term "longest common substring" loosely. It refers to substrings differing at some number or fewer characters when compared index by index. For example, 'abc' and 'adc' differ in one position, 'aab' and 'aba' differ in two.

Given two strings and an integer , determine the length of the longest common substrings of the two strings that differ in no more than  positions.

For example, . Strings  and . Check to see if the whole string (the longest substrings) matches. Given that neither the first nor last characters match and , we need to try shorter substrings. The next longest substrings are  and . Two pairs of these substrings only differ in  position:  and . They are of length .

Function Description

Complete the substringDiff function in the editor below. It should return an integer that represents the length of the longest common substring as defined.

substringDiff has the following parameter(s):

k: an integer that represents the maximum number of differing characters in a matching pair
s1: the first string
s2: the second string
Input Format

The first line of input contains a single integer, , the number of test cases follow.
Each of the next  lines contains three space-separated values: an integer  and two strings,  and .

Constraints

All characters in  and .
Output Format

For each test case, output a single integer which is the length of the maximum length common substrings differing at  or fewer positions.

Sample Input

3
2 tabriz torino
0 abacba abcaba
3 helloworld yellomarin
Sample Output

4
3
8
Explanation

First test case: If we take "briz" from the first string, and "orin" from the second string, then the number of mismatches between these two substrings is equal to 2 and their lengths are .

Second test case: Since , we should find the longest common substring, standard definition, for the given input strings. We choose "aba" as the result.

Third test case: We can choose "hellowor" from first string and "yellomar" from the second string.
**/

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class SubStringDiff {

	// Complete the substringDiff function below.
	static int substringDiff(int k, String s1, String s2) {


	}

	static boolean isDiffEqual(int k, String s1, String s2) {
		//Assume both the string has the same length

		int end = s1.length() - 1;
		int start = 0;
		int diff = 0;
		while (start < end && diff < k) {
			if (s1.charAt(start) != s2.charAt(start)) {
				diff++;
			}
			star++;
		}

		return (start = end && diff <= k);

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			String[] kS1S2 = scanner.nextLine().split(" ");

			int k = Integer.parseInt(kS1S2[0]);

			String s1 = kS1S2[1];

			String s2 = kS1S2[2];

			int result = substringDiff(k, s1, s2);

			bufferedWriter.write(String.valueOf(result));
			bufferedWriter.newLine();
		}

		bufferedWriter.close();

		scanner.close();
	}
}
