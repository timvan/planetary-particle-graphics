package graphics.cw.gui.InfoButton;

import graphics.cw.display.Display;
import graphics.cw.display.TextAlign;
import graphics.cw.display.RGB;
import graphics.cw.particles.Vector2D;

import java.awt.*;
import java.util.ArrayList;


/***
 * An information box explaining the game
 */
public class InfoBox {
    private int x;
    private int y;
    private int width;
    private int height;
    private int textSize = 14;
    private int maxLength;

    private ArrayList<String> contents;

    public InfoBox(int x, int y) {

        contents = new ArrayList<>();
        contents.add("WELCOME TO GRAVITY SIM");
        contents.add("There's no aim, just create and play");
        contents.add("");
        contents.add("Move things by dragging them");
        contents.add("Click on them to change them");
        contents.add("You can add and delete stuff");
        contents.add("You can change the mass of features");
        contents.add("Silders change maxSpeed and spawn rate");
        contents.add("");
        contents.add("Add stuff by pressing:");
        contents.add("1  add spawner");
        contents.add("2  add attractor");
        contents.add("3  add repeller");
        contents.add("");
        contents.add("Change mass by hovering and pressing:");
        contents.add("-  shrink radius");
        contents.add("+  enlarge radius");
        contents.add("[  decrease density");
        contents.add("]  increase density");
        contents.add("");
        contents.add("x  delete feature");
        contents.add("c  clear everything");
        contents.add("r  clear particles");

        this.x = x;
        this.y = y;

        this.maxLength = 0;
        for(String s : contents){
            maxLength = maxLength < s.length() ? s.length() : maxLength;
        }
        this.width = maxLength * 8;
        this.height = contents.size() * textSize + 5;
    }

    public void draw(Display display) {
        display.drawRect(x, y, width, height, new RGB(255, 255, 179));
        int i = 0;
        for(String line : contents){
            display.drawText(x + 5, y + i * textSize, textSize, Color.BLACK, line, TextAlign.CORNER);
            i++;
        }
    }

    public boolean isInside(int x, int y) {
        if(x >= this.x && x <= this.x + this.width) {
            if(y >= this.y && y <= this.y + this.height) {
                return true;
            }
        }
        return false;
    }
}
