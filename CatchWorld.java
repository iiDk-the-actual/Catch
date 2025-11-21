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
    private int frame;

    public CatchWorld()
    {   
        super(600, 400, 1);
        instance = this;
        
        ScoreManager.initialize();
        ParticleManager.initialize();
        HealthBar.initialize();
        
        populate();
    }

    public void act(){
        frame++;

        if (frame > 60){
            frame = 0;
            spawnRandomItem();
        }
    }
    
    public void populate()
    {
        addObject(new Player(), getWidth() / 2, 300);
    }

    public int countUntilNonApple = 10;
    public void spawnRandomItem(){
        Item.ItemType itemType = Item.ItemType.Apple;
        countUntilNonApple--;
        if (countUntilNonApple < 0){
            countUntilNonApple = random(3, 10);
            itemType = Item.ItemType.Heart;
        }
        spawnItem(itemType, random(0, getWidth()),  0);
    }

    public int random(int min, int max){// greenfoot's random method is terrible
        return min + Greenfoot.getRandomNumber(max - min);
    }
    
    public void spawnItem(Item.ItemType type, int x, int y){
        addObject(new Item(type), x, y);
    }
}
