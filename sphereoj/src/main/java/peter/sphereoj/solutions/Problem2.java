package peter.sphereoj.solutions;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Piotr Kulma on 26.02.15.
 */
public class Problem2 {
    private final static int ARRAY_SIZE = 31634;

    private boolean[] primeTestArray;
    private int[] primeArray;

    public static void main(String[] args) {
        try {
            new Problem2().runSolution();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void runSolution() throws Exception {
        initArray();
        fillErastotenes();

        String line;
        InputStream in = System.in;
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        int actualCount = 0;
        int dataCount = Integer.parseInt(reader.readLine());

        while((line = reader.readLine()) != null) {
            String[] range = line.split(" ");
            int first = Integer.parseInt(range[0]);
            int last = Integer.parseInt(range[1]);
            if(printPrimesInRange(first, last)) {
                if (actualCount < dataCount) {
                    System.out.println("");
                    System.out.println("");
                }
            }
            actualCount++;
        }
    }

    private void initArray() {
        primeTestArray = new boolean[ARRAY_SIZE];
        primeArray = new int[ARRAY_SIZE];

        for(int i=0; i<ARRAY_SIZE; i++) {
            primeTestArray[i] = true;
        }

        primeTestArray[0] = false;
        primeTestArray[1] = false;
    }

    private void fillErastotenes() {
        int counter, p;

        for(int i=0; i<ARRAY_SIZE; i++) {
            if(primeTestArray[i]) {
                counter = 2;
                while ((p = counter++ * i) < ARRAY_SIZE) {
                    primeTestArray[p] = false;
                }
            }
        }

        counter = 0;
        for(int i=0; i< ARRAY_SIZE; i++) {
            primeArray[i] = 0;
            if (primeTestArray[i]) {
                primeArray[counter++] = i;
            }
        }
    }

    private boolean isPrime(int num) {
        if(num < 2) {
            return false;
        } else {
            for (int i = 0; i < ARRAY_SIZE; i++) {
                if (primeArray[i] != 0) {
                    if (num == primeArray[i]) {
                        return true;
                    } else if (num % primeArray[i] == 0) {
                        return false;
                    }
                } else {
                    return true;
                }
            }

            return true;
        }
    }

    private boolean printPrimesInRange(int first, int last) throws Exception {
        boolean print = false;

        if(last < ARRAY_SIZE ) {
            for(int i=first; i<=last; i++) {
                if(primeTestArray[i]) {
                    System.out.println(i);
                    print=true;
                }
            }
        } else {
            for(int i=first; i<=last; i++) {
                if(i < ARRAY_SIZE ) {
                    if(primeTestArray[i]) {
                        System.out.println(i);
                        print = true;
                    }
                } else {
                    if (isPrime(i)) {
                        System.out.println(i);
                        print = true;
                    }
                }
            }
        }
        return print;
    }
}
