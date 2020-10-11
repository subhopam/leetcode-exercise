import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.lang.*;
import java.util.*;

public class LuhnCreditCard {
  /**
   * Iterate through each line of input.
   */
  public static void main(String[] args) throws IOException {
    LuhnCreditCard main = new LuhnCreditCard();
    InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
    BufferedReader in = new BufferedReader(reader);
    String line;
    while ((line = in.readLine()) != null) {
      System.out.println(main.isValid(line));
    }
  }
  public Boolean isValid(String cardNum) {
    LuhnCreditCard main = new LuhnCreditCard();
    int lengthOfNum = cardNum.length();
    if (lengthOfNum < 2) {
      return false;
    }
    List<Integer> indexList = main.secondDigitIndexes(lengthOfNum);
    int sum = Character.getNumericValue(cardNum.charAt(lengthOfNum - 1));
    //System.out.println(" indexList == " + indexList);
    for (int i = lengthOfNum - 2; i >= 0; i--) {
      int currentDigit = 0;
      //System.out.println(" indexList contains i= " + i + " " + indexList.contains(i));
      if (indexList.contains(i)) { // case for second digits
        currentDigit = 2 * Character.getNumericValue(cardNum.charAt(i));
        if (currentDigit > 9) {
          //System.out.println("currentDigit before -9 =" + currentDigit);
          currentDigit = (currentDigit - 9);
        }
      } else {
        currentDigit = Character.getNumericValue(cardNum.charAt(i));
      }
      //System.out.println("currentDigit = " + currentDigit + "index = " + i);
      sum += currentDigit;
    }

    //System.out.println("sum = " + sum);
    return (sum % 10 == 0);
  }

  public List<Integer> secondDigitIndexes(int lengthOfNum) {
    List<Integer> indexList = new ArrayList<>();
    int startIndex = lengthOfNum - 2;
    while (startIndex >= 0) {
      indexList.add(new Integer(startIndex));
      startIndex -= 2;
    }
    return indexList;
  }
}