package graphics.cw.particles;

import processing.core.PVector;

public class Mover extends Thing {

    private Vector2D velocity;
    private Vector2D acceleration;

    private double heading;
    private double aVelocity;
    private double aAcceleration;

    private double maxSpeed;
    private double maxAngSpeed;
    private double maxForce;


    public Mover(Vector2D location, double heading) {
        super(location);
        this.heading = heading;

        velocity = new Vector2D(0, 0);
        acceleration = new Vector2D(0, 0);

        aVelocity = 0;
        aAcceleration = 0;

        maxSpeed = 6;
        maxAngSpeed = 10;

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

        aVelocity += (aAcceleration);
        if(aVelocity >= maxAngSpeed) aVelocity = maxAngSpeed;
        if (aVelocity <= -maxAngSpeed) aVelocity = -maxAngSpeed;

        this.heading += (aVelocity);
        aAcceleration = 0;

    }


    public void applyForce(Vector2D force) {
        Vector2D f = Vector2D.div(force, this.getMass());
        acceleration.add(f);
    }

    public void applyRelativeForce(Vector2D force, double heading) {
        Vector2D relForce = new Vector2D(force.mag() * Math.cos(force.heading() + heading),
                force.mag() * Math.sin(force.heading() + heading));
        applyForce(relForce);
    }

}
