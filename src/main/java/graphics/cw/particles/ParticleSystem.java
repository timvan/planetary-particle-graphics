package graphics.cw.particles;

import java.util.ArrayList;
import java.util.Random;

public class ParticleSystem {

    Random rand;

    private int n_particles;
    private int n_sinks;

    private ArrayList<Mover> particles;
    private ArrayList<Sink> features;

    Grid grid;

    public ParticleSystem(Grid grid) {

        this.grid = grid;

        particles = new ArrayList<>();
        features = new ArrayList<>();

        n_particles = 1000;
        n_sinks = 4;

        rand = new Random();
    }

    public void setup(){

        for(int i = 0; i < n_particles; i++) {
            Mover particle = ThingBuilder.newMover(
                    new Vector2D(rand.nextDouble() * grid.getWidth(), rand.nextDouble() * grid.getHeight()), 0);
            particles.add(particle);
        }

        for(int i = 0; i < n_sinks; i++) {

            Sink newSink = new Sink(new Vector2D(rand.nextDouble() * grid.getWidth(),rand.nextDouble() * grid.getHeight()));
            newSink.setDensity(100);
            newSink.setRadius(5);
            features.add(newSink);
        }
    }

    public void update() {
        for(Mover particle: particles){
            for(Sink feature: features) {
                Vector2D gForce = Physics.calculateGravitationalAttraction(feature, particle);
                particle.applyForce(gForce);
            }

            particle.update();
        }
    }

    public ArrayList<Mover> getParticles() {
        return particles;
    }

    public ArrayList<Sink> getFeatures() {
        return features;
    }

}
