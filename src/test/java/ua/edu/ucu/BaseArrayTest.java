package ua.edu.ucu;

import org.junit.Test;
import ua.edu.ucu.smartarr.BaseArray;

import static org.junit.Assert.*;

public class BaseArrayTest {

    @Test
    public void testSize() {
        BaseArray bs = new BaseArray(new Integer[]{1, 2, 3});
        int expected = 3;
        int actual = bs.size();
        assert(expected == actual);
    }

    @Test
    public void testString() {
        BaseArray bs = new BaseArray(new Integer[]{1, 2, 3});
        String expected = bs.operationDescription();
        assert(expected.equals("Creating BaseArray instance. "));
    }


}