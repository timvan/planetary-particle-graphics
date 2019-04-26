package graphics.cw.particles;

import sun.nio.cs.ext.MacHebrew;

public class Vector2D {

    private double x;
    private double y;

    public Vector2D(double x_, double y_){
        x = x_;
        y = y_;
    }

    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    public void add(Vector2D v) {
        x = x + v.x;
        y = y + v.y;
    }

    public static Vector2D add(Vector2D v1, Vector2D v2) {
        Vector2D v3 = new Vector2D(v1.x + v2.x, v1.y + v2.y);
        return v3;
    }

    public void sub(Vector2D v) {
        x = x - v.x;
        y = y - v.y;
    }

    public static Vector2D sub(Vector2D v1, Vector2D v2) {
        Vector2D v3 = new Vector2D(v1.x - v2.x, v1.y - v2.y);
        return v3;
    }

    public void mult(double n) {
        x = x * n;
        y = y * n;
    }

    public static Vector2D mult(Vector2D v1, double n) {
        Vector2D v2 = new Vector2D(v1.x * n, v1.y * n);
        return v2;
    }

    public void div(double n) {
        if(n != 0){
            x = x / n;
            y = y / n;
        }
    }

    public static Vector2D div(Vector2D v1, double n) {
		if(n == 0){
		    throw new Error("Cannot devide by zero");
		}
        return new Vector2D (v1.x / n, v1.y / n);
    }

    public double mag() {
        return Math.sqrt(x * x  + y * y);
    }

    public void normalise() {
        double m = mag();
        if (m != 0) {
            div(m);
        }
    }

    void setMag(double m) {
        normalise();
        mult(m);
    }

    public Vector2D unit() {
        Vector2D v2 = new Vector2D(x, y);
        v2.normalise();
        return v2;
    }

    public void limit(double max) {
        if(mag() > max) {
            normalise();
            mult(max);
        }
    }

    public double heading() {
        /* Converts cart coords to polar, returns degree in RADIANS*/
        return Math.atan2(y, x);
    }

    void randomiseUnit() {
        x = Math.random();
        y = Math.random();
    }

    public static Vector2D newRandom(){
        Vector2D randomVector = new Vector2D(1, 1);
        randomVector.randomiseUnit();
        return randomVector;
    }

    public static Vector2D newRandom(int min, int max) {
        int dif = max - min;
        return new Vector2D(
                min + Math.random() * dif,
                min + Math.random() * dif
        );
    }

    public static Vector2D newRandom(int minX, int maxX, int minY, int maxY) {
        int difX = maxX - minX;
        int difY = maxY - minY;
        return new Vector2D(
                minX + Math.random() * difX,
                minY + Math.random() * difY
        );
    }

    void lerp(Vector2D v, double i){
        x = (v.x - x) * i;
        y = (v.y - y) * i;
    }

    public Vector2D copy() {
        return new Vector2D(x, y);
    }
}
