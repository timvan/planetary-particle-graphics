package graphics.cw.particles;

import graphics.cw.Constants;
import java.util.ArrayList;

/***
 * This is the world / particle system
 * In a particle system there areparticles, features and spawners
 *  particles - moving Things that has gravitational force applied to it
 *  features - static Things that applies gravitational to particles
 *  spawners - static Things that create particles
 * A particle system must be setup, then updated each draw cycle
 */
public class ParticleSystem {

    private int nParticles = Constants.startingParticles;
    private int nFeatures = Constants.startingFeatures;
    private int nSpawners = Constants.startingSpawners;

    private ArrayList<Particle> particles = new ArrayList<>();
    private ArrayList<Feature> features = new ArrayList<>();
    private ArrayList<Spawner> spawners = new ArrayList<>();

    public ParticleSystem() {
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
            Spawner newSpawner = ThingBuilder.newSpawner();
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
            if(spawner.spawnTime()){
                particles.add(spawner.spawn());
            }
        }
    }

    public ArrayList<Particle> getParticles() {
        return new ArrayList<>(particles);
    }

    public ArrayList<Feature> getFeatures() {
        return new ArrayList<>(features);
    }

    public ArrayList<Spawner> getSpawners() {
        return new ArrayList<>(spawners);
    }

    public void newSpawner(int mouseX, int mouseY){
        Spawner newSpawner = ThingBuilder.newSpawner(new Vector2D(mouseX, mouseY));
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
                return;
            }
        }
        for(int i = 0; i < spawners.size(); i ++) {
            if(spawners.get(i).isInside(mouseX, mouseY)){
                spawners.remove(i);
                return;
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

    public void setParticlesMaxSpeed(double maxSpeed){
        for(Particle p : particles){
            p.setMaxSpeed(maxSpeed);
        }
    }

    public void setSpawnRate(int rate){
        for(Spawner s : spawners) {
            s.setMaxRate(rate);
        }
    }
}
