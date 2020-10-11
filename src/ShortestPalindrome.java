import java.lang.*;
import java.io.*;
import java.util.*;



class ShortestPalindrome {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("output.txt")));

		String inputString = bufferedReader.readLine();




		bufferedWriter.write(Result.getShortestPalindrome(inputString));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}


}
class Result {

	public static String getShortestPalindrome(String str) {
		int n = str.length();
		if (n == 1) {
			return str;
		}
		if (str.charAt(0) != charAt(n - 1)) {
			str = charAt(n - 1) + str;
			return getShortestPalindrome(str);
		}
		return str.subString();
	}

	public statis boolean isPalindrome(String str) {
		char[] charArr = str.charArray();
		int length = charArr.length;
		if (length <= 1) return true;
		for (int i = 0; i < length; i++) {
			if (char[i] != charAt[length - i - 1]) {
				char
			}
		}
	}


}