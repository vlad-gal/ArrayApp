package by.halatsevich.array.creator;

import by.halatsevich.array.entity.CustomArray;
import by.halatsevich.array.exception.InputDataException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArrayCreatorTest {
    ArrayCreator creator;
    int[] dataToArrays;

    @BeforeClass
    public void setUp() {
        creator = new ArrayCreator();
        dataToArrays = new int[]{2, 13, 5, 7};
    }

    @Test
    public void testCreateArraySuccess() {
        try {
            CustomArray actual = creator.createArray(dataToArrays);
            CustomArray expected = new CustomArray(new int[]{2, 13, 5, 7});
            assertEquals(actual, expected);
        } catch (InputDataException e) {
            fail("Something goes wrong");
        }
    }

    @Test
    public void testCreateArrayFailure() {
        try {
            CustomArray actual = creator.createArray(dataToArrays);
            CustomArray expected = new CustomArray(new int[]{13, 5, 7});
            assertNotEquals(actual, expected);
        } catch (InputDataException e) {
            fail("Something goes wrong");
        }
    }

    @Test(expectedExceptions = InputDataException.class,
            expectedExceptionsMessageRegExp = "Data to create array are null")
    public void testCreateArrayExceptionMessage() throws InputDataException {
        creator.createArray(null);
    }

    @Test
    public void testCreateRandomArraySizeSuccess() {
        try {
            CustomArray array = creator.createRandomArray(4, 8);
            boolean condition = array.getSize() == 4;
            assertTrue(condition);
        } catch (InputDataException e) {
            fail("Something goes wrong");
        }
    }

    @Test
    public void testCreateRandomArraySizeFailure() {
        try {
            CustomArray array = creator.createRandomArray(4, 4);
            boolean condition = array.getSize() == 3;
            assertFalse(condition);
        } catch (InputDataException e) {
            fail("Something goes wrong");
        }
    }

    @Test
    public void testCreateRandomArrayAllValuesBetweenSuccess() {
        try {
            CustomArray array = creator.createRandomArray(4, 8);
            boolean[] actual = new boolean[array.getSize()];
            for (int i = 0; i < array.getSize(); i++) {
                actual[i] = (array.getElement(i) >= 0 && array.getElement(i) < 8);
            }
            boolean[] expected = {true, true, true, true};
            assertEquals(actual, expected);
        } catch (InputDataException e) {
            fail("Something goes wrong");
        }
    }

    @Test
    public void testCreateRandomArrayAllValuesBetweenFailure() {
        try {
            CustomArray array = creator.createRandomArray(4, 8);
            boolean[] actual = new boolean[array.getSize()];
            for (int i = 0; i < array.getSize(); i++) {
                actual[i] = (array.getElement(i) >= 0 && array.getElement(i) < 8);
            }
            boolean[] expected = {false, false, true, true};
            assertNotEquals(actual, expected);
        } catch (InputDataException e) {
            fail("Something goes wrong");
        }
    }

    @Test(expectedExceptions = InputDataException.class,
            expectedExceptionsMessageRegExp = "Size of array is less then 0")
    public void testCreateRandomArraySizeExceptionMessage() throws InputDataException {
        creator.createRandomArray(-46, 55);
    }
}