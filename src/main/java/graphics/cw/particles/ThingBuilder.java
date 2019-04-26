package graphics.cw.particles;

import graphics.cw.Constants;

import java.util.ArrayList;

public class ThingBuilder {
    private static int initialParticleVelocity = Constants.initialParticleVelocity;

    public static Particle newParticle(){
        Particle newParticle = new Particle(Vector2D.newRandom(0, Constants.windowWidth, 0, Constants.windowHeight), 0);
        newParticle.setDensity(Constants.particleDensity);
        newParticle.setRadius(Constants.particleRadius);
        newParticle.setVelocity(Vector2D.newRandom(-initialParticleVelocity, initialParticleVelocity));
        return newParticle;
    }

    public static Particle newParticle(Vector2D location, int heading){
        Particle newParticle = new Particle(location, 0);
        newParticle.setDensity(Constants.particleDensity);
        newParticle.setRadius(Constants.particleRadius);
        newParticle.setVelocity(Vector2D.newRandom(-initialParticleVelocity, initialParticleVelocity));
        return newParticle;
    }

    public static Spawner newSpawner(ArrayList<Particle> particles) {
        Spawner newSpawner = new Spawner(Vector2D.newRandom(0, Constants.windowWidth, 0, Constants.windowHeight), particles);
        newSpawner.setDensity(Constants.spawnerDensity);
        newSpawner.setRadius(Constants.spawnerRadius);
        return newSpawner;
    }

    public static Spawner newSpawner(Vector2D location, ArrayList<Particle> particles) {
        Spawner newSpawner = new Spawner(location, particles);
        newSpawner.setDensity(Constants.spawnerDensity);
        newSpawner.setRadius(Constants.spawnerRadius);
        return newSpawner;
    }

    public static Feature newFeature() {
        Feature newFeature = new Feature(Vector2D.newRandom(0, Constants.windowWidth, 0, Constants.windowHeight));
        double randSign = (Math.random() * 2) - 1;
        newFeature.setDensity(randSign * Constants.featureDensity);
        newFeature.setRadius(Constants.featureRadius);
        return newFeature;
    }

    public static Feature newFeature(Vector2D location) {
        Feature newFeature = new Feature(location);
        double randSign = (Math.random() * 2) - 1;
        newFeature.setDensity(randSign * Constants.featureDensity);
        newFeature.setRadius(Constants.featureRadius);
        return newFeature;
    }

    public static Feature newFeature(Vector2D location, boolean gravityPulling) {
        Feature newFeature = new Feature(location);
        int sign = -1;
        if (gravityPulling) sign = 1;

        newFeature.setDensity(sign * Constants.featureDensity);
        newFeature.setRadius(Constants.featureRadius);
        return newFeature;
    }


}
