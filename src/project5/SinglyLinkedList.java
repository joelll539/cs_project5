package project5;

import java.util.Iterator;

public class SinglyLinkedList<T> implements Iterable<T> {
    private Node<T> head;
    
    public SinglyLinkedList(Node<T> head) {
        this.head = head;
    }
    
    public Node<T> getHead() {
        return head;
    }
    
    public void setHead(Node<T> newHead) {
        head = newHead;
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
            return curr.getNext() != null;
        }

        @Override
        public T next() {
            T data = curr.getData();
            curr = curr.getNext();
            return data;
        }
        
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator(head);
    }

}
