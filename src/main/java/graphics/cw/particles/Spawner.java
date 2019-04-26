package graphics.cw.particles;

import java.util.ArrayList;

public class Spawner extends Thing {

    ArrayList<Mover> particles;
    int counter;
    int rate;

    public Spawner(Vector2D location, ArrayList<Mover> particles) {
        super(location);
        this.particles = particles;
        counter = 0;
        rate = 10;
    }

    public void generate() {
        Mover newMover = ThingBuilder.newMover(this.getLocation().copy(), 0);
        particles.add(newMover);
    }

    @Override
    public void update() {
        if(counter % rate == 0) {
            this.generate();
            counter = 0;
        }
        counter++;
    }
}
