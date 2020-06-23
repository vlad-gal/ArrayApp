package by.halatsevich.array.service;

import by.halatsevich.array.entity.CustomArray;
import by.halatsevich.array.exception.InputDataException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SortServiceTest {
    SortService sortService;
    CustomArray array;
    CustomArray expectedSortedArray;

    @BeforeClass
    public void setUp() {
        sortService = new SortService();
        array = new CustomArray(new int[]{1, 3, 5, -54, 78, 77, 953, 123});
        expectedSortedArray = new CustomArray(new int[]{-54, 1, 3, 5, 77, 78, 123, 953});
    }

    @Test
    public void testBubbleSortSuccess() {
        try {
            CustomArray actual = sortService.bubbleSort(array);
            assertEquals(actual, expectedSortedArray);
        } catch (InputDataException e) {
            fail("Something goes wrong");
        }
    }

    @Test
    public void testBubbleSortFailure() {
        try {
            CustomArray actual = sortService.bubbleSort(array);
            CustomArray expected = new CustomArray(new int[]{1, 3, 5});
            assertNotEquals(actual, expected);
        } catch (InputDataException e) {
            fail("Something goes wrong");
        }
    }

    @Test
    public void testInsertSortSuccess() {
        try {
            CustomArray actual = sortService.insertSort(array);
            assertEquals(actual, expectedSortedArray);
        } catch (InputDataException e) {
            fail("Something goes wrong");
        }
    }

    @Test
    public void testInsertSortFailure() {
        try {
            CustomArray actual = sortService.insertSort(array);
            CustomArray expected = new CustomArray(new int[]{5, 3, 1});
            assertNotEquals(actual, expected);
        } catch (InputDataException e) {
            fail("Something goes wrong");
        }
    }

    @Test
    public void testSelectSortSuccess() {
        try {
            CustomArray actual = sortService.selectSort(array);
            assertEquals(actual, expectedSortedArray);
        } catch (InputDataException e) {
            fail("Something goes wrong");
        }
    }

    @Test
    public void testSelectSortFailure() {
        try {
            CustomArray actual = sortService.selectSort(array);
            CustomArray expected = new CustomArray(new int[]{33, 1});
            assertNotEquals(actual, expected);
        } catch (InputDataException e) {
            fail("Something goes wrong");
        }
    }
}