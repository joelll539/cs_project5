package project5;

import java.util.ArrayList;

public class Input {

    public static void main(String[] args) {
        if (args.length == 1) {
            DataReader reader = new DataReader(args[0]);
            ArrayList<State> states = reader.getStates();
            for (int i = 0; i < states.size(); i++) {
                System.out.println(states.get(i).toString());
            }
        }
        
        else {
            DataReader reader = new DataReader("Cases_and_Deaths_by_race_CRDT_Sep2020.csv");
            ArrayList<State> states = reader.getStates();
            for (int i = 0; i < states.size(); i++) {
                System.out.println(states.get(i).toString());
            }
        }

    }

}
