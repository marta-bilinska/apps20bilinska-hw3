package ua.edu.ucu;

import org.junit.Test;
import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.smartarr.BaseArray;
import ua.edu.ucu.smartarr.SmartArray;
import ua.edu.ucu.smartarr.SortDecorator;

public class SortDecoratorTest {
    MyComparator comparator = new MyComparator() {
        @Override
        public int compare(Object o1, Object o2) {
            return ((Integer) o1) - ((Integer) o2);
        }

        @Override
        public String description() {
            return "Integer comparator";
        }
    };
    MyComparator comparatorTwo = new MyComparator() {
        @Override
        public int compare(Object o1, Object o2) {
            return ((Integer) o1) - ((Integer) o2);
        }

    };
    SmartArray ba = new BaseArray(new Integer[]{1, 2, 3});

    @Test
    public void testSize() {
        SmartArray decorated = new SortDecorator(ba, comparator);
        int expected = 3;
        int actual = decorated.size();
        assert (expected == actual);
    }

    @Test
    public void testString() {
        SmartArray decorated = new SortDecorator(ba, comparator);
        String expected = decorated.operationDescription();
        assert (expected.equals("Sorting the elements with Integer comparator"));
    }

    @Test
    public void testStringEmpty() {
        SmartArray decorated = new SortDecorator(ba, comparatorTwo);
        String expected = decorated.operationDescription();
        assert (expected.equals("Sorting the elements with "));
    }

}