package project5;

/**
 * 
 * @author tomasg
 *
 */
public class State {

    private String name;
    private SinglyLinkedList<Race> races;

    /**
     * Constructor initializes fields from inputs for class
     * 
     * @param n
     *            name of the state
     * @param stat
     *            list for state statistics
     */
    public State(String n, SinglyLinkedList<Race> race) {
        name = n;
        races = race;
    }
    
    /**
     * 
     * @return
     */
    public SinglyLinkedList<Race> getRaces() {
        return races;
    }
    
    /**
     * 
     * @return
     */
    public String getName() {
        return name;
    }
    
    /**
     * 
     * @return
     */
    public String toString() {
        StringBuilder nameString = new StringBuilder();
        nameString.append(name);
        return nameString.toString();        
    }

}
