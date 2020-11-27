package ua.edu.ucu.smartarr;


// Base array for decorators
public class BaseArray implements SmartArray {
    private final Object[] array;
    private final int size;

    public BaseArray(Object[] arr) {
        array = new Object[arr.length];
        System.arraycopy(arr, 0, array, 0, arr.length);
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
