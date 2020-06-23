package by.halatsevich.array.parser;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class DataParserTest {
    DataParser parser;
    String[] dataToParse;

    @BeforeClass
    public void setUp() {
        parser = new DataParser();
        dataToParse = new String[]{"1,3", "3", "a0", "df", "87"};
    }

    @Test
    public void testParseAllDataSuccess() {
        int[] actual = parser.parseAllData(dataToParse);
        int[] expected = {3, 87};
        assertEquals(actual, expected);
    }

    @Test
    public void testParseAllDataFailure() {
        int[] actual = parser.parseAllData(dataToParse);
        int[] expected = {4, 87};
        assertNotEquals(actual, expected);
    }
}