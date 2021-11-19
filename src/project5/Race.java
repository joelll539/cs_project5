package project5;

public class Race implements Comparable<Race> {
    private String name;
    private float cases;
    private float cfr;
    
    public Race(String name, float cases, float deaths) {
        this.name = name;
        this.cases = cases;
        cfr = calcCFR(deaths);
    }
    
    private float calcCFR(float deaths) {
        return deaths / cases;
    }
    
    public String getName() {
        return name;
    }
    
    public float getCases() {
        return cases;
    }
    
    public float getCFR() {
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
    
}
