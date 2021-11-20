package project5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This reads the data
 * @author joell
 * @author akshath
 * @author tomasg
 *
 */
public class DataReader {
    private ArrayList<State> states;
    private ArrayList<String> raceNames;
    private String[] raceInfo;
    private int firstDeathStat;
    
    /**
     * This makes a new data reader
     * @param file
     */
    public DataReader(String file) {
        raceNames = new ArrayList<String>();
        states = new ArrayList<State>();
        
        try {
            readFile(file);
        }
        catch (Exception e) {
            System.out.println("File oof");
        }
    }
    
    /**
     * This reads the file
     * @param file is the file name
     * @throws FileNotFoundException when a file isn't found
     */
    private void readFile(String file) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(file));
        String[] strings;
        raceInfo = scanner.nextLine().split(",");
        State newState;

        //Gets the index of the first death statistic
        //Also gets the names of the races
        for (int i = 1; i < raceInfo.length; i++) {
            if (raceInfo[i].contains("Deaths")) {
                firstDeathStat = i;
                break;
            }
            raceNames.add(raceInfo[i].substring(6));
        }        
        //Goes through the lines to make string arrays
        while (scanner.hasNextLine()) {
            strings = scanner.nextLine().split(",");
            newState = stateMaker(strings);
            states.add(newState);
        }        
        
    }
    
    /**
     * This makes a state
     * @param strings is a bunch of strings
     * @return a new state
     */
    private State stateMaker(String[] strings) {
        State newState;
        SinglyLinkedList<Race> races = new SinglyLinkedList<Race>();
        float[][] stats = new float[firstDeathStat - 1][2];
        int statPointer = 0;
        int k = 0;
        
        //Makes an array of the statistics
        for (int i = 1; i < strings.length; i++) {
            if (i == this.firstDeathStat) {
                k = 1;
                statPointer = 0;
            }
            if (strings[i].equals("NA")) {
                stats[statPointer][k] = -1f;
                statPointer++;
                continue;
            }
            stats[statPointer][k] = Float.parseFloat(strings[i]);
            statPointer++;
        }
        
        //Makes the race list for the states
        for (int i = 0; i < stats.length; i++) {
            races.appendFirst(new Race(raceNames.get(i), stats[i][0], stats[i][1]));
        }
        
        //Makes the new state
        newState = new State(strings[0], races);        
        return newState;
    }
    
    /**
     * This gets the states
     * 
     * @return the states
     */
    public ArrayList<State> getStates() {
        return states;
    }
}
