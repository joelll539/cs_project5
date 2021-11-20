package prj5;
import student.TestCase;

/**
 * This tests the race class
 * @author joell
 * @author akshath
 * @author tomasg
 * @version 11.20.2021
 *
 */
public class RaceTest extends TestCase {
    private Race race1;
    private Race race2;
    private Race race3;
    private Race race4;
    
    /**
     * This sets up the tests
     */
    public void setUp() {
        race1 = new Race("a", 4, 2);
        race2 = new Race("b", 4, 2);
        race3 = new Race("c", 4, 1);
        race4 = new Race("d", 4, 3);
    }
    
    /**
     * This tests the getter methods
     * Also tests getCFR
     */
    public void testGetters() {
        assertEquals(race1.getName(), "a");
        assertEquals(race2.getCases(), 4d, .1d);
        assertEquals(race3.getCFR(), 25d, .1d);
    }
    
    /**
     * This tests the toString method
     */
    public void testToString() {
        System.out.println(race4.toString());
        assertEquals(race4.toString(), "d: 4 cases, 75% CFR");
    }
    
    /**
     * This tests the compareTo method
     */
    public void testCompareTo() {
        assertTrue(race1.compareTo(race2) < 0);
        assertTrue(race1.compareTo(race3) < 0);
        assertTrue(race1.compareTo(race4) > 0);
    }
}
