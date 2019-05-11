package graphics.cw.particles;

import org.junit.Test;

import java.util.Vector;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class Vector2DTest {

    @Test
    public void add() {
        Vector2D v1 = new Vector2D(1, 1);
        Vector2D v2 = new Vector2D(2, 3);
        v1.add(v2);
        assertTrue(v1.getX() == 3);
        assertTrue(v1.getY() == 4);
    }

    @Test
    public void staticAdd() {
        Vector2D v = Vector2D.add(new Vector2D(1, 1), new Vector2D(2, 3) );
        assertTrue(v.getX() == 3);
        assertTrue(v.getY() == 4);
    }

    @Test
    public void sub() {
        Vector2D v1 = new Vector2D(1, 1);
        Vector2D v2 = new Vector2D(2, 3);
        v1.sub(v2);
        assertTrue(v1.getX() == -1);
        assertTrue(v1.getY() == -2);
    }

    @Test
    public void staticSub() {
        Vector2D v = Vector2D.sub(new Vector2D(1, 1), new Vector2D(2, 3) );
        assertTrue(v.getX() == -1);
        assertTrue(v.getY() == -2);
    }

    @Test
    public void mult() {
        Vector2D v1 = new Vector2D(1, 2);
        v1.mult(10);
        assertTrue(v1.getX() == 10);
        assertTrue(v1.getY() == 20);
    }

    @Test
    public void staticMult() {
        Vector2D v = Vector2D.mult(new Vector2D(1, 1), 10);
        assertTrue(v.getX() == 10);
        assertTrue(v.getY() == 10);
    }

    @Test
    public void div() {
        Vector2D v1 = new Vector2D(1, 2);
        v1.div(10);
        assertTrue(v1.getX() == 0.1);
        assertTrue(v1.getY() == 0.2);
    }

    @Test
    public void div1() {
        Vector2D v1 = new Vector2D(1, 2);
        try {
            v1.div(0);
            assertTrue(false); // Checks that above calls ArithmeticException
        } catch (ArithmeticException e){
        }
    }

    @Test
    public void staticDiv() {
        Vector2D v1 = Vector2D.div(new Vector2D(1, 2), 10);
        assertTrue(v1.getX() == 0.1);
        assertTrue(v1.getY() == 0.2);
    }

    @Test
    public void staticDiv1() {
        try {
            Vector2D v1 = Vector2D.div(new Vector2D(1, 2), 0);
            assertTrue(false); // Checks that above calls ArithmeticException
        } catch (ArithmeticException e){
        }
    }

    @Test
    public void mag() {
        Vector2D v = new Vector2D(0, 5);
        assertTrue(v.mag() == 5);
    }

    @Test
    public void normalise() {
        Vector2D v = new Vector2D(0, 4);
        v.normalise();
        assertTrue(v.getX() == 0);
        assertEquals(v.getY(), (double) 1, 0.0001);
    }

    @Test
    public void setMag() {
        Vector2D v = new Vector2D(0, 2);
        v.setMag(1);
        assertTrue(v.getX() == 0);
        assertTrue(v.getY() == 1);

    }

    @Test
    public void unit() {
        Vector2D v = new Vector2D(0, 2);
        Vector2D vunit = v.unit();

        assertTrue(v.getX() == 0);
        assertTrue(v.getY() == 2);

        assertTrue(vunit.getX() == 0);
        assertTrue(vunit.getY() == 1);
    }

    @Test
    public void limit() {
        Vector2D v = new Vector2D(5, 0);
        v.limit(3);
        assertEquals(v.getX(), 3, 0.0001);
    }

    @Test
    public void heading() {
        Vector2D v = new Vector2D(1, 1);
        assertEquals(v.heading(), Math.PI / 4, 0.0001);
    }

    @Test
    public void randomiseUnit() {
        Vector2D v = new Vector2D(0, 0);
        v.randomiseUnit();
        assertTrue(v.getX() > 0);
        assertTrue(v.getY() > 0);
        assertTrue(v.getX() <= 1);
        assertTrue(v.getY() <= 1);
    }

    @Test
    public void newRandom() {
        Vector2D v = Vector2D.newRandom();
        assertTrue(v.getX() > 0);
        assertTrue(v.getY() > 0);
        assertTrue(v.getX() <= 1);
        assertTrue(v.getY() <= 1);
    }

    @Test
    public void newRandom1() {
        Vector2D v = Vector2D.newRandom(-1, 1);
        assertTrue(v.getX() >= -1);
        assertTrue(v.getY() >= -1);
        assertTrue(v.getX() <= 1);
        assertTrue(v.getY() <= 1);
    }

    @Test
    public void newRandom2() {
        Vector2D v = Vector2D.newRandom(-2, -1, 1, 2);
        assertTrue(v.getX() >= -2);
        assertTrue(v.getX() <= -1);
        assertTrue(v.getY() >= 1);
        assertTrue(v.getY() <= 2);
    }

    @Test
    public void lerp() {
        Vector2D v = new Vector2D(0, 0);
        Vector2D v2 = new Vector2D(0, 1);
        v.lerp(v2, 0.8);
        assertTrue(v.getY() <= 1);
        assertTrue(v.getY() >= 0.8);
    }

    @Test
    public void copy() {
        Vector2D v = new Vector2D(1, 2);
        Vector2D copy = v.copy();
        v.mult(2);
        assertTrue(copy.getX() == 1);
        assertTrue(copy.getY() == 2);


    }
}