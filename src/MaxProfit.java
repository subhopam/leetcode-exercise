/**
The cost of stock on each day is given in an array A[] of size N. Find all the days on which you buy and sell the stock so that in between those days your profit is maximum.

Input:
First line contains number of test cases T. First line of each test case contains an integer value N denoting the number of days, followed by an array of stock prices of N days.

Output:
For each testcase, output all the days with profit in a single line. And if there is no profit then print "No Profit".

Constraints:
1 <= T <= 100
2 <= N <= 103
0 <= Ai <= 104

Example
Input:
3
7
100 180 260 310 40 535 695
4
100 50 30 20
10
23 13 25 29 33 19 34 45 65 67

Output:
(0 3) (4 6)
No Profit
(1 4) (5 9)

Explanation:
Testcase 1: We can buy stock on day 0, and sell it on 3rd day, which will give us maximum profit.

Note: Output format is as follows - (buy_day sell_day) (buy_day sell_day)
For each input, output should be in a single line.
**/

import java.lang.*;
import java.io.*;
import java.util.*;



class MaxProfit {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = "";

		while ((input = br.readLine()) != null) {
			String[] s = input.split("\\s+");
			//int length = s.lengt	h;
			int[] arr = new int[s.length];

			for (int index = 0; index < s.length; index++) {
				arr[index] = Integer.parseInt(s[index]);
			}
			findMaxProfits(arr);

		}

	}

	public static void findMaxProfits(int[] arr) {
		//System.out.println("Input = " + Arrays.toString(arr));
		int size = arr.length;

		TreeSet<Integer> maxProfits = new TreeSet<Integer>();
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < size - 1; i++) {
			for (int j = i + 1; j < size; j++) {
				if (arr[j] - arr[i] > max) {
					max = arr[j] - arr[i];
				}
				//System.out.println(max);
			}
			maxProfits.add(max);


		}
		//Collections.reverse(maxProfits);

		System.out.println(maxProfits.pollLast());



	}

}