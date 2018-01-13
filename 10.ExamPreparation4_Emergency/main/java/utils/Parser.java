package utils;

import java.util.List;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public interface Parser {
    List<String> parseInput(String inputLine);

    String[] parseInputAsArray(String inputLine);
}
