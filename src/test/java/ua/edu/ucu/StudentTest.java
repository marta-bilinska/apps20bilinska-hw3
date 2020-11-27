package ua.edu.ucu;

import org.junit.Test;

import static org.junit.Assert.*;


public class StudentTest {
    Student studentOne = new Student("Ivar", "Grimstad", 3.9, 2);
    Student studentTwo = new Student("Ivak", "Grimstad", 3.9, 2);
    Student studentThree = new Student("Ivar", "Neri", 3.9, 2);
    Student studentFour = new Student("Ivar", "Grimstad", 3.8, 2);
    Student studentFive = new Student("Ivar", "Grimstad", 3.9, 3);
    Student studentSix = new Student("Ivar", "Grimstad", 3.9, 2);

    @Test
    public void testEquals() {
        assertNotEquals(null, studentOne);
        assertNotEquals(studentTwo, studentThree);
        assertNotEquals(studentFour, studentTwo);
        assertNotEquals(studentFour, studentFive);
        assertNotEquals(studentFour, studentTwo);
        assertEquals(studentOne,studentSix);

    }

    @Test
    public void testHash() {
        assertEquals(studentOne.hashCode(), studentSix.hashCode());
    }

    @Test
    public void testName() {
        assert (studentOne.getName().equals("Ivar"));
    }

    @Test
    public void testString() {
        assertEquals(studentOne.toString(), "Student{name=Ivar, surname=Grimstad, GPA=3.9, year=2}");
    }

    @Test
    public void testEqualNull() {
        assertFalse(studentOne.equals(null));
    }

    @Test
    public void testEqualDifferentClass() {
        assertFalse(studentOne.equals(new String()));
    }

}