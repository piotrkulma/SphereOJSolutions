package peter.sphereoj.solutions.peter.sphereoj.runner;


import peter.sphereoj.solutions.solved.Problem31;

/**
 * Created by Piotr Kulma on 26.02.15.
 */
public class Runner {
    public static String DATA_FILE_NAME = "Problem31.txt";

    public static void main(String... args) throws Exception {

        System.setIn(Runner.class.getClassLoader().getResourceAsStream(DATA_FILE_NAME));
        Problem31.main(null);
    }
}
