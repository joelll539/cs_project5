package project5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DataReader {
    private SinglyLinkedList<State> states;
    
    public DataReader(String file) {
        states = new SinglyLinkedList<State>();
        
        try {
            readFile(file);
        }
        catch (Exception e) {
            
        }
    }
    
    private void readFile(String file) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(file));
        Node<State> newHead = null;
        Node<State> curr;
        String[] strings;
        State newState;
        
        while (scanner.hasNextLine()) {
            strings = scanner.nextLine().split(", *");
            newState = stateMaker(strings);
            
            if (newHead != null) {
                curr.setNext(newState);
                curr = curr.getNext();
            }
            else {
                newHead = new Node<State>(newState);
                curr = newHead;
            }            
        }        
        
    }
    
    private State stateMaker(String[] strings) {
        
    }
    
    public SinglyLinkedList<State> getStates() {
        return states;
    }
}
