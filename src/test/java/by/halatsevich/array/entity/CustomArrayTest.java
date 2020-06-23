package by.halatsevich.array.entity;

import by.halatsevich.array.exception.InputDataException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CustomArrayTest {
    CustomArray array;

    @BeforeMethod
    public void setUp() throws Exception {
        array = new CustomArray(new int[]{4, -48, 689, 1});
    }

    @AfterMethod
    public void tearDown() throws Exception {
        array = null;
    }

    @Test
    public void testGetElementSuccess() {
        try {
            int actual = array.getElement(0);
            int expected = 4;
            assertEquals(actual, expected);
        } catch (InputDataException e) {
            fail("Something goes wrong");
        }
    }

    @Test
    public void testGetElementFailure() throws Exception {
        try {
            int actual = array.getElement(1);
            int expected = 78;
            assertNotEquals(actual, expected);
        } catch (InputDataException e) {
            fail("Something goes wrong");
        }
    }

    @Test(expectedExceptions = InputDataException.class,
            expectedExceptionsMessageRegExp = "Index of element: -45, but size of array: 4")
    public void testGetElementExceptionMessage() throws InputDataException {
        array.getElement(-45);
    }

    @Test
    public void testSetElementSuccess() {
        try {
            int actual = array.setElement(0, 45);
            int expected = 4;
            assertEquals(actual, expected);
        } catch (InputDataException e) {
            fail("Something goes wrong");
        }
    }

    @Test
    public void testSetElementFailure() {
        try {
            int actual = array.setElement(0, 45);
            int expected = 45;
            assertNotEquals(actual, expected);
        } catch (InputDataException e) {
            fail("Something goes wrong");
        }
    }

    @Test(expectedExceptions = InputDataException.class,
            expectedExceptionsMessageRegExp = "Index of element: 98, but size of array: 4")
    public void testSetElementExceptionMessage() throws InputDataException {
        array.setElement(98, 3);
    }

}