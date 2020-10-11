/**
	Given a String , find all possible permutations in a list
	I/P - "abc" o/p - ["abc","acb","bac","bca","cab","cba"]
**/

import java.lang.*;
import java.util.*;
import java.io.*;

public class FindAllPerm {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = "";
		List<String> results = new ArrayList<String>();
		while ((s = br.readLine()) != null) {
			getPerms(s, results);
			System.out.println(results);
		}
	}

	public static void getPerms(String s, List<String> results ) {
		int length = s.length();
		if (length == 1) return;
		for (int i = 0; i < length; i++) {
			char temp = s.charAt(i);
			getPerms(s.substring(i + 1, length - 1).concat(s.substring(0, i)), results);
			getPerms(s.substring(i + 1, length - 1).concat(s.substring(0, i)), results);
			if (i == length - 1) {
				results.add(s1);
				results.add(s2);
			}

		}
	}

}