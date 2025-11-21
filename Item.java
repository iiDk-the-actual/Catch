import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Item here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Item extends SharedResources
{
    /**
     * Act - do whatever the Item wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public enum ItemType
    {
        Apple
    }
    
    public ItemType type;
    public Item(ItemType itemType)
    {
        type = itemType;
        initializeTexture();
    }
    
    public void initializeTexture(){
        switch (type)
        {
            case ItemType.Apple:
                setImage(new GreenfootImage("apple.png"));
                break;
        }
    }
    
    public float xVelocity;
    public float yVelocity;
    public void act()
    {
        yVelocity += 0.25;
        setY(getY() + (int)yVelocity);
        
        if (getY() > 325){
            ParticleManager.instance.createParticle(getImage(), getX(), getY(), random(-10, 10), -10, random(-15, 15), 30, true, 1);
            destroy();
        }
    }

    public boolean isCollectible(){
        switch (type){
            case Apple:
                return true;
            default:
                return false;
        }
    }

    public void collectItem(){
        switch (type){
            case Apple:
                ScoreManager.instance.incrementScore(1);
            default:
        }

        destroy();
    }
}
