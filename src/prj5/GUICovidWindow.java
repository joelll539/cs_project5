package prj5;

import java.awt.Color;
import cs2.Button;
import cs2.Shape;
import cs2.TextShape;
import cs2.Window;
import cs2.WindowSide;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.color.*;

public class GUICovidWindow {
    
    private DataReader covidList;
    
    private Window window;
    private Button quit;
    private Button alphSort;
    private Button cfrSort;
    private Button dc;
    private Button ga;
    private Button md;
    private Button nc;
    private Button tn;
    private Button va;
    
    private ArrayList<State> states;

    public static final int BAR_GAP = 100;
    public static final int BAR_HEIGHT = 50;
    public static final int BAR_WIDTH = 50;

    public GUICovidWindow() {
        
        states = new ArrayList<State>();
        
        quit = new Button("Quit");
        alphSort = new Button("Sort Alphabetically");
        cfrSort = new Button("Sort by CFR");
        dc = new Button("Represent DC");
        ga = new Button("Represent GA");
        md = new Button("Represent MD");
        nc = new Button("Represent NC");
        tn = new Button("Represent TN");
        va = new Button("Represent VA");        
        quit.onClick(this, "clickedQuit");
        alphSort.onClick(this, "sortAlphabetically");
        cfrSort.onClick(this, "sortCfr");
        dc.onClick(this, "representState");
        ga.onClick(this, "representState");
        md.onClick(this, "representState");
        nc.onClick(this, "representState");
        tn.onClick(this, "representState");
        va.onClick(this, "representState");
        
        window = new Window("Covid Visualization");
        
        window.addButton(alphSort, WindowSide.WEST);
        window.addButton(quit, WindowSide.NORTH);
        window.addButton(cfrSort, WindowSide.WEST);
        window.addButton(dc, WindowSide.SOUTH);
        window.addButton(ga, WindowSide.SOUTH);
        window.addButton(md, WindowSide.SOUTH);
        window.addButton(nc, WindowSide.SOUTH);
        window.addButton(tn, WindowSide.SOUTH);
        window.addButton(va, WindowSide.SOUTH);
        
    }
    
    public void drawRectangles(SinglyLinkedList<Race> races) {
        window.removeAllShapes();
        int shapeX = 20;
        int shapeY = 20;
        Iterator<Race> aks = races.iterator();
        for (Race curr : races) {
            int height = (int)curr.getCFR() * 50;
            int width = BAR_WIDTH;
            Shape bar = new Shape(shapeX, shapeY, width, height, Color.BLUE);
            window.addShape(bar);
            shapeX += BAR_GAP;
        }
    }
    
    public void representState(Button stateButton) {
        
    }
    
    public void clickedQuit(Button quitButton) {
        System.exit(0);;
    }
    
    public void sortAlphabetically(Button alpSort) {
        window.removeAllShapes();
        
    }
    
    public void sortCfr(Button cfrSort) {
        window.removeAllShapes();
        
    }
    
}
