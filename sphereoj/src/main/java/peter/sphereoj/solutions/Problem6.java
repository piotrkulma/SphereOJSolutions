package peter.sphereoj.solutions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Piotr Kulma on 08.03.15.
 */
public class Problem6 {
    private final String NEXT_LINE = "\r\n";

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

            if(line.contains("+")) {
                printAdd(arguments[0], arguments[1]);
            } else {
                printSub(arguments[0], arguments[1]);
            }

            System.out.println();

        }
    }

    private void printAdd(String a, String b) {
        String result;
        int cmp = compareNumberValues(a, b);

        StringBuffer sb = new StringBuffer("");
        if(cmp>0) {
            result = add(a, b);
        } else {
            result = add(b, a);
        }

        sb.append(a);sb.append(NEXT_LINE);
        sb.append("+");
        sb.append(b);sb.append(NEXT_LINE);
        sb.append("--");sb.append(NEXT_LINE);
        sb.append(result);
        System.out.println(sb.toString());
    }

    private void printSub(String a, String b) {
        String result = sub(a, b);
        StringBuffer sb = new StringBuffer("");

        sb.append(a);sb.append(NEXT_LINE);
        sb.append("-");
        sb.append(b);sb.append(NEXT_LINE);
        sb.append("--");sb.append(NEXT_LINE);
        sb.append(result);
        System.out.println(sb.toString());
    }

/*
    private void performOeration(String operator, String argA, String argB) {
        int cmp = compareNumberValues(argA, argB);

        if(cmp>0) {
            chooseOperation(operator, argA, argB);
        } else {
            chooseOperation(operator, argB, argA);
        }
    }*/

    private int compareNumberValues(String a, String b) {
        if(a.length() > b.length()) {
            return 1;
        } else if(a.length()< b.length()) {
            return -1;
        } else {
            for (int i = 0; i < a.length(); i++) {
                int valA = (int) a.charAt(i) - 48;
                int valB = (int) b.charAt(i) - 48;

                if(valA != valB) {
                    return valA-valB;
                }
            }

            return 0;
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

    private String sub(String argA, String argB) {
        char a, b;

        int loan=0;
        int partialSum;
        int bLen = argB.length();

        int intA, intB;

        StringBuffer sb = new StringBuffer("");

        for(int i=0; i< argA.length(); i++) {
            a = argA.charAt(argA.length() - i - 1);
            if(bLen - i - 1 >= 0) {
                b = argB.charAt(argB.length() - i - 1);
            } else {
                b = '0';
            }

            intA = ((int)a - 48);
            intB = ((int)b - 48);

            if(loan > 0) {
                intA = intA - loan;
                loan = 0;
            }

            if(intA < intB) {
                intA = 10 + intA;
                loan = 1;
            }

            partialSum = intA - intB;
            sb.append(partialSum);
        }

        return sb.reverse().toString();
    }
}
