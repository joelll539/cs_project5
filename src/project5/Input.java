package project5;

import java.util.ArrayList;

/**
 * This is where the project will be run from
 * 
 * @author joell
 * @author akshath
 * @author tomasg
 * @version 11.19.2021
 *
 */
public class Input {
    /**
     * This is the main method
     * @param args are the arguments
     */
    public static void main(String[] args) {
        if (args.length == 1) {
            DataReader reader = new DataReader(args[0]);
            ArrayList<State> states = reader.getStates();
            
            for (State s : states) {
                System.out.print(s.toString());
            }
        }
        else {
            DataReader reader = new DataReader("Cases_and_Deaths_by_race_CRDT_Sep2020.csv");
            ArrayList<State> states = reader.getStates();
            
            for (State s : states) {
                System.out.print(s.toString());
            }
        }

    }

}
