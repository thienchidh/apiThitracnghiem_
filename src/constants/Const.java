package constants;

import io.ConfigReader;

public class Const {
    public static final String INPUT_JAR_PATH = new ConfigReader().readFileAsString("INPUT_JAR_PATH.txt").trim();
}
