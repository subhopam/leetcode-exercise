/***

 Input : AND(NOT(OR(trvg_d_FR:670,trvg_d_FR:90000)),OR(trvg_d_FR:1,trvg_d_FR:169))
 Output : &&(!(||(trvg_d_FR:670,trvg_d_FR:90000)),||(trvg_d_FR:1,trvg_d_FR:169))
 Expected Output : '{!lucene+df=\'trvg_d_FR_ss\'+tag=\'trvg_d_FR_ss\'+q.op=\'OR\'}+(-"670" -"90000)"', '{!lucene df=\'trvg_d_FR_ss\' tag=\'trvg_d_FR_ss\' q.op=\'OR\'} (-"1" -"169")'

**/

import java.lang.*;
import java.util.*;
import java.io.*;

class RulesConversion {


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = "";
		while ((s = br.readLine()) != null) {

			System.out.println(getLWExpression(s));
		}
	}



	public static String getLWExpression(String endecaExp) {
		Stack<String> resStack = new Stack<String>();
		Stack<String> opsStack = new Stack<String>();
		//Stack<String> parethesesStack = new Stack<String>();
		StringBuilder sb = new StringBuilder();

		for (char ch : endecaExp.toCharArray()) {
			//System.out.println(ch);
			//System.out.println(sb.toString());
			if (ch == '(') {
				//parethesesStack.push("" + ch);
				if (!sb.toString().isEmpty()) {
					opsStack.push(sb.toString());
					sb = new StringBuilder();
				}
			} else if (ch == ')') {
				//parethesesStack.pop();

				String tempExp = sb.toString();
				String tempOPs = opsStack.pop();
				String evaluatedExp = evaluate(tempExp, tempOPs);
				System.out.println("input = " + evaluatedExp + " operation = " + tempOPs);
				resStack.push(evaluatedExp);

			} else {
				//System.out.println(ch);
				sb.append("" + ch);
			}





			//System.out.println(resStack);
		}
		return resStack.pop();
	}


	public static String evaluate(String evaluatedExp, String operation) {

		if ("AND".equals(operation)) {

			return evaluatedExp.replace(",", "&&");
			//System.out.println("input = " + evaluatedExp + " operation = " + operation);
		} else if ("OR".equals(operation)) {
			return evaluatedExp.replace(",", "||");
			//System.out.println("input = " + evaluatedExp + " operation = " + operation);
		} else if ("NOT".equals(operation)) {
			return evaluatedExp.replace(",", "!");
			//System.out.println("input = " + evaluatedExp + " operation = " + operation);
		}
		//System.out.println("output = " + evaluatedExp + " operation = " + operation);
		return evaluatedExp;
	}

}