package by.halatsevich.array.creator;

import by.halatsevich.array.entity.CustomArray;
import by.halatsevich.array.exception.InputDataException;

import java.util.Random;

/**
 * Class for creating CustomArray in different ways
 *
 * @author Vladislav Halatsevich
 */
public class ArrayCreator {

    /**
     * Create CustomArray from data obtained from file or console
     *
     * @param data array of data to create CustomArray
     * @return CustomArray
     * @throws InputDataException if data to create array are null
     */
    public CustomArray createArray(int[] data) throws InputDataException {
        if (data == null) {
            throw new InputDataException("Data to create array are null");
        }
        int size = data.length;
        CustomArray array = new CustomArray(size);
        for (int i = 0; i < size; i++) {
            int value = data[i];
            array.setElement(i, value);
        }
        return array;
    }

    /**
     * Create CustomArray with random data
     *
     * @param size             define size of CustomArray
     * @param randomMultiplier define random coefficient
     * @return CustomArray
     * @throws InputDataException if size of array is less than 0
     */
    public CustomArray createRandomArray(int size, int randomMultiplier) throws InputDataException {
        if (size < 0) {
            throw new InputDataException("Size of array is less then 0");
        }
        CustomArray array = new CustomArray(size);
        Random generator = new Random();
        for (int i = 0; i < size; i++) {
            array.setElement(i, generator.nextInt(randomMultiplier));
        }
        return array;
    }
}
