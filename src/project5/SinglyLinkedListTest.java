package project5;
import student.TestCase;

public class SinglyLinkedListTest extends TestCase {
    SinglyLinkedList<String> list;
    
    public void setUp() {
        list = new SinglyLinkedList<String>();
    }
    
    public void testAppendFirst() {
        list.appendFirst(1 + "");
        Node<Integer> someNode = new Node<Integer>(1);
        assertNull(someNode.getNextNode());
        someNode = someNode.getNextNode();
        assertNull(someNode);
        System.out.println(list.toString());
    }
}
