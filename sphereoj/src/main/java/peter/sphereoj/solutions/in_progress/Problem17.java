package peter.sphereoj.solutions.in_progress;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by Piotr Kulma on 08.03.15.
 */
public class Problem17 {
    private final long DIV = 4000000007l;

    public static void main(String[] args) throws Exception {
        new Problem17().runSolution();
    }

    private void runSolution() throws IOException, ParseException {
        String line;
        InputStream in = System.in;
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        while((line = reader.readLine()) != null) {
            decode(line);
        }
    }

    private void decode(String code) throws ParseException {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        calendar.clear();
        calendar.set(2004, Calendar.JUNE, 13, 16, 20, 39);
        long sec = calendar.getTimeInMillis() / 1000L;
        sec = sec * sec;
        sec = sec / 4000000007l;

        System.out.println(sec + " " + calendar);

        SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd HH:mm:ss yyyy", Locale.US);
        Date date = format.parse("Sun Jun 13 16:20:39 2004");

        long millis = date.getTime();
        long seconds = millis / 1000L;
        long enc = (seconds * seconds) / 4000000007l;
        System.out.println(enc);

    }
}
