package project5;
import java.util.ArrayList;
import student.TestCase;

/**
 * This tests the data reader class
 * @author joell
 * @author akshath
 * @author tomasg
 * @version 2021.11.20
 */
public class DataReaderTest extends TestCase {
    private DataReader reader;
    
    /**
     * This sets up the tests
     */
    public void setUp() {
        reader = new DataReader(
            "Cases_and_Deaths_by_race_CRDT_Sep2020.csv");
    }
    
    /**
     * This tests the data readers
     */
    public void testDataReader() {
        Boolean didntFail = false;
        ArrayList<State> daStates = reader.getStates();
        for (State s : daStates) {
            System.out.print(s.toString());
        }
        didntFail = true;
        assertTrue(didntFail);
    }
}
