package peter.sphereoj.solutions.solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Piotr Kulma on 10.04.15.
 *
 * Status: solved
 */
public class Problem29 {
    public static final int ELEMENTS            = 101;

    public static final int HASH_FACTOR         = 19;

    public static final String COMMAND_ADD      = "ADD";
    public static final String COMMAND_DEL      = "DEL";

    public static final String EMPTY_STRING     = "y7dgcduw99gddgf";
    public static final String DIVIDER_STRING   = ":";
    public static final String NEXT_LINE_STRING = "\r\n";

    public static final int INDEX_NOT_FOUND     = -1;

    private int elementsCounter;
    private String[] array;

    public static void main(String[] args) throws IOException {
        new Problem29().runSolution();
    }

    public Problem29() {
        array = new String[ELEMENTS];
    }

    private void runSolution() throws IOException {
        String line;
        String[] command;
        InputStream in = System.in;
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        int operations;
        int testCases = Integer.parseInt(reader.readLine());

        for(int i=0; i<testCases; i++) {
            line = reader.readLine();
            operations = Integer.parseInt(line);
            initArray();
            for(int j=0; j<operations; j++) {
                command = reader.readLine().split(DIVIDER_STRING);
                exec(command[0], command[1]);
            }
            showMemoryStatus();
        }
    }

    private void showMemoryStatus() {
        StringBuilder builder = new StringBuilder("");
        builder.append(elementsCounter);
        builder.append(NEXT_LINE_STRING);
        for(int i=0; i<ELEMENTS; i++) {
            if(!array[i].equals(EMPTY_STRING)) {
                builder.append(i);
                builder.append(DIVIDER_STRING);
                builder.append(array[i]);
                builder.append(NEXT_LINE_STRING);
            }
        }

        System.out.print(builder);
    }

    private void exec(String command, String value) {
        if(COMMAND_ADD.equals(command)) {
            insert(value);
        } else if(COMMAND_DEL.equals(command)) {
            delete(value);
        }
    }

    private void insert(String key) {
        int index = findIndex(key);

        if(index == INDEX_NOT_FOUND) {
            int newIndex = hash(key);

            if(EMPTY_STRING.equals(array[newIndex])) {
                array[newIndex] = key;
                elementsCounter++;
            } else {
                int h;
                for(int j=0; j<=19; j++) {
                    h = (newIndex + (j*j) + 23 * j) % ELEMENTS;

                    if(EMPTY_STRING.equals(array[h])) {
                        array[h] = key;
                        elementsCounter++;
                        break;
                    }
                }
            }
        }
    }

    private void delete(String key) {
        int index = findIndex(key);

        if(index != INDEX_NOT_FOUND) {
            array[index] = EMPTY_STRING;
            elementsCounter--;
        }
    }

    private int findIndex(String key) {
        for(int i=0; i<ELEMENTS; i++) {
            if(array[i].equals(key)) {
                return i;
            }
        }

        return INDEX_NOT_FOUND;
    }

    private int hash(String key) {
        return h(key) % ELEMENTS;
    }

    private int h(String key) {
        int h = 0;

        for(int i=0;i<key.length(); i++) {
            h += (key.charAt(i) * (i + 1));
        }

        return h * HASH_FACTOR;
    }

    private void initArray() {
        elementsCounter = 0;
        for(int i=0; i<array.length; i++) {
            array[i] = EMPTY_STRING;
        }
    }
}
