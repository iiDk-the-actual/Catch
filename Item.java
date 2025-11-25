import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Item code, for bombs apples and hearts
 * Do not confuse with heart
 * @author Grayson G.
 * @version 1.0.0
 */
public class Item extends SharedResources
{
    // all types of items
    public enum ItemType
    {
        Apple,
        Heart,
        Bomb
    }
    
    // initializer code
    public ItemType type;
    public Item(ItemType itemType)
    {
        type = itemType;
        initializeTexture();
    }
    
    // shows the photo.. ugly
    public void initializeTexture(){
        switch (type)
        {
            case ItemType.Apple:
                setImage(new GreenfootImage("apple.png"));
                break;
            case ItemType.Heart:
                setImage(new GreenfootImage("heart.png"));
                break;
            case ItemType.Bomb:
                setImage(new GreenfootImage("bomb.png"));
        }
        
        getImage().setTransparency(0);
    }
    
    // vel and gravity
    public float xVelocity;
    public float yVelocity;
    public float gravity = 0.25f;
    public int rotVelocity;
    
    public void act()
    {
        yVelocity += gravity;
        setY(getY() + (int)yVelocity);
        setRotation(getRotation() + rotVelocity);
        
        GreenfootImage image = getImage();
        
        // fade in on spawn
        int transparency = image.getTransparency();
        transparency = transparency + (int)((255 - transparency) * 0.1f);
        
        image.setTransparency(transparency);
        
        if (getY() > 325){
            // failure when drop on ground
            missItem();
        }
    }

    // determined for player.. ugly
    public boolean isCollectible(){
        switch (type){
            case Apple:
                return true;
            case Heart:
                return true;
            default:
                return false;
        }
    }

    // collection for scorer and heart
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
        
        ParticleManager.instance.createParticle(getImage(), getX(), getY(), getRotation(), 0, yVelocity, rotVelocity, 6, true, 0);
        destroy();
    }
    
    // missing to determine what to do
    public void missItem(){
        switch (type){
            case Apple:
                HealthBar.instance.incrementHealth(-1);
                break;
            case Bomb:
                HealthBar.instance.incrementHealth(-3);
                break;
            default:
                break;
        }
 
        ParticleManager.instance.createParticle(getImage(), getX(), getY(), getRotation(), random(-5, 5), -5, random(-15, 15), 30, true, 0.25f);
        destroy();
    }
}
