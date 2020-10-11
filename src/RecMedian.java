import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

public class RecMedian {
  /**
   * Iterate through each line of input.
   */
  public static void main(String[] args) throws IOException {
    RecMedian main = new RecMedian();
    InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
    BufferedReader in = new BufferedReader(reader);
    String line;
    Integer windowSize = Integer.parseInt(in.readLine()); // windowsize is always odd

    while ((line = in.readLine()) != null) {
      String[] inputStringArr = line.split(",");
      //System.out.println("inputStringArr = " + Arrays.toString(inputStringArr) + " windowSize = " + windowSize);
      System.out.println(main.printRecMedFilter(inputStringArr, windowSize));
    }
  }
  private String printRecMedFilter(String[] inputStringArr, Integer windowSize) {
    LinkedList<Integer> resultList = new LinkedList <Integer> ();
    int lengthOfInput = inputStringArr.length;
    RecMedian main = new RecMedian();
    String result = "";
    int medianIndex = windowSize / 2;
    int i = 0;
    int[] slideWindow = new int[windowSize];
    while (i <= lengthOfInput - windowSize) {
      int k = 0;
      slideWindow = new int[windowSize];
      while (k < windowSize) {

        //System.out.println("i= " + i + "k = " + k);
        //System.out.println("Adding to slideWindow = " + inputStringArr[i + k]);
        if (!resultList.isEmpty() && k < windowSize / 2) {
          slideWindow[k] = resultList.peekLast();
        } else {
          slideWindow[k] = Integer.parseInt(inputStringArr[i + k]);
        }


        //System.out.println("slideWindow = " + Arrays.toString(slideWindow));
        k++;
      }
      //System.out.println("resultList.peek() == " + resultList.peekLast());

      //System.out.println("Before sorting  == " + Arrays.toString(slideWindow));
      resultList.add(main.findMedian(slideWindow, medianIndex));

      i++;
    }
    //System.out.println(resultList);
    return resultList.stream().map(Object::toString).collect(Collectors.joining(","));
  }


  public int findMedian(int[] slideWindow, int medianIndex) {

    Arrays.sort(slideWindow);
    //System.out.println("slideWindow = " + Arrays.toString(slideWindow) + " medianIndex = " + medianIndex + " median = " + slideWindow[medianIndex]);
    //System.out.println(" median = " + slideWindow[medianIndex]);
    return slideWindow[medianIndex];
  }
}