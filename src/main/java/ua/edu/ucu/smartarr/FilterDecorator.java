package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

import java.util.ArrayList;
import java.util.Arrays;


// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {
    private final MyPredicate predicate;

    public FilterDecorator(SmartArray smartArray, MyPredicate myPredicate) {
        super(createFiltered(smartArray, myPredicate));
        predicate = myPredicate;
    }

    public static SmartArray createFiltered(SmartArray smartArray,
                                            MyPredicate myPredicate) {
        ArrayList<Object> resultArray =
                new ArrayList<>(Arrays.asList(smartArray.toArray()));
        resultArray.removeIf(item -> !myPredicate.test(item));
        return new BaseArray(resultArray.toArray());
    }

    @Override
    public Object[] toArray() {
        return super.smartArray.toArray();
    }

    @Override
    public String operationDescription() {
        return "Filtering the array... ";
    }

    @Override
    public int size() {
        return super.smartArray.size();
    }

}
