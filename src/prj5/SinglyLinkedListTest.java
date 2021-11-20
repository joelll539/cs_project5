package prj5;

import student.TestCase;

/**
 * This tests the singly linked list class
 * @author joell
 * @author akshath
 * @author tomasg
 * @version 2021.11.20
 */
public class SinglyLinkedListTest extends TestCase {
    private SinglyLinkedList<String> list;
    private SinglyLinkedList<Race> raceList;
    private Race testRace;
    
    /**
     * This sets up the tests
     */
    public void setUp() {
        list = new SinglyLinkedList<String>();
        raceList = new SinglyLinkedList<Race>();
        testRace = new Race("Asian", 8273, 981);
    }

    /**
     * this tests the toArray method
     */
    public void testToArray() {
        assertNull(list.toArray());
        list.appendFirst("a");
        list.appendFirst("c");
        list.appendFirst("b");
        
        String[] someArr = list.toArray();
        
        for (int i = 0; i < someArr.length; i++) {
            System.out.println(someArr[i].toString());
        }
        assertEquals(list.getHead().getData(), "b");
        
        list.sort();
        
        someArr = list.toArray();
        
        for (int i = 0; i < someArr.length; i++) {
            System.out.println(someArr[i].toString());
        }
        assertEquals(list.getHead().getData(), "a");
    }
    
    /**
     * This tests the appendFirst method
     */
    public void testAppendFirst() {
        Race someRace = new Race("a", 9f, 2f);
        Race someRace2 = new Race("b", 5f, 2f);
        Race someRace3 = new Race("c", 5f, 2f);
        raceList.appendFirst(someRace2);
        raceList.appendFirst(someRace3);
        raceList.appendFirst(someRace);
        
        State someState = new State("DC", raceList);
        System.out.println(someState.getRaces().toString());
        
        someState.sortCFR();
        System.out.println(someState.getRaces().toString());        

        // L
        //DataReader asdf = new DataReader(
        //    "Cases_and_Deaths_by_race_RANDOM_NUMBERS.csv");

        list.appendFirst(1 + "");
        list.appendFirst(2 + "");
        //System.out.println(list.toString());
        assertEquals("2", list.getHead().getData());
    }


    /**
     * Test cases for getHead() method
     */
    public void testGetHead() {
        // Check for normal behavior
        raceList.appendFirst(testRace);
        assertEquals(testRace, raceList.getHead().getData());

        // Check after new race to last
        Race testRace2 = new Race("Black", 38347, 0.2374f);
        raceList.appendLast(testRace2);
        assertEquals(testRace, raceList.getHead().getData());
    }

    /**
     * This also tests the toArray method
     */
    public void testToArray2() {
        // Check for normal behavior
        list.appendFirst("VA");
        list.appendFirst("DC");
       
        String[] testStringArray = { "DC", "VA" };
       
        for (int i = 0; i < testStringArray.length; i++) {
            assertEquals(testStringArray[i], list.toArray()[i]);
        }
    }
     
    /**
     * Test cases for setHead() method
     */
    public void testSetHead() {
        prj5.SinglyLinkedList.Node<Race> testNode 
            = new prj5.SinglyLinkedList.Node<Race>(testRace);
        raceList.setHead(testNode);
        raceList = new SinglyLinkedList<Race>(testNode);
        assertEquals(raceList.getHead().getData(), testNode.getData());
    }


    /**
     * Test cases for appendLast() method
     */
    public void testAppendLast() {
        // Check normal behavior
        raceList.appendFirst(testRace);
        Race testRace2 = new Race("LatinX", 21738, 817);
        raceList.appendLast(testRace2);
        assertEquals(testRace, raceList.getHead().getData());
    }

    
    /**
     * Test cases for toString() method
     */
    public void testToString() {
        // Check normal behavior
        raceList.appendFirst(testRace);
        System.out.println(raceList.toString());
        assertEquals("[Asian: 8273 cases, 11.9% CFR]",
            raceList.toString());
        
        // Check for another added race
        Race testRace2 = new Race("LatinX", 21738, 817);
        raceList.appendLast(testRace2);
        System.out.println(raceList.toString());
        assertEquals("[Asian: 8273 cases, 11.9% CFR, "
            + "LatinX: 21738 cases, 3.8% CFR]", raceList.toString());   
    }
    
    
}
