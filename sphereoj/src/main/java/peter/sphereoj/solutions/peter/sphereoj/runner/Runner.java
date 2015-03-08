package peter.sphereoj.solutions.peter.sphereoj.runner;

import peter.sphereoj.solutions.*;

import java.io.IOException;

/**
 * Created by Piotr Kulma on 26.02.15.
 */
public class Runner {
    public static String DATA_FILE_NAME = "Problem6.txt";

    public static void main(String... args) throws IOException {

        System.setIn(Runner.class.getClassLoader().getResourceAsStream(DATA_FILE_NAME));
        Problem6.main(null);
    }
}
