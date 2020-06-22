package by.halatsevich.array.task1.entity;

import by.halatsevich.array.task1.exception.InputDataException;

import java.util.Arrays;

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
            throw new InputDataException("Illegal capacity: " + capacity);
        }
    }

    public int getElement(int index) throws InputDataException {
        if (checkIndex(index)) {
            throw new InputDataException("Index: " + index + " ,size: " + array.length);
        }
        return array[index];
    }

    public int setElement(int index, int value) throws InputDataException {
        if (checkIndex(index)) {
            throw new InputDataException("Index: " + index + " ,size: " + array.length);
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
        return Arrays.equals(array, customArray.array);
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + Arrays.hashCode(array);
        return result;
    }

    @Override
    public String toString() {
        return String.format("CustomArray {elements = %s, size = %d}", Arrays.toString(array), array.length);
    }
}
