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
        
        ScoreManager.initialize();
        ParticleManager.initialize();
        HealthBar.initialize();
        
        populate();
        setPaintOrder(FailScreen.class, Heart.class, ScoreManager.class, Item.class, Particle.class, Player.class);
    }

    private int itemTimer;
    private int bombTimer;
    public void act(){
        itemTimer++;
        if (failed)
        {
            Greenfoot.stop();
            return;
        }

        if (itemTimer > (60 - (int)(ScoreManager.instance.score / 10))){
            itemTimer = 0;
            spawnRandomItem();
        }
        
        if (ScoreManager.instance.score > 20){
            bombTimer++;
            if (bombTimer > 500){
                bombTimer = 0;
                spawnRandomBomb();
            }
        }
    }
    
    public void populate()
    {
        addObject(new Player(), getWidth() / 2, 300);
    }
    
    public boolean failed;
    public void fail()
    {
        failed = true;
        addObject(new FailScreen(), getWidth() / 2, getHeight() / 2); 
        setBackground(new GreenfootImage("bg_fail.png"));
        Greenfoot.stop();
    }

    public int countUntilNonApple = 10;
    public void spawnRandomItem(){
        Item.ItemType itemType = Item.ItemType.Apple;
        countUntilNonApple--;
        if (countUntilNonApple < 0){
            countUntilNonApple = random(3, 10);
            itemType = Item.ItemType.Heart;
        }
        spawnItem(itemType, random(0, getWidth()), 0, 0, 0);
    }

    public int random(int min, int max){// greenfoot's random method is terrible
        return min + Greenfoot.getRandomNumber(max - min);
    }
    
    public void spawnItem(Item.ItemType type, int x, int y, int velocity, int transparency){
        Item itemInstance = new Item(type);
        itemInstance.rotVelocity = random(-5, 5);
        itemInstance.yVelocity = velocity;
        
        addObject(itemInstance, x, y);
        itemInstance.setRotation(random(0, 360));
        itemInstance.getImage().setTransparency(transparency);
    }
    
    public void spawnRandomBomb(){
        spawnBomb(random(0, getWidth()), 0, 0, 0);
    }
    
    public void spawnBomb(int x, int y, int velocity, int transparency){
        Bomb bombInstance = new Bomb();
        bombInstance.rotVelocity = random(-5, 5);
        bombInstance.yVelocity = velocity;
        
        addObject(bombInstance, x, y);
        bombInstance.setRotation(random(0, 360));
        bombInstance.getImage().setTransparency(transparency);
    }
}
