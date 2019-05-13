package graphics.cw.particles;

import graphics.cw.display.ColorPalette;
import graphics.cw.display.Display;
import graphics.cw.display.RGB;

/***
 * Features are static Things that can be used to exert gravitational forces
 * Currently a placeholder class
 */
public class Feature extends Thing {

    private RGB neagtiveFeatureColor = ColorPalette.neagtiveFeature;
    private RGB postiveFeatureColor = ColorPalette.postiveFeature;

    public Feature(Vector2D location) {
        super(location);
    }

    @Override
    public void update() {
    }

    public void draw(Display display){
        if(this.getMass() < 0){
            display.drawCircle(this.getLocation().getX(), this.getLocation().getY(), this.getRadius(), neagtiveFeatureColor);
        } else {
            display.drawCircle(this.getLocation().getX(), this.getLocation().getY(), this.getRadius(), postiveFeatureColor);
        }

    }
}
