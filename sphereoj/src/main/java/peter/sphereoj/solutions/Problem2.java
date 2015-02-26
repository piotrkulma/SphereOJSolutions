package peter.sphereoj.solutions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Piotr Kulma on 26.02.15.
 */
public class Problem2 {
    public static void main(String[] args) throws IOException {
        String line;
        InputStream in = System.in;
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        int dataCount = Integer.parseInt(reader.readLine());

        while((line = reader.readLine()) != null) {
            String[] range = line.split(" ");
            int first = Integer.parseInt(range[0]);
            int last = Integer.parseInt(range[1]);
            System.out.println(first + " " + last);
        }
    }
}
