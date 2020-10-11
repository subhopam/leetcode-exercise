
import java.io.*;
import java.lang.*;

public class LT50 {

    public static void main (String[] args) throws Exception {
        LT50 obj = new LT50();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double inputNum = Double.parseDouble(br.readLine());
        int power = Integer.parseInt(br.readLine());
        System.out.println(obj.myPow(inputNum, power));

    }

    public double myPow(double x, int n) {
        if (n == 0)
            return 1.0;

        double half = myPow(x, n / 2);
        if (n % 2 == 0)
            return half * half;

        else if (n > 0)
            return half * half * x;

        else
            return half * half / x;
    }
}

