package by.halatsevich.jaggedarray.service;

import by.halatsevich.jaggedarray.entity.SortParameter;
import by.halatsevich.jaggedarray.entity.TypeSort;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class JaggedArraySortServiceTest {
    JaggedArraySortService sortService;
    int[][] array;

    @BeforeClass
    public void setUp() {
        sortService = new JaggedArraySortService();
        array = new int[][]{
                {4, 85, -5, 1},
                {576, 4, 1, -4, 123, 6},
                {1, 124, 6},
                {1, 123, 6, 13, 76, 3, -56}};
    }

    @Test
    public void testBubbleAscendingSortSuccess() {
        int[][] actual = sortService.bubbleSort(array, SortParameter.SUM, TypeSort.ASCENDING);
        int[][] expected = new int[][]{
                {4, 85, -5, 1},
                {1, 124, 6},
                {1, 123, 6, 13, 76, 3, -56},
                {576, 4, 1, -4, 123, 6}};
        assertEquals(actual, expected);
    }

    @Test
    public void testBubbleAscendingSortFailure() {
        int[][] actual = sortService.bubbleSort(array, SortParameter.SUM, TypeSort.ASCENDING);
        int[][] expected = new int[][]{
                {1, 123, 6, 13, 76, 3, -56},
                {4, 85, -5, 1},
                {1, 124, 6},
                {576, 4, 1, -4, 123, 6}};
        assertNotEquals(actual, expected);
    }

    @Test
    public void testBubbleDescendingSortSuccess() {
        int[][] actual = sortService.bubbleSort(array, SortParameter.MIN, TypeSort.DESCENDING);
        int[][] expected = new int[][]{
                {1, 124, 6},
                {576, 4, 1, -4, 123, 6},
                {4, 85, -5, 1},
                {1, 123, 6, 13, 76, 3, -56}};
        assertEquals(actual, expected);
    }

    @Test
    public void testBubbleDescendingSortFailure() {
        int[][] actual = sortService.bubbleSort(array, SortParameter.MIN, TypeSort.DESCENDING);
        int[][] expected = new int[][]{
                {1, 123, 6, 13, 76, 3, -56},
                {4, 85, -5, 1},
                {576, 4, 1, -4, 123, 6},
                {1, 124, 6}};
        assertNotEquals(actual, expected);
    }

    @Test
    public void testBubbleSortByMaxInRowSuccess() {
        int[][] actual = sortService.bubbleSort(array, SortParameter.MAX, TypeSort.ASCENDING);
        int[][] expected = new int[][]{
                {4, 85, -5, 1},
                {1, 123, 6, 13, 76, 3, -56},
                {1, 124, 6},
                {576, 4, 1, -4, 123, 6}};
        assertEquals(actual, expected);
    }

    @Test
    public void testBubbleSortByMaxInRowFailure() {
        int[][] actual = sortService.bubbleSort(array, SortParameter.MAX, TypeSort.ASCENDING);
        int[][] expected = new int[][]{
                {1, 124, 6},
                {4, 85, -5, 1},
                {1, 123, 6, 13, 76, 3, -56},
                {576, 4, 1, -4, 123, 6}};
        assertNotEquals(actual, expected);
    }

    @Test
    public void testBubbleSortByMinInRowSuccess() {
        int[][] actual = sortService.bubbleSort(array, SortParameter.MIN, TypeSort.ASCENDING);
        int[][] expected = new int[][]{
                {1, 123, 6, 13, 76, 3, -56},
                {4, 85, -5, 1},
                {576, 4, 1, -4, 123, 6},
                {1, 124, 6}};
        assertEquals(actual, expected);
    }

    @Test
    public void testBubbleSortByMinInRowFailure() {
        int[][] actual = sortService.bubbleSort(array, SortParameter.MIN, TypeSort.ASCENDING);
        int[][] expected = new int[][]{
                {1, 124, 6},
                {4, 85, -5, 1},
                {1, 123, 6, 13, 76, 3, -56},
                {576, 4, 1, -4, 123, 6}};
        assertNotEquals(actual, expected);
    }

    @Test
    public void testBubbleSortBySumInRowSuccess() {
        int[][] actual = sortService.bubbleSort(array, SortParameter.SUM, TypeSort.ASCENDING);
        int[][] expected = new int[][]{
                {4, 85, -5, 1},
                {1, 124, 6},
                {1, 123, 6, 13, 76, 3, -56},
                {576, 4, 1, -4, 123, 6}};
        assertEquals(actual, expected);
    }

    @Test
    public void testBubbleSortBySumInRowFailure() {
        int[][] actual = sortService.bubbleSort(array, SortParameter.MAX, TypeSort.ASCENDING);
        int[][] expected = new int[][]{
                {1, 124, 6},
                {4, 85, -5, 1},
                {1, 123, 6, 13, 76, 3, -56},
                {576, 4, 1, -4, 123, 6}};
        assertNotEquals(actual, expected);
    }
}