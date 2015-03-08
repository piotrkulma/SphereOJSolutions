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

/*    private void runTest() throws IOException {
        String line;

        while(true) {
            int r = (int)(Math.random() * 12) + 1;
            line = randomString(r);
            String a = findNextPalindromeNaive(line);
            String b = findNextPalindrome(line);

            if(!a.equals(b)) {
                System.out.println(a + " not eq " + b + " -> " + line);
                break;
            } else {
                System.out.println(line + " OK");
            }
        }
    }

    private String findNextPalindromeNaive(String text) {
        String pal = inc(text);
        while(!isPalindrome(pal)) {
            pal = inc(pal);
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

    private final String AB = "0123456789";
    private Random rnd = new Random();

    private String randomString( int len ) {
        StringBuilder sb = new StringBuilder( len );
        for( int i = 0; i < len; i++ )
            sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
        return sb.toString();
    }*/

    private boolean consistsOf(String s, char c) {
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) != c) {
                return false;
            }
        }

        return true;
    }

    private String findNextPalindrome(String text) {
        if(consistsOf(text,'9')) {
            return add(text, "2");
        }

        StringBuffer sb = new StringBuffer("");
        if(text.length() % 2 != 0) {
            int mediumIndex = (text.length() / 2) + 1;

            String firstPart = text.substring(0, mediumIndex - 1);
            String secondPart = text.substring(mediumIndex, text.length());
            String mediumPart = text.substring(mediumIndex - 1, mediumIndex);

            String reversedFirstPart = reverseString(firstPart);

            int cmp = compareNumberValues(reversedFirstPart, secondPart);

            if(cmp > 0) {
                sb.append(firstPart);
                sb.append(mediumPart);
                sb.append(reversedFirstPart);
            } else {
                if (compareNumberValues(mediumPart, "9") < 0) {
                    sb.append(firstPart);
                    sb.append(inc(mediumPart));
                    sb.append(reverseString(firstPart));
                } else {
                    firstPart = inc(firstPart);
                    sb.append(firstPart);
                    sb.append("0");
                    sb.append(reverseString(firstPart));
                }
            }

            return sb.toString();
        } else {
            int mediumIndex = (text.length() / 2);

            String firstPart = text.substring(0, mediumIndex);
            String secondPart = text.substring(mediumIndex, text.length());
            String reversedFirstPart = reverseString(firstPart);

            int cmp = compareNumberValues(reversedFirstPart, secondPart);

            if(cmp > 0) {
                sb.append(firstPart);
                sb.append(reversedFirstPart);
            } else if(cmp < 0) {
                firstPart = inc(firstPart);
                sb.append(firstPart);
                sb.append(reverseString(firstPart));
            } else {
                firstPart = inc(firstPart);
                sb.append(firstPart);
                sb.append(reverseString(firstPart));
            }
            return sb.toString();
        }
    }

    private String reverseString(String string) {
        StringBuffer buffer = new StringBuffer("");

        for(int i=0; i<string.length(); i++) {
            buffer.append(string.charAt(string.length() - i - 1));
        }

        return buffer.toString();
    }

    private String inc(String argA) {
        return add(argA, "1");
    }

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
}
