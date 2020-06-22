package by.halatsevich.array.task2.service;

import by.halatsevich.array.task2.entity.ArrayParameter;

/**
 * Service for ArrayParameter with various parameters to sort jagged array
 *
 * @author Vladislav Halatsevich
 */
public class ArrayParameterService {

    /**
     * Calculate values sum in each row in jagged array
     *
     * @param array jagged array where sum to be calculated in each row
     * @return array of ArrayParameters with define parameters
     */
    public ArrayParameter[] sumInRow(int[][] array) {
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

    /**
     * Calculate max value in each row in jagged array
     *
     * @param array jagged array where max value to be found in each row
     * @return array of ArrayParameters with define parameters
     */
    public ArrayParameter[] maxValueInRow(int[][] array) {
        ArrayParameter[] maxValueInRow = new ArrayParameter[array.length];
        for (int i = 0; i < array.length; i++) {
            int max = Integer.MIN_VALUE;
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
    public ArrayParameter[] minValueInRow(int[][] array) {
        ArrayParameter[] minValueInRow = new ArrayParameter[array.length];
        for (int i = 0; i < array.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < array[i].length; j++) {
                if (min > array[i][j]) {
                    min = array[i][j];
                }
            }
            minValueInRow[i] = new ArrayParameter(min, array[i]);
        }
        return minValueInRow;
    }
}
