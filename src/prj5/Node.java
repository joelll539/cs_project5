package prj5;

/**
 * 
 * @author Akshath Majumder
 * @author Joel
 * @author Tomas
 * @version 11.17.2021
 *
 * @param <T> is the type
 */
public class Node<T> {
    private T data;
    private Node<T> a;

    /**
     * This makes a new
     * @param data stores the data
     */
    public Node(T data) {
        this.data = data;
        a = null;
    }


    /**
     * takes the new entry and
     * sets it as next node
     * 
     * @param entry
     *            is the new entry being added
     * @param node
     *            is the new node
     */

    public Node(T entry, Node<T> node) {
        this(entry);
        this.setNextNode(node);
    }


    /**
     * Gets the data
     * @return returns the data
     */
    public T getData() {
        return this.data;
    }


    /**
     * Gets the next node
     * @return the next node
     */
    public Node<T> getNextNode() {
        return this.a;
    }


    /**
     * Sets the next node
     * @param nextNode
     *            takes the latest node
     *            and makes it the next node of the stack
     */
    public void setNextNode(Node<T> nextNode) {
        this.a = nextNode;
    }


    /**
     * set data
     * 
     * @param data is the data
     */
    public void setData(T data) {
        this.data = data;
    }

}
