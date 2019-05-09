package graphics.cw.particles;

import java.util.Vector;

public abstract class Thing {

    private Vector2D location;

    private double mass;

    private double density;
    private double radius;

    private boolean on = true;

    public Thing(Vector2D location) {
        this.location = location;
        density = 1;
        radius = 10;
        calcMass();
    }

    public void update(){ }

    public Vector2D getLocation() {
        return location;
    }

    public void setLocation(Vector2D location) {
      this.location = location;
    }

    private void calcMass(){
        mass = density * Math.PI * radius * radius;
    }

    public double getMass() {
        return mass;
    }

    public double getDensity() {
        return density;
    }

    public void setDensity(double density) {
        this.density = density;
        this.calcMass();
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
        this.calcMass();
    }

    public boolean isInside(int x, int y) {
        Vector2D point = new Vector2D(x, y);
        Vector2D dist = Vector2D.sub(location, point);
        if(dist.mag() < radius) {
            return true;
        }
        return false;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }
}
