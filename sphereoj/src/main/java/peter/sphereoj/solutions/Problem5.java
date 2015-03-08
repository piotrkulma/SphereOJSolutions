package peter.sphereoj.solutions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Piotr Kulma on 08.03.15.
 */
public class Problem5 {
    public static void main(String[] args) throws IOException {
        new Problem5().runSolution();
    }

    private void runSolution() throws IOException {
        String line;
        InputStream in = System.in;
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        int dataCount = Integer.parseInt(reader.readLine());

        for(int i=0; i<dataCount; i++) {
            line = reader.readLine();
            System.out.println(findNextPalindrome(line));
        }
    }

    private String findNextPalindrome(String text) {
        String pal = inc(text);
        while(!isPalindrome(pal)) {
            pal = inc(pal);
        }

        return pal;
    }

    private boolean isPalindrome(String text) {
        System.out.println("isP " + text);
        for(int i=0; i<text.length(); i++) {
            if(text.charAt(i) != text.charAt(text.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    private String inc(String argA) {
        return add(argA, "1");
    }

    private String add(String argA, String argB) {
        int memory=0;
        int partialSum;
        int bLen = argB.length();

        String fullAddition = "";
        for(int i=0; i< argA.length(); i++) {
            char a = argA.charAt(argA.length() - i - 1);
            char b;
            if(bLen - i - 1 >= 0) {
                b = argB.charAt(argB.length() - i - 1);
            } else {
                b = '0';
            }

            partialSum = ((int)a - 48) + ((int)b - 48) + memory;
            memory = 0;
            if(partialSum >= 10) {
                fullAddition = (partialSum-10) + fullAddition;
                memory = 1;
            } else {
                fullAddition = partialSum + fullAddition;
            }

        }
        if(memory == 1) {
            fullAddition = '1' + fullAddition;
        }

        return fullAddition;
    }
}
