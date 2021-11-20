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
        sortAlpha();
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

    /**
     * This sorts the races alphabetically
     */
    public void sortAlpha() {
        Race[] arr = races.toArray();
        int smol;
        Race temp;

        for (int i = 0; i < arr.length; i++) {
            smol = i;
            for (int k = i; k < arr.length; k++) {
                if (arr[k].getName().compareTo(
                    arr[smol].getName()) < 0) {
                    smol = k;
                }
            }
            temp = arr[i];
            arr[i] = arr[smol];
            arr[smol] = temp;
        }
        races = new SinglyLinkedList<Race>(arr);
    }
    
    public void sortCFR() {
        races.sort();
    }
}
