package by.halatsevich.array.task1.reader;

import by.halatsevich.array.task1.exception.InputDataException;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Data reader from file and console
 *
 * @author Vladislav Halatsevich
 */
public class DataReader {
    private static final InputStream DEFAULT_INPUT = System.in;

    /**
     * Read all data from file
     *
     * @param filePath path to exist file
     * @return list of strings
     * @throws InputDataException if filePath is directory or file doesn't exist
     */
    public List<String> readDataFromFile(String filePath) throws InputDataException {
        Path path = Paths.get(filePath);
        if (Files.isDirectory(path) || !Files.exists(path)) {
            throw new InputDataException("The file doesn't exist");
        }
        List<String> data;
        try {
            data = Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException("Error while opening file", e);
        }
        return data;
    }

    /**
     * Read all data from console
     *
     * @param input input stream to be scanned
     * @return list of integers
     */
    public List<Integer> readDataFromConsole(InputStream input) {
        if (input == null) {
            input = DEFAULT_INPUT;
        }
        Scanner scanner = new Scanner(input);
        List<Integer> data = new ArrayList<>();
        while (scanner.hasNextInt()) {
            data.add(scanner.nextInt());
        }
        scanner.close();
        return data;
    }
}
