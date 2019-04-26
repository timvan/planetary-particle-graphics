package graphics.cw.display;

import graphics.cw.particles.Thing;
import graphics.cw.particles.Vector2D;
import processing.core.PApplet;
import processing.core.PFont;

import java.awt.*;

public class Display {

    private static PApplet sketch;

    public Display(PApplet sketch) {
        this.sketch = sketch;
    }

    public void drawCircle(Vector2D location, double size, Color color) {
        sketch.pushMatrix();
        sketch.translate((float) location.getX(), (float) location.getY());
        sketch.noStroke();
        sketch.fill(color.getRGB());
        sketch.ellipseMode(2);
        sketch.ellipse(0, 0, (float) size, (float) size);
        sketch.popMatrix();
    }

    public void drawText(Vector2D location, double size, Color color, String s) {
        sketch.pushMatrix();
        sketch.translate((float) location.getX(), (float) location.getY());
        sketch.textAlign(3, 3);
        sketch.textSize((float) size);
        sketch.fill(color.getRGB());
        sketch.text(s, 0, 0);
        sketch.popMatrix();
    }

}
