
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SuperDigit {

	// Complete the superDigit function below.
	static int superDigit(String n, int k) {
		BigInteger sum = new BigInteger("0");
		//n = n.repeat(k); // only applies in java 11
		//n = new String(new char[k]).replace("\0", n);



		for (char ch : n.toCharArray()) {
			//System.out.println("ch = " + new BigInteger(String.valueOf(ch)));
			//sum.add(BigInteger.valueOf((9)));
			sum = sum.add(new BigInteger(String.valueOf(ch)));
			//System.out.println("sum+ch = " + sum);
		}

		BigInteger number = sum.multiply(BigInteger.valueOf(k));
		//System.out.print("sending the input n as = " + number);
		return superDigitHelper(number);

	}
	static int superDigitHelper(BigInteger n) {
		//System.out.println("superDigitHelper received number = " + n);
		BigInteger sum = new BigInteger("0");
		if (n.divide(BigInteger.valueOf(10)).equals(BigInteger.valueOf(0))) {
			return (n.intValue());
		} else {
			while (n.divide(BigInteger.valueOf(10)).compareTo(BigInteger.valueOf(0)) > 0) {
				BigInteger[] divArr = n.divideAndRemainder(BigInteger.valueOf(10));
				sum = sum.add(divArr[1]);
				n = divArr[0];
			}
			sum = sum.add(n);
			//System.out.println(" After addition sum = " + sum);
			n = sum;
		}
		return superDigitHelper(n);
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String[] nk = scanner.nextLine().split(" ");

		String n = nk[0];

		int k = Integer.parseInt(nk[1]);

		int result = superDigit(n, k);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}

