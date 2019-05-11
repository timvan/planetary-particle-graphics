package graphics.cw.particles;

import graphics.cw.Constants;

/***
 * Builder class that makes particles, spawners and features
 * Depends upon Constants.
 */
public class ThingBuilder {

    private static double particleMaxSpeed = Constants.maxSpeed;
    private static int particleInitialVelcotiy = Constants.initialParticleVelocity;

    public static void setParticleInitialVelcotiy(int particleInitialVelcotiy) {
        ThingBuilder.particleInitialVelcotiy = particleInitialVelcotiy;
    }

    public static Particle newParticle(){
        Particle newParticle = new Particle(Vector2D.newRandom(0, Constants.windowWidth, 0, Constants.windowHeight));
        newParticle.setDensity(Constants.particleDensity);
        newParticle.setRadius(Constants.particleRadius);
        newParticle.setVelocity(Vector2D.newRandom(-particleInitialVelcotiy, particleInitialVelcotiy));
        newParticle.setMaxSpeed(particleMaxSpeed);
        return newParticle;
    }

    public static Particle newParticle(Vector2D location){
        Particle newParticle = new Particle(location);
        newParticle.setDensity(Constants.particleDensity);
        newParticle.setRadius(Constants.particleRadius);
        newParticle.setVelocity(Vector2D.newRandom(-particleInitialVelcotiy, particleInitialVelcotiy));
        return newParticle;
    }

    public static Spawner newSpawner() {
        Spawner newSpawner = new Spawner(Vector2D.newRandom(0, Constants.windowWidth, 0, Constants.windowHeight));
        newSpawner.setDensity(Constants.spawnerDensity);
        newSpawner.setRadius(Constants.spawnerRadius);
        return newSpawner;
    }

    public static Spawner newSpawner(Vector2D location) {
        Spawner newSpawner = new Spawner(location);
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
