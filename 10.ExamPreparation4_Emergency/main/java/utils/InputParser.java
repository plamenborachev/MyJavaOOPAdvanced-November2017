package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputParser implements Parser {
    private static final String DELIMITER = "\\|";

    public InputParser() {
    }

    @Override
    public List<String> parseInput(String inputLine) {
        return new ArrayList<>(Arrays.asList(inputLine.split(DELIMITER)));
    }

    @Override
    public String[] parseInputAsArray(String inputLine) {
        return inputLine.split(DELIMITER);
    }

}
