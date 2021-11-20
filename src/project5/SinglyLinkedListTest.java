package project5;

import student.TestCase;

public class SinglyLinkedListTest extends TestCase {

    private SinglyLinkedList<String> list;
    private SinglyLinkedList<Race> raceList;
    private Race testRace;

    public void setUp() {
        list = new SinglyLinkedList<String>();
        raceList = new SinglyLinkedList<Race>();
        testRace = new Race("Asian", 8273, 981);
    }

    public void testToArray() {
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

// /**
// * Test cases for toArray() method
// */
// public void testToArray() {
// // Check for normal behavior
// list.appendFirst("VA");
// list.appendFirst("DC");
//
// String[] testStringArray = { "DC", "VA" };
//
// for (int i = 0; i < testStringArray.length; i++) {
// assertEquals(testStringArray[i], list.toArray()[i]);
// }
//
// }

// /**
// * Test cases for setHead() method
// */
// public void testSetHead() {
// Node<Race> testNode = new Node<Race>(testRace);
// raceList.setHead(testNode);
// }


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
        assertEquals("[[Asian, 8273, 0.1%]]", raceList.toString());
        
        // Check for another added race
        Race testRace2 = new Race("LatinX", 21738, 817);
        raceList.appendLast(testRace2);
        System.out.println(raceList.toString());
        assertEquals("[[Asian, 8273, 0.1%], [LatinX, 21738, 0%]]", raceList.toString());   
    }
    
    
}
