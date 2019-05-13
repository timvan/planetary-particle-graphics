package graphics.cw.particles;

import graphics.cw.Constants;
import graphics.cw.display.ColorPalette;
import graphics.cw.display.Display;
import graphics.cw.display.RGB;

/***
 * A spawner is a Thing that creates new particles from within it.
 * A spawner has a rate of firing which can be checked with spawnTime
 */
public class Spawner extends Thing {

    private int counter;
    private int rate;
    private int maxRate;

    private RGB spawnerColor = ColorPalette.spawner;

    public Spawner(Vector2D location) {
        super(location);
        counter = 0;
        rate = Constants.spawnRate;
        maxRate = Constants.spawnRate;
    }

    public Particle spawn() {
        Particle newParticle = ThingBuilder.newParticle(this.getLocation().copy());
        return newParticle;
    }

    public boolean spawnTime() {
        if(this.isOn()) {
            if ((maxRate - rate) == 0) {
                return true;
            }
            if ((maxRate - rate) - counter++ <= 0) {
                counter = 0;
                return true;
            }
        }
        return false;
    }

    public void setMaxRate(int rate) {
        if(rate != 0){
            this.setOn(true);
            this.rate = rate;
            return;
        }
        this.setOn(false);
    }

    @Override
    public void update() {}

    public void draw(Display display) {
        display.drawCircle(this.getLocation().getX(), this.getLocation().getY(), this.getRadius(), spawnerColor);
    }

}
