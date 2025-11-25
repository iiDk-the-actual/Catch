import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Heart photo for health bar
 * 
 * @author Grayson G.
 * @version 1.0.0
 */
public class Heart extends SharedResources
{
    // basic photo stuff
    public boolean broken;
    public void breakHeart(){
        setImage(new GreenfootImage("dmg_heart.png"));
        broken = true;
    }
    
    public void healHeart(){
        setImage(new GreenfootImage("heart.png"));
        broken = false;
    }
}
