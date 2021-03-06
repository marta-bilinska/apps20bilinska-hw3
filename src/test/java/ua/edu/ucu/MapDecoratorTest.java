package ua.edu.ucu;

import org.junit.Test;

import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.smartarr.BaseArray;
import ua.edu.ucu.smartarr.SmartArray;
import ua.edu.ucu.smartarr.MapDecorator;
import ua.edu.ucu.smartarr.SortDecorator;

public class MapDecoratorTest {
    MyFunction function = new MyFunction() {
        @Override
        public Object apply(Object t) {
            return 2 * ((Integer) t);
        }

        @Override
        public String description() {
            return "Function that multiplies by 2";
        }
    };

    MyFunction functionTwo = new MyFunction() {
        @Override
        public Object apply(Object t) {
            return 2 * ((Integer) t);
        }

    };
    SmartArray ba = new BaseArray(new Integer[]{1, 2, 3});

    @Test
    public void testSize() {
        SmartArray decorated = new MapDecorator(ba, function);
        int expected = 3;
        int actual = decorated.size();
        assert (expected == actual);
    }

    @Test
    public void testString() {
        SmartArray decorated = new MapDecorator(ba, function);
        String expected = decorated.operationDescription();
        assert (expected.equals("Mapping array to a function Function that multiplies by 2"));
    }

    @Test
    public void testStringEmpty() {
        SmartArray decorated = new MapDecorator(ba, functionTwo);
        String expected = decorated.operationDescription();
        assert (expected.equals("Mapping array to a function "));
    }

}