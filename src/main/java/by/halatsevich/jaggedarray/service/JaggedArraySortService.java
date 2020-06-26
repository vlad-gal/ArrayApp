package by.halatsevich.jaggedarray.service;

import by.halatsevich.jaggedarray.entity.ArrayParameter;
import by.halatsevich.jaggedarray.entity.SortParameter;
import by.halatsevich.jaggedarray.entity.TypeSort;

/**
 * Service to sort jagged array
 *
 * @author Vladislav Halatsevich
 */
public class JaggedArraySortService {

    /**
     * Bubble sort algorithm wrapper with parameters
     * such as type of sort and parameter to use for sorting rows
     *
     * @param jaggedArray the jagged array to be sorted
     * @param parameter   sorting parameter MIN,MAX,SUM in each row
     * @param typeOfSort  ascending or descending order
     * @return sorted jagged array
     */
    public int[][] bubbleSort(int[][] jaggedArray, SortParameter parameter, TypeSort typeOfSort) {
        ArrayParameter[] arrayParameter;
        switch (parameter) {
            case MAX:
                arrayParameter = maxValueInRow(jaggedArray);
                break;
            case MIN:
                arrayParameter = minValueInRow(jaggedArray);
                break;
            default:
                arrayParameter = sumInRow(jaggedArray);
                break;
        }
        int[][] resultOfSorting;
        switch (typeOfSort) {
            case DESCENDING:
                resultOfSorting = bubbleDescendingSort(arrayParameter);
                break;
            default:
                resultOfSorting = bubbleAscendingSort(arrayParameter);
                break;
        }
        return resultOfSorting;
    }

    /**
     * Bubble sort algorithm in ascending order for jagged array with parameters
     *
     * @param arrayParameter parameter to use for sorting rows
     * @return sorted jagged array in ascending order
     */
    private int[][] bubbleAscendingSort(ArrayParameter[] arrayParameter) {
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
        for (int i = 0; i < array.length; i++) {
            array[i] = arrayParameter[i].getArray();
        }
        return array;
    }

    /**
     * Bubble sort algorithm in descending order for jagged array with parameters
     *
     * @param arrayParameter parameter to use for sorting rows
     * @return sorted jagged array in ascending order
     */
    private int[][] bubbleDescendingSort(ArrayParameter[] arrayParameter) {
        int[][] result = bubbleAscendingSort(arrayParameter);
        for (int i = 0; i < result.length; i++) {
            result[i] = arrayParameter[result.length - 1 - i].getArray();
        }
        return result;
    }

    /**
     * Calculate max value in each row in jagged array
     *
     * @param array jagged array where max value to be found in each row
     * @return array of ArrayParameters with define parameters
     */
    private ArrayParameter[] maxValueInRow(int[][] array) {
        ArrayParameter[] maxValueInRow = new ArrayParameter[array.length];
        for (int i = 0; i < array.length; i++) {
            int max = array[i][0];
            for (int j = 0; j < array[i].length; j++) {
                if (max < array[i][j]) {
                    max = array[i][j];
                }
            }
            maxValueInRow[i] = new ArrayParameter(max, array[i]);
        }
        return maxValueInRow;
    }

    /**
     * Calculate min value in each row in jagged array
     *
     * @param array jagged array where min value to be found in each row
     * @return array of ArrayParameters with define parameters
     */
    private ArrayParameter[] minValueInRow(int[][] array) {
        ArrayParameter[] minValueInRow = new ArrayParameter[array.length];
        for (int i = 0; i < array.length; i++) {
            int min = array[i][0];
            for (int j = 0; j < array[i].length; j++) {
                if (min > array[i][j]) {
                    min = array[i][j];
                }
            }
            minValueInRow[i] = new ArrayParameter(min, array[i]);
        }
        return minValueInRow;
    }

    /**
     * Calculate values sum in each row in jagged array
     *
     * @param array jagged array where sum to be calculated in each row
     * @return array of ArrayParameters with define parameters
     */
    private ArrayParameter[] sumInRow(int[][] array) {
        ArrayParameter[] sumInRow = new ArrayParameter[array.length];
        for (int i = 0; i < array.length; i++) {
            int sum = 0;
            for (int j = 0; j < array[i].length; j++) {
                sum += array[i][j];

            }
            sumInRow[i] = new ArrayParameter(sum, array[i]);
        }
        return sumInRow;
    }
}
