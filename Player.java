import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Player controller, the basket thing
 * Controlled with AD/left right and E
 * 
 * @author Grayson G.
 * @version 1.0.0
 */
public class Player extends SharedResources
{
    // initializer
    public static Player instance;
    
    public Player(){
        instance = this;
        
        velocity = 0;
    }
    
    // velocity and such
    private float velocity;
    public void act()
    {
        stepVelocity();
        stepCollection();
    }
    
    // destroy on stop
    public void stopped(){
        destroy();
    }
    
    // shooting / AD movement
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

        // actually set the position
        setX(getX() - (int)velocity);

        velocity *= 0.9;
    }
    
    // collecting of items that can be collected
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
    
    // shoot code on E
    public void shootApple(){
        shootTimer = 10;
        ScoreManager.instance.incrementScore(-1);
        CatchWorld.instance.spawnItem(Item.ItemType.Apple, getX(), getY(), -11, 255);
    }
}
