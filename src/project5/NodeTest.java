package project5;
import student.TestCase;
/**
 * 
 * @author Akshath Majumder
 * @version 11.17.2021
 *
 */
public class NodeTest extends TestCase {
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


    /**
     * Tests the get data method
     */
    public void testgetData() {
        nodeaks.getData();

    }


    /**
     * Tests the get data method again
     */

    public void testgetData1() {
        nodebobby.getData("bobby");
    }


    /**
     * Gets next node
     */

    public void getNextNode() {
        nodebobby.setNextNode(nodeaks);
        assertEquals(nodebobby.getNextNode(nodeaks));
    }

}
