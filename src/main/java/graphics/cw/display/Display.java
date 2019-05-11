package graphics.cw.display;

import graphics.cw.particles.Vector2D;
import processing.core.PApplet;
import processing.core.PConstants;

import java.awt.*;


/***
 * Display class that draws objects to screen
 */
public class Display {

    private static PApplet sketch;

    public Display(PApplet sketch) {
        this.sketch = sketch;
    }

    public void drawBackground(int width, int height){
        // draw background
        RGB c = ColorPalette.background;
        sketch.fill(c.getRed(), c.getGreen(), c.getBlue(), (float) 100);
        sketch.translate(0, 0);
        sketch.rectMode(1);
        sketch.rect(0, 0, width, height);
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

    public void drawCircle(Vector2D location, double size, RGB rgb) {
        sketch.pushMatrix();
        sketch.translate((float) location.getX(), (float) location.getY());
        sketch.fill((float) rgb.getRed(), (float) rgb.getGreen(), (float) rgb.getBlue());
        sketch.ellipseMode(2);
        sketch.ellipse(0, 0, (float) size, (float) size);
        sketch.popMatrix();
    }

    public void drawCircle(Vector2D location, double size, RGB rgb, int alpha) {
        sketch.pushMatrix();
        sketch.translate((float) location.getX(), (float) location.getY());
        sketch.fill((float) rgb.getRed(), (float) rgb.getGreen(), (float) rgb.getBlue(), alpha);
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

    public void drawRect(Vector2D location, double width, double height, RGB rgb) {
        sketch.pushMatrix();
        sketch.translate((float) location.getX(), (float) location.getY());
        sketch.noStroke();
        sketch.fill((float) rgb.getRed(), (float) rgb.getGreen(), (float) rgb.getBlue());
        sketch.rectMode(1);
        sketch.rect(0, 0, (float) width, (float) height);
        sketch.popMatrix();
    }

}
