package project5;

import java.text.DecimalFormat;

public class Race implements Comparable<Race> {
    private String name;
    private double cases;
    private double cfr;
    
    public Race(String name, double cases, double deaths) {
        this.name = name;
        this.cases = cases;
        cfr = calcCFR(deaths);
    }
    
    private double calcCFR(double deaths) {
        if (cases == -1 || deaths == -1) {
            return -1;
        }
        
        return deaths / cases;
    }
    
    public String getName() {
        return name;
    }
    
    public double getCases() {
        return cases;
    }
    
    public double getCFR() {
        return cfr;
    }

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
    
    public String toString() {
        DecimalFormat percent = new DecimalFormat("#.#");
        DecimalFormat asInt = new DecimalFormat("#");
        return name + ": " + asInt.format(cases) + " cases, " + percent.format(cfr) + "% CFR";
    }
    
}
