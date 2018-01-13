package logger.utils;

import logger.contracts.IInputParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputParser implements IInputParser {
    private static final String SPACE_DELIMITER = "\\s+";
    private static final String LINE_DELIMITER = "\\|";

    public InputParser() {
    }

    public List<String> parseInput(String inputLine) {
        return new ArrayList<>(Arrays.asList(inputLine.split(LINE_DELIMITER)));
    }

    public String[] parseInputAsArray(String inputLine) {
        return inputLine.split(SPACE_DELIMITER);
    }

}