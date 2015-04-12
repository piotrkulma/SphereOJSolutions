package peter.sphereoj.solutions.solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Created by Piotr Kulma on 11.04.15.
 *
 * Status: solved
 */
public class Problem31 {
    public static void main(String[] args) throws IOException {
        new Problem31().runSolution();
    }

    private void runSolution() throws IOException {
        String[] arguments;
        InputStream in = System.in;
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        int multiplications = Integer.parseInt(reader.readLine());

        for(int i=0; i<multiplications; i++) {
            arguments = reader.readLine().split(" ");

            BigInteger qi1 = new BigInteger(arguments[0]);
            BigInteger qi2 = new BigInteger(arguments[1]);

            System.out.println(qi1.multiply(qi2));
        }
    }
}
