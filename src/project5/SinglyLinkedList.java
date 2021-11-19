package project5;

import java.util.Iterator;

public class SinglyLinkedList<T> implements Iterable<T> {
    private Node<T> head;
    private int size;

    public SinglyLinkedList(Node<T> head) {
        this.head = head;
        size = 0;
    }


    public SinglyLinkedList(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            this.appendLast(arr[i]);
        }
        size = 0;
    }


    public SinglyLinkedList() {
        head = null;
        size = 0;
    }


    public Node<T> getHead() {
        return head;
    }


    public Object[] toArray() {
        Object[] arr = new Object[size];
        Node<T> curr = head;

        for (int i = 0; i < size; i++) {
            arr[i] = curr.getData();
            curr = curr.getNextNode();
        }

        return arr;
    }


    @SuppressWarnings("unchecked")
    public void sort() {
        T[] arr = (T[])this.toArray();
        T smol;
        T temp;

        for (int i = 0; i < size; i++) {
            smol = arr[i];
            for (int k = i; i < size; k++) {
            }
        }
    }


    public void setHead(Node<T> newHead) {
        head = newHead;
    }


    public void appendLast(T data) {
        Node<T> curr = head;

        if (head == null) {
            head = new Node<T>(data);
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
            return;
        }

        size++;
        newNode.setNextNode(head);
        head = newNode;
    }


    public String toString() {
        StringBuilder sb = new StringBuilder();
        LinkedListIterator iter = new LinkedListIterator(head);
        sb.append("[");
        Node<T> curr = head;

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
