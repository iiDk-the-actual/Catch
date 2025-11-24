import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ParticleManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ParticleManager extends SharedResources
{
    /**
     * Act - do whatever the ParticleManager wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public static ParticleManager instance;
    public ParticleManager(){
        instance = this;
    }

    public static void initialize(){
        instance = new ParticleManager();
    }

    public void createParticle(GreenfootImage image, int x, int y, int deg, float xVelocity, float yVelocity, float degVelocity,
                               int time, boolean fade, float gravity
    ){
        Particle particleInstance = new Particle(xVelocity, yVelocity, degVelocity, time, fade, gravity);
        CatchWorld.instance.addObject(particleInstance, x, y);
        
        particleInstance.setRotation(deg);
        particleInstance.setImage(image);
    }
}
