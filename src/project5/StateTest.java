package project5;

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
        assertTrue(testRaceList.equals(testStates.getRaces()));
        Race testRace2 = new Race("White", 17382, 383);
        
        // Check if appending a second race affects it
        testRaceList.appendLast(testRace2);
        assertTrue(testRaceList.equals(testStates.getRaces()));
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
        // Check normal behavior
        assertEquals("DC", testStates.toString());
    }
    
}
