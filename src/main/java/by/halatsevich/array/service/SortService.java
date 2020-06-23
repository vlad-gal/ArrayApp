package by.halatsevich.array.service;

import by.halatsevich.array.entity.CustomArray;
import by.halatsevich.array.exception.InputDataException;

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
        CustomArray sortedArray = copyArray(array);
        int tempValue;
        for (int i = sortedArray.getSize() - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (sortedArray.getElement(j) > sortedArray.getElement(j + 1)) {
                    tempValue = sortedArray.getElement(j);
                    sortedArray.setElement(j, sortedArray.getElement(j + 1));
                    sortedArray.setElement(j + 1, tempValue);
                }
            }
        }
        return sortedArray;
    }

    /**
     * Insert sorting algorithm
     *
     * @param array which will be sorted
     * @return sorted CustomArray
     * @throws InputDataException if index of element outside the array bounds
     */
    public CustomArray insertSort(CustomArray array) throws InputDataException {
        CustomArray sortedArray = copyArray(array);
        int tempValue;
        for (int i = 0; i < sortedArray.getSize(); i++) {
            tempValue = sortedArray.getElement(i);
            int j = i - 1;
            while (j >= 0 && sortedArray.getElement(j) > tempValue) {
                sortedArray.setElement(j + 1, sortedArray.getElement(j));
                j--;
            }
            sortedArray.setElement(j + 1, tempValue);
        }
        return sortedArray;
    }

    /**
     * Select sorting algorithm
     *
     * @param array which will be sorted
     * @return sorted CustomArray
     * @throws InputDataException if index of element outside the array bounds
     */
    public CustomArray selectSort(CustomArray array) throws InputDataException {
        CustomArray sortedArray = copyArray(array);
        int tempValue;
        int index;
        for (int i = 0; i < sortedArray.getSize(); i++) {
            index = i;
            tempValue = sortedArray.getElement(i);
            for (int j = i + 1; j < sortedArray.getSize(); j++) {
                if (sortedArray.getElement(j) < tempValue) {
                    index = j;
                    tempValue = sortedArray.getElement(j);
                }
            }
            sortedArray.setElement(index, sortedArray.getElement(i));
            sortedArray.setElement(i, tempValue);
        }
        return sortedArray;
    }

    /**
     * Utility method for copying an array
     *
     * @param array to be copied
     * @return new CustomArray
     * @throws InputDataException if index of element outside the array bounds
     */
    private CustomArray copyArray(CustomArray array) throws InputDataException {
        CustomArray sortedArray = new CustomArray(array.getSize());
        for (int i = 0; i < array.getSize(); i++) {
            sortedArray.setElement(i, array.getElement(i));
        }
        return sortedArray;
    }
}
