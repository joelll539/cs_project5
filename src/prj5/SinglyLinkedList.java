package prj5;

import java.lang.reflect.Array;
import java.util.Iterator;

/**
 * This is a linked list
 * @author joell
 * @author tomasg
 * @author akshath
 * @version 2021.11.20
 *
 * @param <T> is the type
 */
public class SinglyLinkedList<T extends 
    Comparable<T>> implements Iterable<T> {
    private Node<T> head;
    private int size;

    /**
     * This makes a list with a head
     * @param head is the head
     */
    public SinglyLinkedList(Node<T> head) {
        this.head = head;
        size = 1;
    }

    /**
     * This makes a list from an array
     * @param arr is the array
     */
    public SinglyLinkedList(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            this.appendLast(arr[i]);
        }
        size = arr.length;
    }

    /**
     * This makes an empty list
     */
    public SinglyLinkedList() {
        head = null;
        size = 0;
    }

    /**
     * This gets the head
     * @return the head
     */
    public Node<T> getHead() {
        return head;
    }

    /**
     * This gets the size
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * Makes an array from the list
     * @return an array
     */
    public T[] toArray() {
        if (size == 0) {
            return null;
        }
        
        T thing = head.getData();
        @SuppressWarnings("unchecked")
        T[] arr = (T[]) Array.newInstance(thing.getClass(), size);
        Node<T> curr = head;

        for (int i = 0; i < size; i++) {
            arr[i] = curr.getData();
            curr = curr.getNextNode();
        }
        
        return arr;
    }

    /**
     * This sorts the list using compareTo
     */
    public void sort() {
        T[] arr = this.toArray();
        T temp;

        for (int i = 1; i < arr.length; i++) {
            for (int k = i; k > 0; k--) {
                if (arr[k].compareTo(arr[k - 1]) < 0) {
                    temp = arr[k - 1];
                    arr[k - 1] = arr[k];
                    arr[k] = temp;
                }
                else {
                    k = 0;
                }
            }
        }
        
        SinglyLinkedList<T> newList = new SinglyLinkedList<T>(arr);
        setHead(newList.getHead());
    }

    /**
     * This sets a new head
     * @param newHead is the new head
     */
    public void setHead(Node<T> newHead) {
        head = newHead;
    }

    /**
     * Appends item to end of the list
     * @param data is the item to append
     */
    public void appendLast(T data) {
        Node<T> curr = head;

        if (head == null) {
            head = new Node<T>(data);
            size++;
            return;
        }

        while (curr.getNextNode() != null) {
            curr = curr.getNextNode();
        }

        size++;
        curr.setNextNode(new Node<T>(data));
    }

    /**
     * Appends item to beginning of list
     * @param data is the item to append
     */
    public void appendFirst(T data) {
        Node<T> newNode = new Node<T>(data);

        if (head == null) {
            head = newNode;
            size++;
            return;
        }

        size++;
        newNode.setNextNode(head);
        head = newNode;
    }

    /**
     * Makes a string from the list
     * @return the string
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (T i : this) {
            sb.append(i.toString());
            sb.append(", ");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);

        sb.append("]");
        return sb.toString();
    }

    /**
     * This iterates through the linked list
     * @author joell
     *
     */
    class LinkedListIterator implements Iterator<T> {
        private Node<T> curr;

        /**
         * Makes a new LinkedListIterator from a node
         * @param head is the head of the list
         */
        public LinkedListIterator(Node<T> head) {
            curr = head;
        }

        /**
         * This checks whether there is a next item or not
         * @return whether there is a next item or not
         */
        @Override
        public boolean hasNext() {
            return curr != null;
        }

        /**
         * Gets the next item in the list
         * @return the next item in the list
         */
        @Override
        public T next() {
            T data = curr.getData();
            curr = curr.getNextNode();
            return data;
        }

    }

    /**
     * This makes the thing that iterates through list
     * @return the iterator
     */
    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator(head);
    }

    /**
     * 
     * @author Akshath Majumder
     * @author Joel
     * @author Tomas
     * @version 11.17.2021
     *
     * @param <T>
     */
    public static class Node<T> {
        private T data;
        private Node<T> a;

        /**
         * 
         * @param data stores the data
         */
        public Node(T data) {
            this.data = data;
            a = null;
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
         * @param data is the data
         */
        public void setData(T data) {
            this.data = data;
        }

    }

}
