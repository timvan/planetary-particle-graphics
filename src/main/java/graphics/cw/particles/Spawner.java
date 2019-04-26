package graphics.cw.particles;

import java.util.ArrayList;

public class Spawner extends Thing {

    ArrayList<Particle> particles;
    int counter;
    int rate;
    boolean isOn;

    public Spawner(Vector2D location, ArrayList<Particle> particles) {
        super(location);
        this.particles = particles;
        counter = 0;
        rate = 10;
        isOn = true;
    }

    public void generate() {
        Particle newParticle = ThingBuilder.newParticle(this.getLocation().copy(), 0);
        particles.add(newParticle);
    }

    @Override
    public void update() {
        if(counter % rate == 0 && isOn) {
            this.generate();
            counter = 0;
        }
        counter++;
    }

    public void setOn(boolean on) {
        isOn = on;
    }
}
