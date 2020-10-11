/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws Exception {
		//code
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		GFG gfg = new GFG();
		String line;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String numOfInput = br.readLine();
		while ((line = br.readLine()) != null) {
			int input =  Integer.parseInt(line);
			pq.offer(input);
			System.out.println(gfg.findMedian(pq));
		}


	}

	public Integer findMedian(PriorityQueue<Integer> pq) {
		if (pq.size() < 2) {
			return pq.peek();
		}
		Integer[] pqArray = pq.toArray(new Integer[pq.size()]);
		int size = pqArray.length;
		if (size % 2 == 0) {
			int m1 = size / 2;
			int m2 = size / 2 - 1;
			return (pqArray[m1] + pqArray[m2]) / 2;
		} else {
			return (pqArray[size / 2]);
		}
	}
}