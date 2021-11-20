package project5;
import student.TestCase;

public class DataReaderTest extends TestCase {
    private DataReader reader;
    
    public void testDataReader() {
        reader = new DataReader(
                "Cases_and_Deaths_by_race_CRDT_Sep2020.csv");
    }
}
