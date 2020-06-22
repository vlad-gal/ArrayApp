package by.halatsevich.array.task2.entity;

import java.util.Arrays;

/**
 * Transfer object to jagged array with parameters
 *
 * @author Vladislav Halatsevich
 */
public class ArrayParameter {
    private int arrayParameter;
    private int[] array;

    public ArrayParameter(int arrayParameter, int[] array) {
        this.arrayParameter = arrayParameter;
        this.array = array;
    }

    public int getArrayParameter() {
        return arrayParameter;
    }

    public void setArrayParameter(int arrayParameter) {
        this.arrayParameter = arrayParameter;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
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
        ArrayParameter parameter = (ArrayParameter) o;

        if (parameter.arrayParameter != arrayParameter) {
            return false;
        }
        return Arrays.equals(array, parameter.array);
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + arrayParameter;
        result = prime * result + Arrays.hashCode(array);
        return result;
    }

    @Override
    public String toString() {
        return String.format("ArrayParameter {parameter = %d, elements = %s}", arrayParameter, Arrays.toString(array));
    }
}
