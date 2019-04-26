package graphics.cw.particles;

import java.util.Vector;

public class Thing {

    private Vector2D location;

    private double mass;

    private double density;
    private double radius;

    public Thing(Vector2D location) {
        this.location = location;
        density = 1;
        radius = 10;
        calcMass();
    }

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

    public void setDensity(double density) {
        this.density = density;
        calcMass();
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public boolean isInside(int x, int y) {
        Vector2D point = new Vector2D(x, y);
        Vector2D dist = Vector2D.sub(location, point);
        if(dist.mag() < radius) {
            return true;
        }
        return false;
    }

    public void update(){

    }
}
