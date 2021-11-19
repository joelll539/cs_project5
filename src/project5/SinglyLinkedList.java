package project5;

import java.util.Iterator;

public class SinglyLinkedList<T> implements Iterable<T> {
    private Node<T> head;
    
    public SinglyLinkedList(Node<T> head) {
        this.head = head;
    }
    
    public SinglyLinkedList(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            this.appendLast(arr[i]);
        }
    }
    
    public SinglyLinkedList() {
        head = null;
    }
    
    public Node<T> getHead() {
        return head;
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
        
        curr.setNextNode(new Node<T>(data));
    }
    
    public void appendFirst(T data) {
        Node<T> newNode = new Node<T>(data);
        
        if (head == null) {
            head = newNode;
        }
        
        newNode.setNextNode(head);
        head = newNode;
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        LinkedListIterator iter = new LinkedListIterator(head);
        sb.append("[");
        
        
        
        while (iter.hasNext()) {
            sb.append(iter.next().toString());
            
            if (iter.hasNext()) {
                sb.append(", ");
            }
        }
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
            return curr.getNextNode() != null;
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

}
