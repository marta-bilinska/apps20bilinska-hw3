package ua.edu.ucu.smartarr;


import java.util.ArrayList;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator {

    public DistinctDecorator(SmartArray smartArray) {
        super(removeDuplicates(smartArray));
    }

    public static SmartArray removeDuplicates(SmartArray smartArray) {
        Object[] values = smartArray.toArray();
        ArrayList<Object> newArray = new ArrayList<>();
        int found;
        for (Object current : values) {
            found = 0;
            if (newArray.size() >= 1) {
                for (Object item : newArray) {
                    if (current.equals(item)) {
                        found = 1;
                        break;
                    }
                }
            }
            if (found == 0) {
                newArray.add(current);
            }
        }
        return new BaseArray(newArray.toArray());
    }


    @Override
    public Object[] toArray() {
        return super.smartArray.toArray();
    }

    @Override
    public String operationDescription() {
        return "Removing repeating entries... ";
    }

    @Override
    public int size() {
        return super.smartArray.size();
    }

}
