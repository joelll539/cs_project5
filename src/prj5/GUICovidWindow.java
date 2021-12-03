package prj5;

import java.awt.Color;
import cs2.CircleShape;
import cs2.Shape;
import cs2.TextShape;
import cs2.Window;
import cs2.WindowSide;
import java.util.Iterator;
import java.awt.color.*;

public class GUICovidWindow {
    private Window window;

    public static final int BAR_GAP = 100;
    public static final int BAR_HEIGHT = 50;
    public static final int BAR_WIDTH = 50;

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
}
