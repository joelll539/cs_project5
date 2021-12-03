package prj5;

import java.awt.Color;
import cs2.CircleShape;
import cs2.Shape;
import cs2.TextShape;
import cs2.Window;
import cs2.WindowSide;


public class GUICovidWindow {
    private Window window;
    
    /**
     * 
     * while( i< races.getLength()) {
     * y += BAR_SPACE_CONSTANT;
     * System.out.println(races.getEntry(i));
     * double height = BAR_HEIGHT_CONSTANT * races.getEntry(i).calcCFR();
     * bar = new Shape(y, 40, BAR_WIDTH_CONSTANT, (int) height, Color.BLUE);
     * window.addShape(bar);
     * String CFR = races.getEntry(i).calcCFR() + "R";
     * text = new TextShape(30, y, CFR, Color.black};
     * window.addShape(text);
     * i++;
