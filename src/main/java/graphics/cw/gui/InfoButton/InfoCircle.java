package graphics.cw.gui.InfoButton;

import graphics.cw.display.ColorPalette;
import graphics.cw.display.Display;
import graphics.cw.display.TextAlign;
import graphics.cw.particles.Vector2D;

import java.awt.*;

/***
 * An info circle with ? question mark
 */
public class InfoCircle {
    Display display;

    private int radius = 15;
    private int x;
    private int y;

    public InfoCircle(Display display, int x, int y) {
        this.display = display;
        this.x = x;
        this.y = y;
    }

    public void draw() {
        this.display.drawCircle(new Vector2D(x, y), radius, Color.WHITE);
        this.display.drawCircle(new Vector2D(x, y), radius * 0.8, ColorPalette.background);
        this.display.drawText(new Vector2D(x, y), radius * 1.2, Color.WHITE, "?", TextAlign.CENTER);
    }

    public boolean isInside(int x, int y) {
        Vector2D point = new Vector2D(x, y);
        Vector2D dist = Vector2D.sub(new Vector2D(this.x, this.y), point);
        if(dist.mag() < radius) {
            return true;
        }
        return false;
    }

}
