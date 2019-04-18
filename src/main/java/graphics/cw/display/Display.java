package graphics.cw.display;

import graphics.cw.particles.Thing;
import graphics.cw.particles.Vector2D;
import processing.core.PApplet;

import java.awt.*;

public class Display {

    private static PApplet sketch;

    public Display(PApplet sketch) {
        this.sketch = sketch;
    }

    public void drawCircle(Vector2D location, double size, Color color) {
        this.sketch.pushMatrix();
        sketch.translate((float) location.getX(), (float) location.getY());
        this.sketch.noStroke();
        this.sketch.fill(color.getRGB());
        sketch.ellipseMode(2);
        sketch.ellipse(0, 0, (float) size, (float) size);
        this.sketch.popMatrix();
    }
}
