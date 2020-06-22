package by.halatsevich.array.task1.creator;

import by.halatsevich.array.task1.entity.CustomArray;
import by.halatsevich.array.task1.exception.InputDataException;

import java.util.List;

/**
 * Class for creating CustomArray in different ways
 *
 * @author Vladislav Halatsevich
 */
public class ArrayCreator {

    /**
     * Create CustomArray from data obtained from file or console
     *
     * @param data list of data to create CustomArray
     * @return CustomArray
     * @throws InputDataException if data to create array are null or size of array is less than 0
     */
    public CustomArray createArray(List<Integer> data) throws InputDataException {
        if (data == null) {
            throw new InputDataException("Data to create array are null");
        }
        int size = data.get(0);
        if (size < 0) {
            throw new InputDataException("Size of array is less then 0");
        }
        if (size > data.size()) {
            size = data.size() - 1;
        }
        CustomArray array = new CustomArray(size);
        for (int i = 0; i < size; i++) {
            int value = data.get(i + 1);
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
        for (int i = 0; i < size; i++) {
            array.setElement(i, (int) (Math.random() * randomMultiplier));
        }
        return array;
    }
}
