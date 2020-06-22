package by.halatsevich.array.task1.reader;

import by.halatsevich.array.task1.exception.InputDataException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class DataReaderTest {
    DataReader reader;
    static final String TEST_FILE = "src/main/resources/data/input.txt";

    @BeforeClass
    public void setUp() {
        reader = new DataReader();
    }

    @Test
    public void testReadDataFromFileSuccess() {
        try {
            List<String> actual = reader.readDataFromFile(TEST_FILE);
            List<String> expected = Arrays.asList("4", "654", "2", "8", "21", "7", "erwe", "2", "a");
            assertEquals(actual,expected);
        } catch (InputDataException e) {
            fail("Something goes wrong");
        }

    }

    @Test
    public void testReadDataFromFileFailure() {
        try {
            List<String> actual = reader.readDataFromFile(TEST_FILE);
            List<String> expected = Arrays.asList("4", "654", "2", "8", "21", "7", "2");
            assertNotEquals(actual,expected);
        } catch (InputDataException e) {
            fail("Something goes wrong");
        }
    }

    @Test(expectedExceptions = InputDataException.class,
            expectedExceptionsMessageRegExp = "The file doesn't exist")
    public void testReadDataFromFileExceptionMessage() throws InputDataException {
        reader.readDataFromFile("1");
    }

    // FIXME: 22.06.2020 как протестировать консоль
    @Test
    public void testReadDataFromConsoleSuccess() {
    }

    @Test
    public void testReadDataFromConsoleFailure() {
    }

}