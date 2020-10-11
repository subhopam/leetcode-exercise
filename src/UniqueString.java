import java.lang.*;
import java.util.*;
import java.io.*;

public class UniqueString {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = "";
		while ((s = br.readLine()) != null) {
			System.out.println(hasUniqueChars(s));
		}
	}

	public static boolean hasUniqueChars(String s) {
		Hashtable<Character, Integer> hs = new Hashtable<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (hs.containsKey(c)) {
				return false;
			}
			hs.put(c, i);
		}
		return true;
	}
}