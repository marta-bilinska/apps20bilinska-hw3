package ua.edu.ucu;

import java.util.Arrays;

import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.*;

public class SmartArrayApp {

    public static Integer[]
    filterPositiveIntegersSortAndMultiplyBy2(Integer[] integers) {

        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Integer) t) > 0;
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object objectOne, Object objectTwo) {
                return ((Integer) objectOne) - ((Integer) objectTwo);
            }
        };

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return 2 * ((Integer) t);
            }
        };

        // Input: [-1, 2, 0, 1, -5, 3]
        SmartArray sa = new BaseArray(integers);

        sa = new FilterDecorator(sa, pr); // Result: [2, 1, 3];
        sa = new SortDecorator(sa, cmp); // Result: [1, 2, 3]
        sa = new MapDecorator(sa, func); // Result: [2, 4, 6]

        // Alternative
//        sa = new MapDecorator(
//                    new SortDecorator(
//                        new FilterDecorator(sa, pr),
//                    cmp),
//                func);
        Object[] result = sa.toArray();
        return Arrays.copyOf(result, result.length, Integer[].class);
    }

    public static String[]
    findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname(
            Student[] students) {

        // Hint: to convert Object[] to String[] - use the following code
        MyPredicate yearPredicate = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return (((Student) t).getYear() == 2);
            }
        };
        MyPredicate gpaPredicate = new MyPredicate() {
            private final static double MINIMUM = 4.0;

            @Override
            public boolean test(Object t) {
                return (((Student) t).getGPA() >= MINIMUM);
            }
        };
        MyComparator surnameComparator = new MyComparator() {
            public int compare(Object objectFirst, Object objectSecond) {
                String studentOne = ((Student) objectFirst).getSurname();
                String studentTwo = ((Student) objectSecond).getSurname();
                int lengthFirst = studentOne.length();
                int lengthSecond = studentTwo.length();
                int minimumLength = Math.min(lengthFirst, lengthSecond);
                for (int i = 0; i < minimumLength; i++) {
                    int charFirst = studentOne.charAt(i);
                    int charSecond = studentTwo.charAt(i);
                    if (charFirst == charSecond) {
                        continue;
                    }
                    if (charFirst > charSecond) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
                return 0;
            }
        };
        SmartArray studentSmartArray = new BaseArray(students);
        studentSmartArray = new SortDecorator(
                new FilterDecorator(
                        new FilterDecorator(
                                new DistinctDecorator(studentSmartArray),
                                yearPredicate),
                        gpaPredicate),
                surnameComparator);
//        Object[] result = studentSmartArray.toArray();
//        return Arrays.copyOf(result, result.length, String[].class);
        MyFunction mapFullName = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return ((Student) t).getFullName();
            }
        };

        Object[] result =
                new MapDecorator(studentSmartArray, mapFullName).toArray();
        return Arrays.copyOf(result, result.length, String[].class);

    }
}
