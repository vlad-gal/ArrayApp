package by.halatsevich.array.entity;

import by.halatsevich.array.exception.InputDataException;

/**
 * Array wrapper class
 *
 * @author Vladislav Halatsevich
 */
public class CustomArray {
    private int[] array;

    public CustomArray(int[] array) {
        this.array = array;
    }

    public CustomArray(int capacity) throws InputDataException {
        if (capacity >= 0) {
            array = new int[capacity];
        } else {
            throw new InputDataException("Array capacity is less than 0");
        }
    }

    public int getElement(int index) throws InputDataException {
        if (checkIndex(index)) {
            throw new InputDataException("Index of element: " + index + ", but size of array: " + array.length);
        }
        return array[index];
    }

    public int setElement(int index, int value) throws InputDataException {
        if (checkIndex(index)) {
            throw new InputDataException("Index of element: " + index + ", but size of array: " + array.length);
        }
        int oldValue = array[index];
        array[index] = value;
        return oldValue;
    }

    public int getSize() {
        return array.length;
    }

    private boolean checkIndex(int index) {
        return (index >= array.length || index < 0);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (this == o) {
            return true;
        }
        if (getClass() != o.getClass()) {
            return false;
        }
        CustomArray customArray = (CustomArray) o;
        for (int i = 0; i < array.length; i++) {
            if (customArray.array[i] != array[i]) {
                return false;
            }
        }
        if (customArray.array.length != array.length) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        for (int i = 0; i < array.length; i++) {
            result = prime * result + array[i];
        }
        return result;
    }

    @Override
    public String toString() {
        int lastIndex = array.length - 1;
        StringBuilder arrayToString = new StringBuilder();
        arrayToString.append('[');
        if (array.length == 0) {
            arrayToString.append(']');
        }
        for (int i = 0; i < array.length; i++) {
            arrayToString.append(array[i]);
            if (i == lastIndex) {
                arrayToString.append(']');
                continue;
            }
            arrayToString.append(", ");
        }
        return String.format("CustomArray {elements = %s, size = %d}", arrayToString, array.length);
    }
}
