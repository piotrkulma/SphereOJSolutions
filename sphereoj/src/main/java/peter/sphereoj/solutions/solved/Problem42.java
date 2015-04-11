package peter.sphereoj.solutions.solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Piotr Kulma on 08.03.15.
 *
 * Status: done
 */
public class Problem42 {
    public static void main(String[] args) throws IOException {
        new Problem42().runSolution();
    }

    private void runSolution() throws IOException {
        String line;
        InputStream in = System.in;
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        int dataCount = Integer.parseInt(reader.readLine());

        for(int i=0; i<dataCount; i++) {
            line = reader.readLine();
            String[] arguments = line.split(" ");
            System.out.println(findReverseSum(arguments[0], arguments[1]));
        }
    }

    private int findReverseSum(String a, String b) {
        StringBuffer bufferA = new StringBuffer(a);
        StringBuffer bufferB = new StringBuffer(b);

        int res = Integer.parseInt(bufferA.reverse().toString()) + Integer.parseInt(bufferB.reverse().toString());

        StringBuffer result = new StringBuffer(Integer.toString(res));
        return Integer.parseInt(result.reverse().toString());
    }
}
