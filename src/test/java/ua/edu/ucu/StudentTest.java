package ua.edu.ucu;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


public class StudentTest {
    Student studentOne = new Student("Ivar", "Grimstad", 3.9, 2);
    Student studentTwo = new Student("Ivar", "Grimstad", 3.9, 2);

    @Test
    public void testHash() {
        assertEquals(studentOne.hashCode(), studentTwo.hashCode());
    }

    @Test
    public void testName() {
        assert (studentOne.getName().equals("Ivar"));
    }

    @Test
    public void testString(){
        assertEquals(studentOne.toString(),"Student{name=Ivar, surname=Grimstad, GPA=3.9, year=2}");
    }
    @Test
    public void testEqualNull(){
        assertFalse(studentOne.equals(null));
    }

    @Test
    public void testEquals(){

        assertFalse(studentOne.equals(null));
    }

    @Test
    public void testEqualDifferentClass(){
        assertFalse(studentOne.equals(new String()));
    }

}