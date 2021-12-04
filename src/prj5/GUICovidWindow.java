package prj5;

import java.awt.Color;
import cs2.Button;
import cs2.Shape;
import cs2.TextShape;
import cs2.Window;
import cs2.WindowSide;
import java.util.ArrayList;
import java.text.DecimalFormat;

public class GUICovidWindow {

    private DataReader covidList;

    private Window window;
    private Button quit;
    private Button alphSort;
    private Button cfrSort;
    private State currState;
    private String currSort;

    /**
     * private Button dc;
     * private Button ga;
     * private Button md;
     * private Button nc;
     * private Button tn;
     * private Button va;
     */

    private ArrayList<State> states;
    private Button[] stateButtons;

    public static final int BAR_GAP = 100;
    public static final int BAR_HEIGHT = 50;
    public static final int BAR_WIDTH = 30;

    /**
     * This puts all of the stuff in the window
     * 
     * @param reader
     *            is where the data comes from
     */
    public GUICovidWindow(DataReader reader) {
        currSort = "cfr";
        currState = null;
        window = new Window("Covid Visualization");
        states = reader.getStates();
        stateButtons = new Button[states.size()];
        this.makeButtons();

        quit = new Button("Quit");
        alphSort = new Button("Sort Alphabetically");
        cfrSort = new Button("Sort by CFR");

        quit.onClick(this, "clickedQuit");
        alphSort.onClick(this, "sortAlphabetically");
        cfrSort.onClick(this, "sortCfr");

        window.addButton(alphSort, WindowSide.NORTH);
        window.addButton(quit, WindowSide.NORTH);
        window.addButton(cfrSort, WindowSide.NORTH);

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
        SinglyLinkedList<Race> aks = someState.getRaces();
        int shapeX = (window.getGraphPanelWidth() / 3) - 100;
        DecimalFormat cfr = new DecimalFormat("##.#");
        for (Race curr : aks) {
            int height = (int)curr.getCFR() * 25;
            int width = BAR_WIDTH;
            int shapeY = 240 - height;
            Shape bar = new Shape(shapeX + 8, shapeY, width, height,
                Color.BLUE);
            window.addShape(bar);
            if (curr.getCFR() == -1) {
                addText(shapeX + 8, 230, "NA");
                addText(shapeX, 250, curr.getName());
            }
            else {
                addText(shapeX, 250, curr.getName());
                addText(shapeX, 270, cfr.format(curr.getCFR()) + "%");
            }

            shapeX += BAR_GAP;
        }
    }


    /**
     * This makes all the state buttons
     */
    private void makeButtons() {
        for (int i = 0; i < stateButtons.length; i++) {
            stateButtons[i] = new Button("Represent " + states.get(i)
                .getName());
            stateButtons[i].onClick(this, "representState");
            window.addButton(stateButtons[i], WindowSide.SOUTH);
        }
    }


    /**
     * Adds text shape for name and cfr to the bar shape
     */
    private void addText(int x, int y, String stateName) {
        if (stateName != null) {
            TextShape name = new TextShape(x, y, stateName);
            name.setBackgroundColor(Color.WHITE);
            window.addShape(name);
        }
    }


    /**
     * Represents the state that was clicked
     * 
     * @param stateButton
     *            is the button
     */
    public void representState(Button stateButton) {
        String stateName = stateButton.getTitle().substring(10);

        // This gets the correct state
        for (State s : states) {
            if (s.getName().equals(stateName)) {
                currState = s;
                break;
            }
        }

        // This decides how to sort the information
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
     * 
     * @param quitButton
     *            the button that was clicked
     */
    public void clickedQuit(Button quitButton) {
        System.exit(0);
    }


    /**
     * This sorts the data alphabetically
     * 
     * @param alphSort
     *            the button that was clicked
     */
    public void sortAlphabetically(Button alphSort) {
        if (currState == null) {
            return;
        }
        
        currSort = "alpha";
        window.removeAllShapes();
        currState.sortAlpha();
        drawRectangles(currState);
    }


    /**
     * Sorts the data based on cfr
     * 
     * @param cfrSort
     *            the button that was clicked
     */
    public void sortCfr(Button cfrSort) {
        if (currState == null) {
            return;
        }
        
        currSort = "cfr";
        window.removeAllShapes();
        currState.sortCFR();
        drawRectangles(currState);
    }

}
