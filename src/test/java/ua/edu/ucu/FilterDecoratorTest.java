package ua.edu.ucu;

import org.junit.Test;

import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.BaseArray;
import ua.edu.ucu.smartarr.FilterDecorator;
import ua.edu.ucu.smartarr.SmartArray;


public class FilterDecoratorTest {
    MyPredicate predicate = new MyPredicate() {
        @Override
        public boolean test(Object t) {
            return ((Integer) t) > 0;
        }
    };

    SmartArray ba = new BaseArray(new Integer[]{1, 2, 3});

    @Test
    public void testSize() {
        SmartArray decorated = new FilterDecorator(ba, predicate);
        int expected = 3;
        int actual = decorated.size();
        assert (expected == actual);
    }

    @Test
    public void testString() {
        SmartArray decorated = new FilterDecorator(ba, predicate);
        String expected = decorated.operationDescription();
        assert (expected.equals("Filtering the array... "));
    }

}