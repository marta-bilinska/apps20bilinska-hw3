package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

import java.util.Arrays;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator {
    private final MyComparator comparator;

    public SortDecorator(SmartArray smartArray,
                         MyComparator myComparator) {
        super(sort(smartArray, myComparator));
        comparator = myComparator;
    }

    public static SmartArray sort(SmartArray smartArray,
                                  MyComparator myComparator) {
        Object[] newArray = smartArray.toArray();
        Arrays.sort(newArray, myComparator);
        return new BaseArray(newArray);
    }

    @Override
    public Object[] toArray() {
        return super.smartArray.toArray();
    }

    @Override
    public String operationDescription() {
        return "Sorting the elements with " + getComparatorDescription();
    }

    @Override
    public int size() {
        return super.smartArray.size();
    }

    public String getComparatorDescription() {
        return comparator.description();
    }
}
