
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

class TestClass {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        String numOfInput;
        Long result=0l;
        
        try {
            numOfInput= br.readLine();
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split("\\s");
                System.out.println(Arrays.toString(tokens));
               for(int i=0;i<tokens.length;i++){
                    result+=Integer.parseInt(tokens[i]);
                }
            System.out.println(result);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

}
