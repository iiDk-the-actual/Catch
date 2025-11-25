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
    
    public void stopped(){
        destroy();
    }
    
    public int shootTimer;
    public void stepVelocity(){
        if (Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("left"))
            velocity += 1.5f;

        if (Greenfoot.isKeyDown("d") || Greenfoot.isKeyDown("right"))
            velocity -= 1.5f;
            
        shootTimer--;
        if (Greenfoot.isKeyDown("e") && shootTimer <= 0 && ScoreManager.instance.score > 0){
            shootApple();
        }

        setX(getX() - (int)velocity);

        velocity *= 0.9;
    }
    
    public void stepCollection(){
        if (shootTimer > 0)
            return;
        
        Item collectedItem = (Item)getOneIntersectingObject(Item.class);
        if (collectedItem != null){
            if (collectedItem.isCollectible()){
                collectedItem.collectItem();
            }
        }
    }
    
    public void shootApple(){
        shootTimer = 10;
        ScoreManager.instance.incrementScore(-1);
        CatchWorld.instance.spawnItem(Item.ItemType.Apple, getX(), getY(), -11, 255);
    }
}
