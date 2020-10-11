
import java.io.*;
import java.lang.*;
import java.util.*;

public class LargestConsSeq {
	public static void main(String[] args) throws IOException {
		LargestConsSeq largeSeq = new LargestConsSeq();
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(reader);
		String line;
		while ((line = in.readLine()) != null) {
			String[] inputStringArr = line.split("\\s");
			//System.out.println("inputStringArr = " + Arrays.toString(inputStringArr) + " windowSize = " + windowSize);
			int n = inputStringArr.length;
			int[] dp = new int[n];
			Arrays.fill(dp, 0);
			findLargestSeq(inputStringArr, dp);
		}
	}

	public static void findLargestSeq(String[] input, int[] dp) {
		int n = input.length;
		//int[] dp = new int[n];
		/**
		dp(i)= 1+dp(i-1) if input[i]-input[i-1]==1
			 = dp(i-1) otherwise
		*/
		dp[0] = 0;
		dp[1] = 1;

		for (int i = 2; i < n; i++) {
			if (dp[i] - dp[i - 1] == 1)
				dp[i] = 1 + dp[i - 1];
			else
				dp[i] = dp[i - 1];
		}
		System.out.println(dp[n]);
	}
}