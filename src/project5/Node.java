package project5;

/**
 * 
 * @author Akshath Majumder
 * @author Joel
 * @author Tomas
 * @version 11.17.2021
 *
 * @param <T>
 */
public class Node<T> {
    private T data;
    private Node<T> a;

    /**
     * 
     * @param data
     *            stores the data
     */
    public Node(T data) {
        this.data = data;
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
     * 
     * @return returns the data
     */
    public T getData() {
        return this.data;
    }


    /**
     * 
     * @return the next node
     */
    public Node<T> getNextNode() {
        return this.a;
    }


    /**
     * 
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
     * @param data
     */
    public void setData(T Data) {
        this.data = Data;
    }

}
