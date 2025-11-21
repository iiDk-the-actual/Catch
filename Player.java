import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends SharedResources
{
    public static Player instance;
    
    public Player(){
        instance = this;
        
        velocity = 0;
    }
    
    private float velocity;
    public void act()
    {
        if (Greenfoot.isKeyDown("a"))
        {
            velocity -= 0.5;
        }
    }
    
    public void stepVelocity(){
        
    }
}
