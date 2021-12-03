package prj5;

import java.awt.Color;
import cs2.CircleShape;
import spacecolonies.Person;

public class GUICovidWindow {
    /**
     * private void drawRectangles() {
     * /**
     * Initialize the window by adding the rectangles
     */
    int shapeX = QUEUE_STARTX;
    int shapeY = QUEUE_STARTY;

    /**
         * create an object array of queue and create circle shapes for each
         * element in
         * the array and add to the partyCircles list
         */
        Object[] queuedParties = {};if(colonyCalculator.getQueue()!=null)
    {
        queuedParties = colonyCalculator.getQueue().toArray();
    }for(
    int i = 0;i<queuedParties.length;i++)
    {
        int shapeSize = CIRCLE_SIZE * DISPLAY_FACTOR;
        int planetPreference = colonyCalculator.getPlanetIndex(
            ((Person)queuedParties[i]).getPlanetPreference());

        CircleShape shape = new CircleShape(shapeX, shapeY - shapeSize / 2,
            shapeSize);

        switch (planetPreference) {
            case 0:
                shape.setForegroundColor(PLANET_COLORS[0]);
                shape.setBackgroundColor(Color.BLACK);
                break;
            case 1:
                shape.setForegroundColor(PLANET_COLORS[1]);
                shape.setBackgroundColor(Color.BLACK);
                break;
            case 2:
                shape.setForegroundColor(PLANET_COLORS[2]);
                shape.setBackgroundColor(Color.BLACK);
                break;
            default:
                shape.setForegroundColor(PLANET_COLORS[6]);
                shape.setBackgroundColor(Color.BLACK);
                break;
        }

        personCircles.add(shape);
        shapeX = shapeX + shapeSize + 5;
    }

    /**
     * add the circles to the window
     */
    for(
    int i = 0;i<personCircles.getLength();i++)
    {
            window.addShape(personCircles.getEntry(i));
        }
    
}*/}
