package by.halatsevich.jaggedarray.entity;

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
        for (int i = 0; i < array.length; i++) {
            if (parameter.array[i] != array[i]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + arrayParameter;
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
        return String.format("ArrayParameter {parameter = %d, elements = %s}", arrayParameter, arrayToString);
    }
}
