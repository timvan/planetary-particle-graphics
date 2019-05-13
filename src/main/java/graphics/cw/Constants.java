package graphics.cw;

public class Constants {
    public static int initialParticleVelocity = 2;

    public static final double particleDensity = 200;

    public static final int particleRadius = 2;

    public static final double spawnerDensity = 0.0000001;

    public static final int spawnerRadius = 8;

    public static int spawnRate = 10;

    public static final double featureDensity = 2;

    public static final int featureRadius = 8;

    public static final int startingParticles = 0;

    public static final int startingFeatures = 6;

    public static final int startingSpawners = 1;

    public static final int windowWidth = 800;

    public static final int windowHeight = 800;

    public static final double maxSpeed = 8.0;

    public static double currentMaxSpeed = 4.0;

    public static final double growthRate = 0.2;

    public static final int maxParticles = 5000;

    public static void setInitialParticleVelocity(int initialParticleVelocity) {
        Constants.initialParticleVelocity = initialParticleVelocity;
    }

    public static void setSpawnRate(int spawnRate) {
        Constants.spawnRate = spawnRate;
    }

    public static void setCurrentMaxSpeed(double currentMaxSpeed) {
        Constants.currentMaxSpeed = currentMaxSpeed;
    }
}
