/**

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.


Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]

2-abc
3-def
4-ghi
5-jkl
6-mno
7-pqrs
8-tuv
9-wxyz
**/

import java.lang.*;
import java.util.*;
import java.io.*;
import java.nio.*;

public class PhoneNumCombo {

	public static void main(String[] args) throws IOException {
		PhoneNumCombo phoneNumCombo = new PhoneNumCombo();
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(reader);
		String line;
		while ((line = in.readLine()) != null) {
			System.out.println(phoneNumCombo.letterCombinations(line));
		}
	}

	public List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<>();
		Map<String, String> keyPadMap = new HashMap<>();
		keyPadMap.put("2", "abc");
		keyPadMap.put("3", "def");
		keyPadMap.put("4", "ghi");
		keyPadMap.put("5", "jkl");
		keyPadMap.put("6", "mno");
		keyPadMap.put("7", "pqrs");
		keyPadMap.put("8", "tuv");
		keyPadMap.put("9", "wxyz");

		backtrack(digits, keyPadMap, 0, result);

		return result;

	}

	public  void addLetters(String digits, Map<String, String> keyPadMap, int start, List<String> result) {
		if (start == digits.length) {
			result.add(digits);
		}
		String value = keyPadMap.get(String.valueOf(digits.charAt(start)));
		for (char ch : value.toCharArray()) {
			String newDigits =  + addLetters(String.valueOf(ch) + digits.substring(++start), keyPadMap, start, result);
		}
	}


}