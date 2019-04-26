package graphics.cw.particles;

import graphics.cw.Constants;

public class Physics {

    public static Vector2D calculateGravitationalAttraction(Thing particleOne, Thing particleTwo) {
        // F = G * m * m / r^2
        double G = Constants.gravitationalConstant;

        Vector2D dist_between_particles = Vector2D.sub(particleOne.getLocation(), particleTwo.getLocation());
        Vector2D force_gravitational_attraction = dist_between_particles.unit();

        double gmm = G * particleOne.getMass() * particleTwo.getMass();
        double r = dist_between_particles.mag();
        double r_sqrd = r * r;

        force_gravitational_attraction.mult(gmm);
        if(r_sqrd > 0.001) {
            force_gravitational_attraction.div(r_sqrd);
        }

        return force_gravitational_attraction;
    }
}
