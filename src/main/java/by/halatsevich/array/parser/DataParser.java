package by.halatsevich.array.parser;

/**
 * Class to parse string data
 *
 * @author Vladislav Halatsevich
 */
public class DataParser {
    private static final String REGEXP_DIGIT = "-?\\d+";

    /**
     * Parse all data to array of integers
     *
     * @param dataToParse array of strings
     * @return parsed array of integers
     */
    public int[] parseAllData(String[] dataToParse) {
        int size = 0;
        for (String data : dataToParse) {
            if (data.matches(REGEXP_DIGIT)) {
                size++;
            }
        }
        int[] parsedData = new int[size];
        int index = 0;
        for (String data : dataToParse) {
            if (data.matches(REGEXP_DIGIT)) {
                parsedData[index] = Integer.parseInt(data);
                index++;
            }
        }
        return parsedData;
    }
}
