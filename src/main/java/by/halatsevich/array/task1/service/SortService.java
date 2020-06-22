package by.halatsevich.array.task1.service;

import by.halatsevich.array.task1.entity.CustomArray;
import by.halatsevich.array.task1.exception.InputDataException;

/**
 * Service provides various sorting methods
 *
 * @author Vladislav Halatsevich
 */
public class SortService {

    /**
     * Bubble sorting algorithm
     *
     * @param array which will be sorted
     * @return sorted CustomArray
     * @throws InputDataException if index of element outside the array bounds
     */
    public CustomArray bubbleSort(CustomArray array) throws InputDataException {
        int tempValue;
        for (int i = array.getSize() - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array.getElement(j) > array.getElement(j + 1)) {
                    tempValue = array.getElement(j);
                    array.setElement(j, array.getElement(j + 1));
                    array.setElement(j + 1, tempValue);
                }
            }
        }
        return array;
    }

    /**
     * Insert sorting algorithm
     *
     * @param array which will be sorted
     * @return sorted CustomArray
     * @throws InputDataException if index of element outside the array bounds
     */
    public CustomArray insertSort(CustomArray array) throws InputDataException {
        int tempValue;
        for (int i = 0; i < array.getSize(); i++) {
            tempValue = array.getElement(i);
            int j = i - 1;
            while (j >= 0 && array.getElement(j) > tempValue) {
                array.setElement(j + 1, array.getElement(j));
                j--;
            }
            array.setElement(j + 1, tempValue);
        }
        return array;
    }

    /**
     * Select sorting algorithm
     *
     * @param array which will be sorted
     * @return sorted CustomArray
     * @throws InputDataException if index of element outside the array bounds
     */
    public CustomArray selectSort(CustomArray array) throws InputDataException {
        int tempValue;
        int index;
        for (int i = 0; i < array.getSize(); i++) {
            index = i;
            tempValue = array.getElement(i);
            for (int j = i + 1; j < array.getSize(); j++) {
                if (array.getElement(j) < tempValue) {
                    index = j;
                    tempValue = array.getElement(j);
                }
            }
            array.setElement(index, array.getElement(i));
            array.setElement(i, tempValue);
        }
        return array;
    }
}
