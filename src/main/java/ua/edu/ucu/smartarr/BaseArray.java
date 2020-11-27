package ua.edu.ucu.smartarr;


// Base array for decorators
public class BaseArray implements SmartArray {
    private Object[] array;
    private int size;

    public BaseArray(Object[] arr) {
        array = arr;
        size = arr.length;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size()];
        System.arraycopy(array, 0, result, 0, size());
        return result;
    }

    @Override
    public String operationDescription() {
        return "Creating BaseArray instance. ";
    }

    @Override
    public int size() {
        return size;
    }


}
