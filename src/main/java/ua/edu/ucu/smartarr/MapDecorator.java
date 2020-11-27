package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator {
    private final MyFunction function;

    public MapDecorator(SmartArray smartArray, MyFunction myFunction) {
        super(mapFunction(smartArray, myFunction));
        function = myFunction;
    }

    public static SmartArray mapFunction(SmartArray smartArray,
                                         MyFunction myFunction) {
        Object[] values = smartArray.toArray();
        int size = smartArray.size();
        for (int i = 0; i < size; i++) {
            values[i] = myFunction.apply(values[i]);
        }
        return new BaseArray(values);
    }

    @Override
    public Object[] toArray() {
        return super.smartArray.toArray();
    }

    @Override
    public String operationDescription() {
        return "Mapping array to a function " + getFunctionDescription();
    }

    @Override
    public int size() {
        return super.smartArray.size();
    }

    public String getFunctionDescription() {
        return function.description();
    }
}
