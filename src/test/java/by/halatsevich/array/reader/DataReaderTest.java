package by.halatsevich.array.reader;

import by.halatsevich.array.exception.InputDataException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class DataReaderTest {
    DataReader reader;
    static final String TEST_FILE = "resources/data/input.txt";

    @BeforeClass
    public void setUp() {
        reader = new DataReader();
    }

    @Test
    public void testReadDataFromFileSuccess() {
        String[] actual = reader.readDataFromFile(TEST_FILE);
        String[] expected = {"4", "654", "2", "8", "21", "7", "erwe", "2", "a", "-4"};
        assertEquals(actual, expected);
    }

    @Test
    public void testReadDataFromFileFailure() {
        String[] actual = reader.readDataFromFile(TEST_FILE);
        List<String> expected = Arrays.asList("4", "654", "2", "8", "21", "7", "2");
        assertNotEquals(actual, expected);
    }

    @Test
    public void testReadDataFromFileDefaultFile() {
        String[] actual = reader.readDataFromFile("1");
        List<String> expected = Arrays.asList("4", "654", "2", "8", "21", "7", "2", "-4");
        assertNotEquals(actual, expected);
    }

    @Test
    public void testReadDataFromConsoleSuccess() {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("5 4 5 asd 7 8".getBytes());
            String[] actual = reader.readDataFromConsole(byteArrayInputStream);
            String[] expected = {"4", "5", "asd", "7", "8"};
            assertEquals(actual, expected);
        } catch (InputDataException e) {
            fail("Something goes wrong");
        }
    }

    @Test
    public void testReadDataFromConsoleFailure() {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("4 4 5 asd 7 4".getBytes());
            String[] actual = reader.readDataFromConsole(byteArrayInputStream);
            String[] expected = {"4", "5", "asd", "7", "4"};
            assertNotEquals(actual, expected);
        } catch (InputDataException e) {
            fail("Something goes wrong");
        }
    }

    @Test(expectedExceptions = InputDataException.class,
            expectedExceptionsMessageRegExp = "Size of array is less than 0")
    public void testReadDataFromConsoleExceptionMessage() throws InputDataException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("-4 44asd 7".getBytes());
        reader.readDataFromConsole(byteArrayInputStream);
    }
}