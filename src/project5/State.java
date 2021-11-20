package project5;

/**
 * 
 * @author tomasg
 *
 */
public class State {

    private String name;
    private SinglyLinkedList<Race> races;
    private SinglyLinkedList<Race> racesCfr;

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
        sortCFR();
        racesCfr = race;
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
        Race[] arr = races.toArray();
        Race[] arr2 = racesCfr.toArray();
        StringBuilder nameString = new StringBuilder();
        nameString.append(name + "\n");
        for (int i = 0; i < arr.length; i++) {
            nameString.append(arr[i].toString() + "\n");
        }
        nameString.append("=====\n");
        for (int j = 0; j < arr2.length; j++) {
            nameString.append(arr2[j].toString() + "\n");
        }
        nameString.append("=====");
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
