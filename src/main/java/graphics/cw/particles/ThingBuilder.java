package graphics.cw.particles;

import java.util.ArrayList;
import java.util.Random;

public class ThingBuilder {
    private static Random rand = new Random();
    private static int v_i = 2;

    public static Mover newMover(Vector2D location, int heading){
        Mover newMover = new Mover(location, 0);
        newMover.setDensity(200);
        newMover.setRadius(1);
        newMover.setVelocity(new Vector2D(randSign() * rand.nextDouble() * v_i, randSign() * rand.nextDouble() * v_i));
        return newMover;
    }

    public static Spawner newSpawner(Vector2D location, ArrayList<Mover> particles) {
        Spawner newSpawner = new Spawner(location, particles);
        newSpawner.setDensity(0.0000001);
        newSpawner.setRadius(4);
        return newSpawner;
    }

    private static int randSign(){
        if(rand.nextBoolean()){
            return 1;
        }
        return -1;
    }
}
