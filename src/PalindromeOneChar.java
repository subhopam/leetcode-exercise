/**
Input : str = "abccaa"
Output : Yes
We can change the second last character
i.e. 'a' to 'b' to make it palindrome string

abccaa
aaccba

Input : str = "abbcca"
Output : No
We can not convert the string into palindrome
string by changing only one character.
**/

import java.lang.*;
import java.util.*;
import java.io.*;

class PalindromeOneChar {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("output.txt")));

		//int numbersCount = Integer.parseInt(bufferedReader.readLine().trim());

		String input = bufferedReader.readLine().trim();

		boolean hasPalindromePerm = PalindromeOneChar.hasPalindrome(input);

		bufferedWriter.write(String.valueOf(hasPalindromePerm));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}

	public static boolean hasPalindrome(String s) {
		boolean isBoolean = true;
		Map<Character, Integer> hm = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (hm.containsKey(ch)) {
				int count = hm.get(ch);
				hm.put(ch, ++count);
			} else {
				hm.put(ch, 1);
			}
		}
		System.out.println();
		int countOfOdd = 0;
		for (Character ch : hm.keySet()) {
			if (hm.get(ch) % 2 != 0) {
				++countOfOdd;
			}
			if (countOfOdd > 1) {
				isBoolean = false;
				break;
			}
		}
		return isBoolean;
	}

}