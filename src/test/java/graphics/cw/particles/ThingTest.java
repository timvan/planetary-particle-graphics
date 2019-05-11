package graphics.cw.particles;

import org.junit.Test;

import static org.junit.Assert.*;

public class ThingTest {

    @Test
    public void update() {
    }

    @Test
    public void isInside() {
        Thing t = new Thing(new Vector2D(10, 10));
        t.setRadius(10);
        assertTrue(t.isInside(10, 10));
        assertTrue(t.isInside(14,10));
        assertFalse(t.isInside(0, 0));
    }
}