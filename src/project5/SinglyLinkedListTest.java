package project5;
import student.TestCase;

public class SinglyLinkedListTest extends TestCase {
    SinglyLinkedList<String> list;
    
    public void setUp() {
        list = new SinglyLinkedList<String>();
    }
    
    public void testAppendFirst() {
        list.appendFirst(1 + "");
        list.appendFirst(2 + "");
        System.out.println(list.toString());
    }
}
