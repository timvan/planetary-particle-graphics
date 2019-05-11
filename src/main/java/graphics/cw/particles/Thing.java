package graphics.cw.particles;

/***
 * A Thing is a circular object that exists in the world
 * It has world properties of location, mass, radius and density
 * If density or radius is changed, mass is recalculated
 * Things can be on or off which can change it's functioanility
 */
public class Thing {

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

    public boolean isInside(int x, int y) {
        Vector2D point = new Vector2D(x, y);
        Vector2D dist = Vector2D.sub(location, point);
        if(dist.mag() < radius) {
            return true;
        }
        return false;
    }

    private void calcMass(){
        mass = density * Math.PI * radius * radius;
    }

    /* ------- GETS AND SETS -------- */

    public Vector2D getLocation() {
        return location;
    }

    public void setLocation(Vector2D location) {
      this.location = location;
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

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

}
