package by.halatsevich.array.task2.service;

import by.halatsevich.array.task2.entity.ArrayParameter;
import by.halatsevich.array.task2.entity.Sort;

/**
 * Service to sort jagged array
 *
 * @author Vladislav Halatsevich
 */
public class JaggedArraySortService {

    /**
     * Bubble sort algorithm for jagged array with parameters
     *
     * @param arrayParameter parameter to use for sorting rows
     * @param typeOfSort     type of sort
     * @return sorted jagged array
     */
    public int[][] bubbleSort(ArrayParameter[] arrayParameter, Sort typeOfSort) {
        ArrayParameter tempParameter;
        for (int i = arrayParameter.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arrayParameter[j].getArrayParameter() > arrayParameter[j + 1].getArrayParameter()) {
                    tempParameter = arrayParameter[j];
                    arrayParameter[j] = arrayParameter[j + 1];
                    arrayParameter[j + 1] = tempParameter;
                }
            }
        }
        int[][] array = new int[arrayParameter.length][];
        if (typeOfSort == Sort.ASCENDING) {
            for (int i = 0; i < array.length; i++) {
                array[i] = arrayParameter[i].getArray();
            }
        } else {
            for (int i = 0; i < array.length; i++) {
                array[i] = arrayParameter[array.length - 1 - i].getArray();
            }
        }
        return array;
    }
}
