package by.halatsevich.array.task1.parser;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to parse string data
 *
 * @author Vladislav Halatsevich
 */
public class DataParser {
    private static final String REGEXP_DIGIT = "\\d+";

    /**
     * Parse all data to list of integers
     *
     * @param dataToParse list of strings
     * @return parsed list of integers
     */
    public List<Integer> parseAllData(List<String> dataToParse) {
        List<Integer> parsedData = new ArrayList<>();
        for (String data : dataToParse) {
            if (data.matches(REGEXP_DIGIT)) {
                parsedData.add(Integer.parseInt(data));
            }
        }
        return parsedData;
    }
}
