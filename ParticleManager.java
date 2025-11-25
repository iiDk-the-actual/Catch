import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Exists just to make particles
 * 
 * @author Grayson G.
 * @version 1.0.0
 */
public class ParticleManager extends SharedResources
{
    // initializer
    public static ParticleManager instance;
    public ParticleManager(){
        instance = this;
    }

    public static void initialize(){
        instance = new ParticleManager();
    }

    // solely exists just to make particles
    public void createParticle(GreenfootImage image, int x, int y, int deg, float xVelocity, float yVelocity, float degVelocity,
                               int time, boolean fade, float gravity
    ){
        Particle particleInstance = new Particle(xVelocity, yVelocity, degVelocity, time, fade, gravity);
        CatchWorld.instance.addObject(particleInstance, x, y);
        
        particleInstance.setRotation(deg);
        particleInstance.setImage(image);
    }
}
