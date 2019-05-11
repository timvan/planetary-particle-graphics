package graphics.cw.particles;

import org.junit.Test;

import static org.junit.Assert.*;

public class PhysicsTest {

    @Test
    public void calculateGravitationalAttraction() {
        Feature feature = new Feature(new Vector2D(0, 0));
        Particle particle = new Particle(new Vector2D(4, 4));
        Vector2D force = Physics.calculateGravitationalAttraction(feature, particle);
        assertTrue(force != null);
        assertTrue(force.getX() != 0);
        assertTrue(force.getY() != 0);

    }
}