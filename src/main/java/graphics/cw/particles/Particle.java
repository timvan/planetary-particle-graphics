package graphics.cw.particles;

import graphics.cw.Constants;
import graphics.cw.display.ColorPalette;
import graphics.cw.display.Display;
import graphics.cw.display.RGB;

/***
 * Particles are moving Things
 * Particles move using Newtonian mechanics, where forces are applied to it
 */
public class Particle extends Thing {

    private Vector2D velocity;
    private Vector2D acceleration;

    private double maxSpeed;

    private RGB particleColor = ColorPalette.particle;

    public Particle(Vector2D location) {
        super(location);

        velocity = new Vector2D(0, 0);
        acceleration = new Vector2D(0, 0);

        maxSpeed = Constants.currentMaxSpeed;
    }

    public void setVelocity(Vector2D velocity) {
        this.velocity = velocity;
    }

    @Override
    public void update() {

        velocity.add(acceleration);
        velocity.limit(maxSpeed);

        Vector2D location = this.getLocation();
        location.add(velocity);
        acceleration.mult(0);
    }

    public void draw(Display display) {
        display.drawCircle(this.getLocation().getX(), this.getLocation().getY(), this.getRadius(), particleColor, 190);
    }

    public void applyForce(Vector2D force) {
        Vector2D f = Vector2D.div(force, this.getMass());
        acceleration.add(f);
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}
