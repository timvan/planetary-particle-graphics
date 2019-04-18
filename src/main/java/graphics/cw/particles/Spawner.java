package graphics.cw.particles;

import java.util.ArrayList;

public class Spawner extends Thing {
    public Spawner(Vector2D location) {
        super(location);
    }

    public void generate(ArrayList<Mover> particles) {
        Mover newMover = ThingBuilder.newMover(this.getLocation(), 0);
        particles.add(newMover);
    }

    @Override
    public void update() {
    }
}
