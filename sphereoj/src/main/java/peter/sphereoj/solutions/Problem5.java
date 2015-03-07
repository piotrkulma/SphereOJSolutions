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

        while((line = reader.readLine()) != null) {
            System.out.println(findNextPalindrome(line));
        }
    }

    private int findNextPalindrome(String text) {
        int pal = Integer.parseInt(text);
        pal = pal + 1;
        while(!isPalindrome(Integer.toString(pal))) {
            pal = pal + 1;
        }

        return pal;
    }

    private boolean isPalindrome(String text) {
        for(int i=0; i<text.length(); i++) {
            if(text.charAt(i) != text.charAt(text.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
