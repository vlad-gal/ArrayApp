package by.halatsevich.array.task1.parser;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class DataParserTest {
    DataParser parser;
    List<String> dataToParse;
    @BeforeClass
    public void setUp() throws Exception {
        parser = new DataParser();
        dataToParse = Arrays.asList("1,3","3","a0","df","87");
    }

    @Test
    public void testParseAllDataSuccess() throws Exception {
        List<Integer> actual = parser.parseAllData(dataToParse);
        List<Integer> expected = Arrays.asList(3,87);
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void testParseAllDataFailure() throws Exception {
        List<Integer> actual = parser.parseAllData(dataToParse);
        List<Integer> expected = Arrays.asList(4,87);
        Assert.assertNotEquals(actual,expected);
    }

}