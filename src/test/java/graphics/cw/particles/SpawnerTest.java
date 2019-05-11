package graphics.cw.particles;

import org.junit.Test;

import static org.junit.Assert.*;

public class SpawnerTest {

    @Test
    public void spawn() {
        Spawner s = new Spawner(new Vector2D(0, 0));
        assertTrue(s.spawn() != null);
        Particle p = s.spawn();
        assertTrue(p.getLocation().getX() == 0);
        assertTrue(p.getLocation().getY() == 0);
    }
}