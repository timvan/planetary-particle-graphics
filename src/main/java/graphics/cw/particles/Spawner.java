package graphics.cw.particles;

import graphics.cw.Constants;

import java.util.ArrayList;

public class Spawner extends Thing {

    ArrayList<Particle> particles;
    int counter;
    int rate;

    public Spawner(Vector2D location, ArrayList<Particle> particles) {
        super(location);
        this.particles = particles;
        counter = 0;
        rate = 10;
    }

    public void generate() {
        if(particles.size() > Constants.maxParticles){
            particles.remove(0);
        }
        Particle newParticle = ThingBuilder.newParticle(this.getLocation().copy(), 0);
        particles.add(newParticle);
    }

    @Override
    public void update() {
        if(counter % rate == 0 && this.isOn()) {
            this.generate();
            counter = 0;
        }
        counter++;
    }

}
