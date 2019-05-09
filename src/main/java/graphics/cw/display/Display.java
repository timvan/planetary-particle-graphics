package graphics.cw.display;

import graphics.cw.particles.Thing;
import graphics.cw.particles.Vector2D;
import processing.core.PApplet;
import processing.core.PConstants;
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

    public void drawCircle(Vector2D location, double size, int rgb) {
        sketch.pushMatrix();
        sketch.translate((float) location.getX(), (float) location.getY());
        sketch.noStroke();
        sketch.fill(rgb);
        sketch.ellipseMode(2);
        sketch.ellipse(0, 0, (float) size, (float) size);
        sketch.popMatrix();
    }


    public void drawText(Vector2D location, double size, Color color, String s, TextAlign textAlign) {
        sketch.pushMatrix();
        sketch.translate((float) location.getX(), (float) location.getY());
        if(textAlign == TextAlign.CENTER) sketch.textAlign(PConstants.CENTER, PConstants.CENTER);
        if(textAlign == TextAlign.CORNER) sketch.textAlign(PConstants.LEFT, PConstants.TOP);
        sketch.textSize((float) size);
        sketch.fill(color.getRGB());
        sketch.text(s, 0, 0);
        sketch.popMatrix();
    }

    public void drawRect(Vector2D location, double width, double height, Color color) {
        sketch.pushMatrix();
        sketch.translate((float) location.getX(), (float) location.getY());
        sketch.noStroke();
        sketch.fill(color.getRGB());
        sketch.rectMode(1);
        sketch.rect(0, 0, (float) width, (float) height);
        sketch.popMatrix();
    }

}
