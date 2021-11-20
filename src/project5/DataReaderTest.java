package project5;
import java.util.ArrayList;
import student.TestCase;

public class DataReaderTest extends TestCase {
    private DataReader reader;
    
    public void testDataReader() {
        reader = new DataReader(
                "Cases_and_Deaths_by_race_CRDT_Sep2020.csv");
        ArrayList<State> daStates = reader.getStates();
        for (State s : daStates) {
            System.out.print(s.toString());
        }
    }
}
