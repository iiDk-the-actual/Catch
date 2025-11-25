import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Subclass of Item- a bomb that you need to throw apples / collectible items at to defuse.
 * 
 * @author Grayson G.
 * @version 1.0.0
 */

public class Bomb extends Item
{
    public Bomb() // Use parent
    {
        super(ItemType.Bomb);
        this.gravity = 0.025f;
    }
  
    public void act()
    {
        super.act(); // Gravity and such
        
        if (getWorld() == null) // see if in a world, why does this work?
            return;
        
        // Check for other colliding items
        Item collectedItem = (Item)getOneIntersectingObject(Item.class);
        if (collectedItem != null){
            if (collectedItem.isCollectible()){
                stopBomb();
            }
        }
    }
    
    // Particles like missItem
    public void stopBomb(){
        ParticleManager.instance.createParticle(getImage(), getX(), getY(), getRotation(), random(-5, 5), -5, random(-15, 15), 30, true, 0.25f);
        destroy();
    }
}
