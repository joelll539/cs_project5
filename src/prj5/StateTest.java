package prj5;

/**
 * This tests the state class
 * @author joell
 * @author tomasg
 * @author akshath
 * @version 2021.11.20
 *
 */
public class StateTest extends student.TestCase {

    private State testStates;
    private SinglyLinkedList<Race> testRaceList;
    private Race testRace;
    
    /**
     * Set up variables
     */
    public void setUp() {
        testRace = new Race("Asian", 5412, 32);
        testRaceList = new SinglyLinkedList<Race>();
        testRaceList.appendFirst(testRace);
        testStates = new State("DC", testRaceList);
    }   
    
     /**
     * Test cases for getRaces() method
     */
    public void testGetRaces() {
        // Check normal behavior
        assertTrue(testRaceList.toString().equals(testStates.getRaces().toString()));
        Race testRace2 = new Race("White", 17382, 383);
        
        // Check if appending a second race affects it
        testRaceList.appendLast(testRace2);
        assertFalse(testRaceList.toString().equals(testStates.getRaces().toString()));
    }    
    
    /**
     * Test cases for getName() method
     */
    public void testGetName() {
        // Check normal behavior
        assertEquals("DC", testStates.getName());
    }
    
    /**
     * Test cases for toString() method
     */
    public void testToString() {
        System.out.println(testStates.toString());
        // Check normal behavior
        assertNotNull(testStates.toString());
    }
    
}
