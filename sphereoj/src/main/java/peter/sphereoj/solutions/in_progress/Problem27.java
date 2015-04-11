package peter.sphereoj.solutions.in_progress;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by Piotr Kulma on 11.04.15.
 *
 * Status: in progress
 */
public class Problem27 {
    public static final String STRING_NEW_LINE  = "\r\n";
    public static final String STRING_SPACE     = " ";
    public static final String STRING_EMPTY     = "";

    private TreeMap<String, Integer> accounts;

    public static void main(String[] args) throws IOException {
        new Problem27().runSolution();
    }

    private Problem27() {
        accounts = new TreeMap<String, Integer>();
    }

    private void runSolution() throws IOException {
        String line;
        InputStream in = System.in;
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        int accounts;
        int testCases = Integer.parseInt(reader.readLine());

        for(int i=0; i<testCases; i++) {
            line = reader.readLine();
            accounts = Integer.parseInt(line);

            initTestCase();
            for(int j=0; j<accounts; j++) {
                line = reader.readLine();
                processAccount(line);
            }
            reader.readLine();
            showAccounts();
        }
    }

    private void processAccount(String account) {
        Integer value = accounts.get(account);

        if(value == null) {
            accounts.put(account, 1);
        } else {
            accounts.put(account, ++value);
        }
    }

    private void showAccounts() {
        Set<Map.Entry<String,Integer>> entries = accounts.entrySet();
        StringBuilder builder = new StringBuilder(STRING_EMPTY);

        for(Map.Entry<String,Integer> entry : entries) {
            builder.append(entry.getKey());
            builder.append(STRING_SPACE);
            builder.append(entry.getValue());
            builder.append(STRING_NEW_LINE);
        }
        builder.append(STRING_NEW_LINE);
        System.out.print(builder.toString());
    }

    private void initTestCase() {
        accounts.clear();
    }
}
