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
    
    public void act()
    {
        // Add your action code here.
    }
}
