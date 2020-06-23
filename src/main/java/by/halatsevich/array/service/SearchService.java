package by.halatsevich.array.service;

import by.halatsevich.array.entity.CustomArray;
import by.halatsevich.array.exception.InputDataException;

/**
 * Service provides various search methods
 *
 * @author Vladislav Halatsevich
 */
public class SearchService {

    /**
     * Binary search wrapper
     *
     * @param array the array to be searched, it should be sorted
     * @param key   the value to be searched for
     * @return index of the search key, if it is contained in the array or -(1+leftBound) if it is not contained
     * @throws InputDataException if index of element outside the array bounds or array is not sorted
     */
    public int binarySearch(CustomArray array, int key) throws InputDataException {
        if (!isSorted(array)) {
            throw new InputDataException("Array is not sorted");
        }
        checkRange(array.getSize(), 0, array.getSize());
        return binarySearchRecursion(array, 0, array.getSize(), key);
    }

    /**
     * Binary search algorithm
     *
     * @param array the array to be searched
     * @param left  left bound of array
     * @param right right bound of array
     * @param key   the value to be searched for
     * @return index of the search key, if it is contained in the array or -(1+leftBound) if it is not contained
     * @throws InputDataException if index of element outside the array bounds
     */
    private int binarySearchRecursion(CustomArray array, int left, int right, int key) throws InputDataException {
        int middleIndex = left + (right - left) / 2;
        int middleElement = array.getElement(middleIndex);
        if (left >= right) {
            return -(1 + left);
        }
        if (middleElement == key) {
            return middleIndex;
        } else if (middleElement > key) {
            return binarySearchRecursion(array, left, middleIndex, key);
        } else {
            return binarySearchRecursion(array, middleIndex + 1, right, key);
        }
    }

    /**
     * Check range in array for binary search
     *
     * @param arraySize arrays size
     * @param left      left index of bound
     * @param right     right index of bound
     * @throws InputDataException if index of element outside the array bounds
     */
    private void checkRange(int arraySize, int left, int right) throws InputDataException {
        if (left > right) {
            throw new InputDataException("left index > right index");
        }
        if (left < 0) {
            throw new InputDataException("left index < 0");
        }
        if (right > arraySize) {
            throw new InputDataException("right index > array size");
        }
    }

    /**
     * Check if array sorted for binary search
     *
     * @param array the array to be checked
     * @return true if array sorted, false if not
     * @throws InputDataException if index of element outside the array bounds
     */
    private boolean isSorted(CustomArray array) throws InputDataException {
        boolean condition = array.getElement(0) - array.getElement(1) > 0;
        for (int i = 0; i < array.getSize() - 1; i++) {
            if ((array.getElement(i) - array.getElement(i + 1) > 0) != condition) {
                return false;
            }
        }
        return true;
    }

