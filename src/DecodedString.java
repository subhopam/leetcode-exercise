/***


Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].



Example 1:

Input: s = "3[a]2[bc]"
Output: "aaabcbc"
Example 2:

Input: s = "3[a2[c]]"
Output: "accaccacc"
Example 3:

Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"
Example 4:

Input: s = "abc3[cd]xyz"
Output: "abccdcdcdxyz"

***/



import java.lang.*;
//import java.util.*;
import java.io.*;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;

public class DecodedString {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
		String input = "";
		while ((input = br.readLine()) != null) {
			//System.out.println("input = " + input);
			decodeString(input);
		}

	}


	public static String decodeString(String s) {
		Deque<String> dq = new ArrayDeque<String>();
		int index = 0;

		if (!s.contains("]")) {
			return s;
		}

		while (s.charAt(index) != ']') {
			dq.push(String.valueOf(s.charAt(index)));
			index++;


		}

		dq = evaluate(dq);
		index += 2;
		//System.out.println(Arrays.toString(dq.toArray()));
		return s;
	}

	public static Deque<String>  evaluate(Deque<String> dq) {
		System.out.println(Arrays.toString(dq.toArray()));
		StringBuilder sb = new StringBuilder();
		String currentChar = dq.pop();
		String result = "";
		while (!dq.isEmpty()) {
			currentChar = dq.pop();
			if (!currentChar.equals("[")) {
				sb.append(currentChar);
			} else {
				break;

			}
		}
		//int number = Integer.parseInt(String.valueOf(dq.pop())); // its the number of repeation now
		//System.out.println("number = " + number);
		result = repeat(sb.toString(), 2);
		dq.push(result);
		return dq;
	}

	public static String repeat(String s, int number) {
		System.out.println("number = " + number + " s = " + s);
		StringBuilder sb = new StringBuilder();
		int count = 0;
		while (count < number) {
			sb.append(s);
		}
		return sb.toString();
	}

}