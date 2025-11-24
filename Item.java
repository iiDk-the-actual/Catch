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
        Apple,
        Heart
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
            case ItemType.Heart:
                setImage(new GreenfootImage("heart.png"));
                break;
        }
        
        getImage().setTransparency(0);
    }
    
    public float xVelocity;
    public float yVelocity;
    public int rotVelocity;
    
    public void act()
    {
        yVelocity += 0.25;
        setY(getY() + (int)yVelocity);
        setRotation(getRotation() + rotVelocity);
        
        GreenfootImage image = getImage();
        
        int transparency = image.getTransparency();
        transparency = transparency + (int)((255 - transparency) * 0.1f);
        
        image.setTransparency(transparency);
        
        if (getY() > 325){
            missItem();
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
                break;
            case Heart:
                HealthBar.instance.incrementHealth(1);
                break;
            default:
                break;
        }

        destroy();
    }
    
    public void missItem(){
        switch (type){
            case Apple:
                HealthBar.instance.incrementHealth(-1);
                break;
            default:
                break;
        }
 
        ParticleManager.instance.createParticle(getImage(), getX(), getY(), getRotation(), random(-5, 5), -5, random(-15, 15), 30, true, 0.25f);
        destroy();
    }
}
