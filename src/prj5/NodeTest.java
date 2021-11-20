package prj5;

import student.TestCase;

/**
 * This tests tests the node class
 * 
 * @author Akshath Majumder
 * @author tomasg
 * @author joell
 * @version 11.17.2021
 *
 */
public class NodeTest extends TestCase {
    private Node<String> nodeaks;
    private Node<String> nodebobby;
    private Node<String> nodekkr;
    private Node<String> nodegunhaar;
    @SuppressWarnings("unused")
    private Node<String> uselessNode;

    /**
     * Set up method
     */
    public void setUp() {
        nodeaks = new Node<String>("aks");
        nodebobby = new Node<String>("bobby");
        nodekkr = new Node<String>("kkr");
        uselessNode = new Node<String>("Sakura", nodekkr);
    }


    /**
     * Tests the set next node node method
     */
    public void testsetNextNode() {
        nodekkr.setNextNode(nodeaks);
        assertEquals(nodekkr.getNextNode(), nodeaks);
    }


    /**
     * Tests the set data method
     */

    public void testsetData() {
        nodeaks.setData("ball");
        assertEquals(nodeaks.getData(), "ball");
    }


    /**
     * Tests the get data method
     */
    public void testgetData() {
        nodeaks.getData();
        assertEquals(nodeaks.getData(), "aks");

    }


    /**
     * Tests the get data method again
     */

    public void testgetData1() {
        nodebobby.getData();
        assertEquals(nodebobby.getData(), "bobby");
    }


    /**
     * Gets next node
     */

    public void testgetNextNode() {
        nodebobby.setNextNode(nodeaks);
        assertEquals(nodebobby.getNextNode(), nodeaks);
    }


    /**
     * gets next node
     */
    public void testgetNextNode1() {
        nodeaks.setNextNode(nodegunhaar);
        assertEquals(nodeaks.getNextNode(), nodegunhaar);
    }

}
