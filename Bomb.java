import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bomb here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bomb extends Item
{
    public ItemType type;
    public Bomb()
    {
        super(ItemType.Bomb);
        this.gravity = 0.025f;
    }
  
    public void act()
    {
        super.act();
        
        if (getWorld() == null)
            return;
        
        Item collectedItem = (Item)getOneIntersectingObject(Item.class);
        if (collectedItem != null){
            if (collectedItem.isCollectible()){
                stopBomb();
            }
        }
    }
    
    public void stopBomb(){
        ParticleManager.instance.createParticle(getImage(), getX(), getY(), getRotation(), random(-5, 5), -5, random(-15, 15), 30, true, 0.25f);
        destroy();
    }
}
