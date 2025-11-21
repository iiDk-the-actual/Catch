import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CatchWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public static CatchWorld instance;
    public CatchWorld()
    {   
        super(600, 400, 1);
        
        instance = this;
        populate();
    }
    
    public void populate()
    {
        spawnItem(Item.ItemType.Apple, getWidth() / 2,  100);
        addObject(new Player(), getWidth() / 2, 300);
    }
    
    public void spawnItem(Item.ItemType type, int x, int y){
        addObject(new Item(type), x, y);
    }
}
