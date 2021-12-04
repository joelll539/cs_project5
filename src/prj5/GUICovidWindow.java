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
    private State currState;
    private String currSort;
    
    /**
    private Button dc;
    private Button ga;
    private Button md;
    private Button nc;
    private Button tn;
    private Button va;
    */
    
    private ArrayList<State> states;
    private Button[] stateButtons;

    public static final int BAR_GAP = 100;
    public static final int BAR_HEIGHT = 50;
    public static final int BAR_WIDTH = 50;

    /**
     * This puts all of the stuff in the window
     * @param reader is where the data comes from
     */
    public GUICovidWindow(DataReader reader) {
        currSort = "cfr";
        window = new Window("Covid Visualization");
        states = reader.getStates();
        stateButtons = new Button[states.size()];
        this.makeButtons();
        
        quit = new Button("Quit");
        alphSort = new Button("Sort Alphabetically");
        cfrSort = new Button("Sort by CFR");
        
        /**
        dc = new Button("Represent DC");
        ga = new Button("Represent GA");
        md = new Button("Represent MD");
        nc = new Button("Represent NC");
        tn = new Button("Represent TN");
        va = new Button("Represent VA");
        */
        
        quit.onClick(this, "clickedQuit");
        alphSort.onClick(this, "sortAlphabetically");
        cfrSort.onClick(this, "sortCfr");
        
        /**
        dc.onClick(this, "representState");
        ga.onClick(this, "representState");
        md.onClick(this, "representState");
        nc.onClick(this, "representState");
        tn.onClick(this, "representState");
        va.onClick(this, "representState");
        */
        
        
        
        window.addButton(alphSort, WindowSide.WEST);
        window.addButton(quit, WindowSide.NORTH);
        window.addButton(cfrSort, WindowSide.WEST);
        /**
        window.addButton(dc, WindowSide.SOUTH);
        window.addButton(ga, WindowSide.SOUTH);
        window.addButton(md, WindowSide.SOUTH);
        window.addButton(nc, WindowSide.SOUTH);
        window.addButton(tn, WindowSide.SOUTH);
        window.addButton(va, WindowSide.SOUTH);
        */
        
    }
    
    /**
     * This is supposed to take in a state and draw all the information
     * it has onto the window, exactly how it is shown in the project 5
     * description on canvas
     * 
     * 
     * @param states
     */
    public void drawRectangles(State someState) {
        window.removeAllShapes();
        int shapeX = 20;
        int shapeY = 20;
        SinglyLinkedList<Race> aks = someState.getRaces();
        for (Race curr : aks) {
            int height = (int)curr.getCFR() * 50;
            int width = BAR_WIDTH;
            Shape bar = new Shape(shapeX, shapeY, width, height, Color.BLUE);
            window.addShape(bar);
            shapeX += BAR_GAP;
        }
    }
    
    /**
     * This makes all the state buttons
     */
    private void makeButtons() {
        for (int i = 0; i < stateButtons.length; i++) {
            stateButtons[i] = new Button("Represent " + states.get(i).getName());
            stateButtons[i].onClick(this, "representState");
            window.addButton(stateButtons[i], WindowSide.SOUTH);
        }
    }
    
    /**
     * Represents the state that was clicked
     * @param stateButton is the button
     */
    public void representState(Button stateButton) {
        String stateName = stateButton.getTitle().substring(10);
        
        //This gets the correct state
        for (State s : states) {
            if (s.getName().equals(stateName)) {
                currState = s;
                break;
            }
        }
        
        //This decides how to sort the information
        if (currSort.equals("alpha")) {
            currState.sortAlpha();
        }
        else {
            currState.sortCFR();
        }
        
        drawRectangles(currState);
    }
    
    /**
     * This closes the window
     * @param quitButton the button that was clicked
     */
    public void clickedQuit(Button quitButton) {
        System.exit(0);
    }
    
    /**
     * This sorts the data alphabetically
     * @param alphSort the button that was clicked
     */
    public void sortAlphabetically(Button alphSort) {
        currSort = "alpha";
        window.removeAllShapes();
        currState.sortAlpha();
        drawRectangles(currState);
    }
    
    /**
     * Sorts the data based on cfr
     * @param cfrSort the button that was clicked
     */
    public void sortCfr(Button cfrSort) {
        currSort = "cfr";
        window.removeAllShapes();
        currState.sortCFR();
        drawRectangles(currState);
    }
    
}
