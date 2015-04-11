package peter.sphereoj.solutions.solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Piotr Kulma on 26.02.15.
 *
 * Status: done
 */
public class Problem1 {
    public static void main(String[] args) throws IOException {
        String line;
        InputStream in = System.in;
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        while((line = reader.readLine()) != null) {
            if(!"42".equals(line)) {
                System.out.println(line);
            } else {
                break;
            }
        }
    }
}
