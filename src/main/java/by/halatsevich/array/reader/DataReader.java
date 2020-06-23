package by.halatsevich.array.reader;

import by.halatsevich.array.exception.InputDataException;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Data reader from file and console
 *
 * @author Vladislav Halatsevich
 */
public class DataReader {
    private static final InputStream DEFAULT_INPUT = System.in;
    private static final String DEFAULT_PATH = "src/main/resources/data/input.txt";

    /**
     * Read all data from file
     *
     * @param filePath path to exist file
     * @return array of strings
     */
    public String[] readDataFromFile(String filePath) {
        Path path = Paths.get(filePath);
        if (Files.isDirectory(path) || !Files.exists(path)) {
            path = Paths.get(DEFAULT_PATH);
        }
        String[] data;
        try {
            int size = Files.readAllLines(path).size();
            data = new String[size];
            for (int i = 0; i < size; i++) {
                data[i] = Files.readAllLines(path).get(i);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error while opening file", e);
        }
        return data;
    }

    /**
     * Read all data from console
     *
     * @param input input stream to be scanned
     * @return array of strings
     * @throws InputDataException if size of array is less than 0
     */
    public String[] readDataFromConsole(InputStream input) throws InputDataException {
        if (input == null) {
            input = DEFAULT_INPUT;
        }
        Scanner scanner = new Scanner(input);
        System.out.print("Enter size of array: ");
        int size = scanner.nextInt();
        if (size < 0) {
            throw new InputDataException("Size of array is less than 0");
        }
        String[] data = new String[size];
        for (int i = 0; i < size; i++) {
            data[i] = scanner.next();
        }
        scanner.close();
        return data;
    }
}
