package prj5;

import java.text.DecimalFormat;

/**
 * This is a race
 * @author joell
 * @author akshath
 * @author tomasg
 * @version 2021.11.20
 */
public class Race implements Comparable<Race> {
    private String name;
    private double cases;
    private double cfr;
    
    /**
     * Makes a new race
     * @param name is the name
     * @param cases is the cases
     * @param deaths is the deaths
     */
    public Race(String name, double cases, double deaths) {
        this.name = name;
        this.cases = cases;
        cfr = calcCFR(deaths);
    }
    
    /**
     * Calculates the cfr
     * @param deaths is the deaths
     * @return the cfr
     */
    private double calcCFR(double deaths) {
        if (cases == -1 || deaths == -1) {
            return -1.0;
        }
        
        return (deaths / cases) * 100;
    }
    
    /**
     * Gets the name
     * @return the name
     */
    public String getName() {
        return name;
    }
    
    /**
     * gets the cases
     * @return the cases
     */
    public double getCases() {
        return cases;
    }
    
    /**
     * Gets the cfr
     * @return the cfr
     */
    public double getCFR() {
        return cfr;
    }

    /**
     * Compares races
     * @param other is the other race
     * @return an int representing greater
     * than or less than
     */
    @Override
    public int compareTo(Race other) {
        if (cfr > other.getCFR()) {
            return -1;
        }
        if (other.getCFR() > cfr) {
            return 1;
        }
        return name.compareTo(other.getName());
        
    }
    
    /**
     * Makes a string from the race data
     * @return the string
     */
    public String toString() {
        DecimalFormat formatter = new DecimalFormat("#.#");
        return this.getName() + ": " + 
            formatter.format(this.getCases()) 
            + " cases, " + formatter.format(this.getCFR()) + "% CFR";
    }
    
}
