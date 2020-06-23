package by.halatsevich.array.service;

import by.halatsevich.array.entity.CustomArray;
import by.halatsevich.array.exception.InputDataException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SearchServiceTest {
    SearchService searchService;
    CustomArray array;
    CustomArray sortedArray;

    @BeforeClass
    public void setUp() throws InputDataException {
        searchService = new SearchService();
        array = new CustomArray(new int[]{1, 3, 5, -54, 78, 77, 953, 123});
        sortedArray = new CustomArray(new int[]{-54, 1, 3, 5, 77, 78, 123, 953});
    }

    @Test
    public void testBinarySearchFoundKeySuccess() {
        try {
            int actual = searchService.binarySearch(sortedArray, 5);
            int expected = 3;
            assertEquals(actual, expected);
        } catch (InputDataException e) {
            fail("Something goes wrong");
        }
    }

    @Test
    public void testBinarySearchNotFoundKeySuccess() {
        try {
            int actual = searchService.binarySearch(sortedArray, -4);
            int expected = -2;
            assertEquals(actual, expected);
        } catch (InputDataException e) {
            fail("Something goes wrong");
        }
    }

    @Test
    public void testBinarySearchFailure() {
        try {
            int actual = searchService.binarySearch(sortedArray, -4);
            int expected = 0;
            assertNotEquals(actual, expected);
        } catch (InputDataException e) {
            fail("Something goes wrong");
        }
    }

    @Test(expectedExceptions = InputDataException.class,
            expectedExceptionsMessageRegExp = "Array is not sorted")
    public void testBinarySearchSortedArrayExceptionMessage() throws InputDataException {
        searchService.binarySearch(array, 1);
    }

    @Test
    public void testFindMinElementSuccess() {
        try {
            int actual = searchService.findMinElement(array);
            int expected = -54;
            assertEquals(actual, expected);
        } catch (InputDataException e) {
            fail("Something goes wrong");
        }
    }

    @Test
    public void testFindMinElementFailure() {
        try {
            int actual = searchService.findMinElement(array);
            int expected = 1;
            assertNotEquals(actual, expected);
        } catch (InputDataException e) {
            fail("Something goes wrong");
        }
    }

    @Test
    public void testFindMaxElementSuccess() {
        try {
            int actual = searchService.findMaxElement(array);
            int expected = 953;
            assertEquals(actual, expected);
        } catch (InputDataException e) {
            fail("Something goes wrong");
        }
    }

    @Test
    public void testFindMaxElementFailure() {
        try {
            int actual = searchService.findMaxElement(array);
            int expected = 1;
            assertNotEquals(actual, expected);
        } catch (InputDataException e) {
            fail("Something goes wrong");
        }
    }

    @Test
    public void testFindAllSimpleNumbersSuccess() {
        try {
            CustomArray actual = searchService.findAllSimpleNumbers(array);
            CustomArray expected = new CustomArray(new int[]{1, 3, 5, 953});
            assertEquals(actual, expected);
        } catch (InputDataException e) {
            fail("Something goes wrong");
        }
    }

    @Test
    public void testFindAllSimpleNumbersFailure() {
        try {
            CustomArray actual = searchService.findAllSimpleNumbers(array);
            CustomArray expected = new CustomArray(new int[]{1, 3, 5});
            assertNotEquals(actual, expected);
        } catch (InputDataException e) {
            fail("Something goes wrong");
        }
    }

    @Test
    public void testFindAllFibonacciNumbersSuccess() {
        try {
            CustomArray actual = searchService.findAllFibonacciNumbers(array);
            CustomArray expected = new CustomArray(new int[]{1, 3, 5});
            assertEquals(actual, expected);
        } catch (InputDataException e) {
            fail("Something goes wrong");
        }
    }

    @Test
    public void testFindAllFibonacciNumbersFailure() {
        try {
            CustomArray actual = searchService.findAllFibonacciNumbers(array);
            CustomArray expected = new CustomArray(new int[]{5});
            assertNotEquals(actual, expected);
        } catch (InputDataException e) {
            fail("Something goes wrong");
        }
    }

    @Test
    public void testFindAllTripleWithoutIdenticalDigitsSuccess() {
        try {
            CustomArray actual = searchService.findAllTripleWithoutIdenticalDigits(array);
            CustomArray expected = new CustomArray(new int[]{953, 123});
            assertEquals(actual, expected);
        } catch (InputDataException e) {
            fail("Something goes wrong");
        }
    }

    @Test
    public void testFindAllTripleWithoutIdenticalDigitsFailure() {
        try {
            CustomArray actual = searchService.findAllTripleWithoutIdenticalDigits(array);
            CustomArray expected = new CustomArray(new int[]{123});
            assertNotEquals(actual, expected);
        } catch (InputDataException e) {
            fail("Something goes wrong");
        }
    }
}