    /**
     * Search minimum value in array
     *
     * @param array the array to be searched
     * @return minimum value
     * @throws InputDataException if index of element outside the array bounds
     */
    public int findMinElement(CustomArray array) throws InputDataException {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array.getSize(); i++) {
            if (min > array.getElement(i)) {
                min = array.getElement(i);
            }
        }
        return min;
    }

    /**
     * Search maximum value in array
     *
     * @param array the array to be searched
     * @return maximum value
     * @throws InputDataException if index of element outside the array bounds
     */
    public int findMaxElement(CustomArray array) throws InputDataException {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.getSize(); i++) {
            if (max < array.getElement(i)) {
                max = array.getElement(i);
            }
        }
        return max;
    }

    /**
     * Search all simple numbers in array
     *
     * @param array the array to be searched
     * @return CustomArray filled simple numbers if they are present
     * @throws InputDataException if index of element outside the array bounds or size of array is less than 0
     */
    public CustomArray findAllSimpleNumbers(CustomArray array) throws InputDataException {
        int size = 0;
        for (int i = 0; i < array.getSize(); i++) {
            int tempValue = array.getElement(i);
            if (tempValue <= 0) {
                continue;
            }
            if (isSimpleNumber(tempValue)) {
                size++;
            }
        }
        CustomArray allSimpleNumbers = new CustomArray(size);
        int index = 0;
        for (int i = 0; i < array.getSize(); i++) {
            int tempValue = array.getElement(i);
            if (tempValue <= 0) {
                continue;
            }
            if (isSimpleNumber(tempValue)) {
                allSimpleNumbers.setElement(index, tempValue);
                index++;
            }
        }
        return allSimpleNumbers;
    }

    /**
     * Check if number is simple
     *
     * @param number checked number
     * @return true if number is simple, false if is not
     */
    private boolean isSimpleNumber(int number) {
        if (number < 0) {
            return false;
        }
        boolean result = true;
        for (int j = 2; j <= Math.sqrt(number); j++) {
            if (number % j == 0) {
                result = false;
            }
        }
        return result;
    }

    /**
     * Search all Fibonacci numbers in array
     *
     * @param array the array to be searched
     * @return CustomArray filled Fibonacci numbers if they are present
     * @throws InputDataException if index of element outside the array bounds or size of array is less than 0
     */
    public CustomArray findAllFibonacciNumbers(CustomArray array) throws InputDataException {
        int size = 0;
        for (int i = 0; i < array.getSize(); i++) {
            int tempValue = array.getElement(i);
            if (isFibonacciNumber(tempValue)) {
                size++;
            }
        }
        CustomArray allFibonacciNumbers = new CustomArray(size);
        int index = 0;
        for (int i = 0; i < array.getSize(); i++) {
            int tempValue = array.getElement(i);
            if (isFibonacciNumber(tempValue)) {
                allFibonacciNumbers.setElement(index, tempValue);
                index++;
            }
        }
        return allFibonacciNumbers;
    }

    /**
     * Check if number is Fibonacci number
     *
     * @param value checked number
     * @return true if number is Fibonacci, false if is not
     */
    private boolean isFibonacciNumber(int value) {
        int firstCondition = (int) (5 * Math.pow(value, 2) + 4);
        int secondCondition = (int) (5 * Math.pow(value, 2) - 4);
        return (isPerfectSquare(firstCondition) || isPerfectSquare(secondCondition));
    }

    /**
     * Check if number is perfect square
     *
     * @param value checked number
     * @return true if number is perfect square, false if is not
     */
    private boolean isPerfectSquare(int value) {
        int number = (int) Math.sqrt(value);
        return (Math.pow(number, 2) == value);
    }

    /**
     * Search all triple digits numbers without identical digits in array
     *
     * @param array the array to be searched
     * @return CustomArray filled triple digits numbers without identical digits if they are present
     * @throws InputDataException if index of element outside the array bounds or size of array is less than 0
     */
    public CustomArray findAllTripleWithoutIdenticalDigits(CustomArray array) throws InputDataException {
        int size = 0;
        for (int i = 0; i < array.getSize(); i++) {
            int tempValue = array.getElement(i);
            if ((tempValue >= 100 && tempValue < 1000) || (tempValue <= -100 && tempValue > -1000)) {
                int hundreds = tempValue / 100;
                int tens = (tempValue % 100) / 10;
                int ones = tempValue % 10;
                if (hundreds != tens && hundreds != ones && tens != ones) {
                    size++;
                }
            }
        }
        CustomArray allTripleDigits = new CustomArray(size);
        int index = 0;
        for (int i = 0; i < array.getSize(); i++) {
            int tempValue = array.getElement(i);
            if ((tempValue >= 100 && tempValue < 1000) || (tempValue <= -100 && tempValue > -1000)) {
                int hundreds = tempValue / 100;
                int tens = (tempValue % 100) / 10;
                int ones = tempValue % 10;
                if (hundreds != tens && hundreds != ones && tens != ones) {
                    allTripleDigits.setElement(index, tempValue);
                    index++;
                }
            }
        }
        return allTripleDigits;
    }
}
