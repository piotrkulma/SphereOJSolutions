package peter.sphereoj.solutions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Piotr Kulma on 08.03.15.
 */
public class Problem6 {
    private final String operator = "+-*";

    public static void main(String[] args) throws IOException {
        new Problem6().runSolution();
    }

    private void runSolution() throws IOException {
        String line;
        InputStream in = System.in;
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        int dataCount = Integer.parseInt(reader.readLine());

        for(int i=0; i<dataCount; i++) {
            line = reader.readLine();
            String[] arguments = line.split("[*+-]");
            System.out.println(arguments[0] + " + " + arguments[1] + " = " + add(arguments[0], arguments[1]) );
        }
    }

    private String add(String argA, String argB) {
        char a, b;

        int memory=0;
        int partialSum;
        int bLen = argB.length();

        StringBuffer sb = new StringBuffer("");

        for(int i=0; i< argA.length(); i++) {
            a = argA.charAt(argA.length() - i - 1);
            if(bLen - i - 1 >= 0) {
                b = argB.charAt(argB.length() - i - 1);
            } else {
                b = '0';
            }

            partialSum = ((int)a - 48) + ((int)b - 48) + memory;
            memory = 0;
            if(partialSum >= 10) {
                sb.append(partialSum-10);
                memory = 1;
            } else {
                sb.append(partialSum);
            }

            if(bLen - i - 1 == 0 && memory == 0) {
                StringBuffer sbPart = new StringBuffer(argA.substring(0, argA.length() - i - 1));
                sb.append(sbPart.reverse().toString());
                break;
            }

        }
        if(memory == 1) {
            sb.append(1);
        }

        return sb.reverse().toString();
    }
}
