package graphics.cw.particles;

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

    private void calcMass(){
        mass = density * Math.PI * radius * radius;
    }

    public double getMass() {
        return mass;
    }

    public void setDensity(double density) {
        this.density = density;
    }


    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void update(){
    }


}
