package project5;

/**
 * 
 * @author Akshath Majumder
 * @version 11.17.2021
 *
 */
public class NodeTest extends student.TestCase {
    private Node<String> nodeaks;
    private Node<String> nodebobby;
    private Node<String> nodekkr;
    private Node<String> nodegunhaar;

    /**
     * Set up method
     */
    public void setUp() {
        nodeaks = new Node<String>("aks");
        nodebobby = new Node<String>("bobby");
        nodekkr = new Node<String>("kkr");

    }


    /**
     * Tests the set next node node method
     */
    public void testsetNextNode() {
        nodekkr.setNextNode(nodeaks);
        assertEquals(nodeaks, "aks");
    }


    /**
     * Tests the set data method
     */

    public void testsetData() {
        nodeaks.setData("ball");
        assertEquals(nodeaks, "ball");
    }

}
