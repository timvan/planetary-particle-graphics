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
            Particle particle = ThingBuilder.newParticle();
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

    public void newSpawner(int mouseX, int mouseY){
        Spawner newSpawner = ThingBuilder.newSpawner(new Vector2D(mouseX, mouseY), particles);
        spawners.add(newSpawner);
    }

    public void newFeature(int mouseX, int mouseY, boolean gravityPulling){
        Feature newFeature = ThingBuilder.newFeature(new Vector2D(mouseX, mouseY), gravityPulling);
        features.add(newFeature);
    }

    public Thing getThing(int mouseX, int mouseY){
        for(Feature feature : features) {
            if(feature.isInside(mouseX, mouseY)){ return feature; }
        }
        for(Spawner spawner : spawners) {
            if(spawner.isInside(mouseX, mouseY)){ return spawner; }
        }
        return null;
    }

    public void deleteThing(int mouseX, int mouseY){
        for(int i = 0; i < features.size(); i ++) {
            if(features.get(i).isInside(mouseX, mouseY)){
                features.remove(i);
            }
        }
        for(int i = 0; i < spawners.size(); i ++) {
            if(spawners.get(i).isInside(mouseX, mouseY)){
                spawners.remove(i);
            }
        }
    }

    public void clearParticles(){
        particles.clear();
    }

    public void clearAll() {
        particles.clear();
        spawners.clear();
        features.clear();
    }
}
