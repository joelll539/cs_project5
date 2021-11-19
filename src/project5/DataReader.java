package project5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataReader {
    private SinglyLinkedList<State> states;
    private ArrayList<String> raceNames;
    private String[] raceInfo;
    private int firstDeathStat;
    
    public DataReader(String file) {
        raceNames = new ArrayList<String>();
        states = new SinglyLinkedList<State>();
        
        try {
            readFile(file);
        }
        catch (Exception e) {
            System.out.println("File oof");
        }
    }
    
    private void readFile(String file) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(file));
        String[] strings;
        raceInfo = scanner.nextLine().split(",");
        State newState;

        for (int i = 1; i < raceInfo.length; i++) {
            if (raceInfo[i].contains("Deaths")) {
                firstDeathStat = i;
                break;
            }
            raceNames.add(raceInfo[i].substring(6));
        }
        
        while (scanner.hasNextLine()) {
            strings = scanner.nextLine().split(",");
            //newState = stateMaker(strings);
            stateMaker(strings);
            //states.appendFirst(newState);
        }        
        
    }
    
    private void stateMaker(String[] strings) {
        State newState;
        SinglyLinkedList<Race> races = new SinglyLinkedList<Race>();
        float[][] stats = new float[firstDeathStat - 1][2];
        int statPointer = 0;
        int k = 0;
        
        //Makes an array of the stats
        for (int i = 1; i < strings.length; i++) {
            if (i == this.firstDeathStat) {
                k = 1;
                statPointer = 0;
            }
            stats[statPointer][k] = Float.parseFloat(strings[i]);
            statPointer++;
        }
        
        //Makes the race list for the states
        for (int i = 0; i < stats.length; i++) {
            races.appendFirst(new Race(raceNames.get(i), stats[i][0], stats[i][1]));
        }
        
        //Makes the new state
        //newState = new State(strings[0], races);
        System.out.println(races.toString());
        
        //return newState;
    }
    
    public SinglyLinkedList<State> getStates() {
        return states;
    }
}
