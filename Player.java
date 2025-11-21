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
        stepVelocity();
        stepCollection();
    }
    
    public void stepVelocity(){
        if (Greenfoot.isKeyDown("a"))
            velocity += 1f;

        if (Greenfoot.isKeyDown("d"))
            velocity -= 1f;

        setX(getX() - (int)velocity);

        velocity *= 0.9;
    }
    
    public void stepCollection(){
        Item collectedItem = (Item)getOneIntersectingObject(Item.class);
        if (collectedItem != null){
            if (collectedItem.isCollectible()){
                collectedItem.collectItem();
            }
        }
    }
}
