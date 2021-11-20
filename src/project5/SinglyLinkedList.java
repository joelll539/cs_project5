package project5;

import java.lang.reflect.Array;
import java.util.Iterator;

/**
 * This is a linked list
 * @author joell
 *
 * @param <T> is the type
 */
public class SinglyLinkedList<T extends Comparable<T>> implements Iterable<T> {
    private Node<T> head;
    private int size;

    public SinglyLinkedList(Node<T> head) {
        this.head = head;
        size = 1;
    }


    public SinglyLinkedList(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            this.appendLast(arr[i]);
        }
        size = arr.length;
    }


    public SinglyLinkedList() {
        head = null;
        size = 0;
    }


    public Node<T> getHead() {
        return head;
    }

    public int getSize() {
        return size;
    }

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


    public void sort() {
        T[] arr = this.toArray();
        int smol;
        T temp;

        for (int i = 0; i < arr.length; i++) {
            smol = i;
            for (int k = i; k < arr.length; k++) {
                if (arr[k].compareTo(arr[smol]) < 0) {
                    smol = k;
                }
            }
            temp = arr[i];
            arr[i] = arr[smol];
            arr[smol] = temp;
        }
        SinglyLinkedList<T> newList = new SinglyLinkedList<T>(arr);
        head = newList.getHead();
    }


    public void setHead(Node<T> newHead) {
        head = newHead;
    }


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

    class LinkedListIterator implements Iterator<T> {
        private Node<T> curr;

        public LinkedListIterator(Node<T> head) {
            curr = head;
        }


        @Override
        public boolean hasNext() {
            if (curr == null) {
                return false;
            }

            return true;
        }


        @Override
        public T next() {
            T data = curr.getData();
            curr = curr.getNextNode();
            return data;
        }

    }

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
         * @param data
         *            stores the data
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

}
