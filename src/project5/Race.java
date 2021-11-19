package project5;

public class Race {
    private String name;
    private float cases;
    private String cfr;
    
    public Race(String name, float cases, float deaths) {
        this.name = name;
        this.cases = cases;
        cfr = calcCFR(deaths);
    }
    
    public String calcCFR(float deaths) {
        float percent = deaths / cases;
        return percent + "%";
    }
    
    public String getName() {
        return name;
    }
    
    public float getCases() {
        return cases;
    }
    
}
