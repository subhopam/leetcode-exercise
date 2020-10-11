import java.io.*;

public class Cf71A {

	public static void main (String[] args) throws Exception {
		Cf71A obj = new Cf71A();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numOfInput = Integer.parseInt(br.readLine());
		int count = 0;
		while (br.ready()) {
			String str = br.readLine();
			if (str.length() <= 10) {
				System.out.println(str);
			} else {
				int length = str.length();
				System.out.print(str.charAt(0));
				System.out.print(obj.countDist(str));
				System.out.print(str.charAt(length - 1));
				System.out.println();

			}

		}
	}

	public int countDist(String inputString) {
		return (inputString.length() > 10) ? inputString.length() - 2 : 0;
	}
}