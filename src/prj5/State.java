package prj5;

/**
 * This is a state
 * 
 * @author tomasg
 * @author joell
 * @author akshath
 * @version 2021.11.20
 */
public class State {

    private String name;
    private SinglyLinkedList<Race> races;

    /**
     * Constructor initializes fields from inputs for class
     * 
     * @param n name of the state
     * @param race is the races
     */
    public State(String n, SinglyLinkedList<Race> race) {
        name = n;
        races = race;
        sortCFR();
    }
    
    /**
     * gets the races
     * @return the races
     */
    public SinglyLinkedList<Race> getRaces() {
        return races;
    }
    
    /**
     * Gets the name
     * @return the name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Makes a string from the state
     * @return the string
     */
    public String toString() {
        sortAlpha();
        StringBuilder sb = new StringBuilder();
        
        sb.append(name + "\n");
        for (Race r : races) {
            sb.append(r.toString() + "\n");
        }
        sb.append("=====" + "\n");
        sortCFR();
        
        for (Race r : races) {
            sb.append(r.toString() + "\n");
        }
        sb.append("=====" + "\n");
        
        return sb.toString();
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
    
    /**
     * This sorts by CFR
     */
    public void sortCFR() {
        races.sort();
    }
}
