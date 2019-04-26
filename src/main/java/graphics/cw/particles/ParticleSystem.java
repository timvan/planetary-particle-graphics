package graphics.cw.particles;

import graphics.cw.Constants;

import java.util.ArrayList;

public class ParticleSystem {

    private int nParticles = Constants.startingParticles;
    private int nFeatures = Constants.startingFeatures;
    private int nSpawners = Constants.startingSpawners;

    private ArrayList<Particle> particles = new ArrayList<>();
    private ArrayList<Feature> features = new ArrayList<>();
    private ArrayList<Spawner> spawners = new ArrayList<>();

    Grid grid;

    public ParticleSystem(Grid grid) {

        this.grid = grid;
    }

    public void setup(){

        for(int i = 0; i < nParticles; i++) {
            Particle particle = ThingBuilder.newParticle(
                    Vector2D.newRandom(0, grid.getWidth(), 0, grid.getHeight()),
                    0
            );
            particles.add(particle);
        }

        for(int i = 0; i < nFeatures; i++) {
            Feature newFeature = ThingBuilder.newFeature();
            features.add(newFeature);
        }

        for(int i = 0; i < nSpawners; i++) {
            Spawner newSpawner = ThingBuilder.newSpawner(particles);
            spawners.add(newSpawner);
        }

    }

    public void update() {
        for(Particle particle: particles){
            for(Feature feature: features) {
                Vector2D gForce = Physics.calculateGravitationalAttraction(feature, particle);
                particle.applyForce(gForce);
            }

            particle.update();
        }
        for(Spawner spawner: spawners){
            spawner.update();
        }
    }

    public ArrayList<Particle> getParticles() {
        return particles;
    }

    public ArrayList<Feature> getFeatures() {
        return features;
    }

    public ArrayList<Spawner> getSpawners() {
        return spawners;
    }
}
