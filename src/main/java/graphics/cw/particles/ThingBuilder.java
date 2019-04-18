package graphics.cw.particles;

import java.util.Random;

public class ThingBuilder {
    private static Random rand = new Random();
    private static int v_i = 5;

    public static Mover newMover(Vector2D location, int heading){
        Mover newMover = new Mover(location, 0);
        newMover.setDensity(500);
        newMover.setRadius(2);
        newMover.setVelocity(new Vector2D(randSign() * rand.nextDouble() * v_i, randSign() * rand.nextDouble() * v_i));
        return newMover;
    }

    private static int randSign(){
        if(rand.nextBoolean()){
            return 1;
        }
        return -1;
    }
}
