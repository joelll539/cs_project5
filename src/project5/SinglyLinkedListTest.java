package project5;
import student.TestCase;

public class SinglyLinkedListTest extends TestCase {
    SinglyLinkedList<String> list;
    SinglyLinkedList<Race> raceList;
    
    public void setUp() {
        list = new SinglyLinkedList<String>();
        raceList = new SinglyLinkedList<Race>();
    }
    
    public void testAppendFirst() {
        Race someRace = new Race("asdf", 4f, 2f);
        Race someRace2 = new Race("qwer", 5f, 2f);
        raceList.appendFirst(someRace);
        raceList.appendFirst(someRace2);
        System.out.println(raceList.toString());
        
      //L
        DataReader asdf = new DataReader("Cases_and_Deaths_by_race_RANDOM_NUMBERS.csv");
        
        list.appendFirst(1 + "");
        list.appendFirst(2 + "");
        System.out.println(list.toString());
        
        
    }
}
