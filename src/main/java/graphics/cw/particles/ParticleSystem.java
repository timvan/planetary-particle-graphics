package graphics.cw.particles;

import java.util.ArrayList;
import java.util.Random;

public class ParticleSystem {

    Random rand;

    private int n_particles;
    private int n_sinks;
    private int n_spawners;

    private ArrayList<Mover> particles;
    private ArrayList<Sink> features;
    private ArrayList<Spawner> spawners;

    Grid grid;

    public ParticleSystem(Grid grid) {

        this.grid = grid;

        particles = new ArrayList<>();
        features = new ArrayList<>();
        spawners = new ArrayList<>();

        n_particles = 10;
        n_sinks = 10;
        n_spawners = 2;

        rand = new Random();
    }

    public void setup(){

        for(int i = 0; i < n_particles; i++) {
            Mover particle = ThingBuilder.newMover(
                    new Vector2D(rand.nextDouble() * grid.getWidth(), rand.nextDouble() * grid.getHeight()), 0);
            particles.add(particle);
        }

        for(int i = 0; i < n_sinks; i++) {
            int nextSign = rand.nextBoolean() == true ? 1 : -1;

            Sink newSink = new Sink(new Vector2D(rand.nextDouble() * grid.getWidth(),
                    rand.nextDouble() * grid.getHeight()));

            newSink.setDensity(nextSign * 1);
            newSink.setRadius(5);

            features.add(newSink);
        }

        for(int i = 0; i < n_spawners; i++) {
            Spawner newSpawner = ThingBuilder.newSpawner(new Vector2D(rand.nextDouble() * grid.getWidth(),
                    rand.nextDouble() * grid.getHeight()),
                    particles
            );
            spawners.add(newSpawner);
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
        for(Spawner spawner: spawners){
            spawner.update();
        }
    }

    public ArrayList<Mover> getParticles() {
        return particles;
    }

    public ArrayList<Sink> getFeatures() {
        return features;
    }

    public ArrayList<Spawner> getSpawners() {
        return spawners;
    }
}
