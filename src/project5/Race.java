package project5;

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
        return 0;
        
    }
    
    public String toString() {
        return "[" + name + ", " + cases + ", " + cfr + "]";
    }
    
}
