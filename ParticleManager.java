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

    public void createParticle(GreenfootImage image, int x, int y, float xVelocity, float yVelocity,
                               float time, boolean fade
    ){
        Particle particleInstance = new Particle();
        CatchWorld.instance.addObject(particleInstance, x, y);
    }

    public Particle[] particles;
    public void act()
    {
        
    }
}
