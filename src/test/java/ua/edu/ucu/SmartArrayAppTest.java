package ua.edu.ucu;

import org.junit.Test;
import ua.edu.ucu.smartarr.SmartArray;

import static org.junit.Assert.*;

/**
 * @author Andrii_Rodionov
 */
public class SmartArrayAppTest {

    @Test
    public void testFilterPositiveIntegersSortAndMultiplyBy2() {
        Integer[] integers = {-1, 2, 0, 1, -5, 3};

        Integer[] res =
                SmartArrayApp.filterPositiveIntegersSortAndMultiplyBy2(integers);
        Integer[] expectedRes = {2, 4, 6};

        assertArrayEquals(expectedRes, res);
    }

    @Test
    public void testFindDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname() {
        Student[] students = {
                new Student("Ivar", "Grimstad", 3.9, 2),
                new Student("Ittai", "Zeidman", 4.5, 1),
                new Student("Antons", "Kranga", 4.0, 2),
                new Student("Burr", "Sutter", 4.2, 2),
                new Student("Philipp", "Krenn", 4.3, 3),
                new Student("Tomasz", "Borek", 4.1, 2),
                new Student("Ittai", "Zeidman", 4.5, 1),
                new Student("Burr", "Sutter", 4.2, 2)};
        String[] studentNames =
                SmartArrayApp.findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname(students);
        String[] expectedStudentNames = {"Borek Tomasz", "Kranga Antons", "Sutter Burr"};

        assertArrayEquals(expectedStudentNames, studentNames);
    }

    @Test
    public void test2FindDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname() {
        Student[] students = {
                new Student("Ivar", "Grimstad", 3.9, 2),
                new Student("Ittai", "Zeidman", 4.5, 1),
                new Student("Antons", "Kranga", 4.0, 2),
                new Student("Antonsio", "Krangal", 4.1, 2),
                new Student("Burr", "Sutter", 4.2, 2),
                new Student("Philipp", "Krenn", 4.3, 3),
                new Student("Tomasz", "Borek", 4.1, 2),
                new Student("Ittai", "Zeidman", 4.5, 1),
                new Student("Burr", "Sutter", 4.2, 2)};
        String[] studentNames =
                SmartArrayApp.findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname(students);
        String[] expectedStudentNames = {"Borek Tomasz", "Kranga Antons", "Krangal Antonsio", "Sutter Burr"};

        assertArrayEquals(expectedStudentNames, studentNames);
    }

    @Test
    public void testConstructor() {
        SmartArrayApp app = new SmartArrayApp();
        Student s1 = new Student("Ivar", "Grimstad", 3.9, 2);
        Student s2 = new Student("Ivar", "Zeidman", 4.5, 1);
        assertNotEquals(s1, s2);
    }
}