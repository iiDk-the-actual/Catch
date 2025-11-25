import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Main world for Catch game
 * 
 * @author Grayson G.
 * @version 1.0.0
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
        
        // initialize all manager and GUIs
        ScoreManager.initialize();
        ParticleManager.initialize();
        HealthBar.initialize();
        
        // spawn all objects and set the layering
        populate();
        setPaintOrder(FailScreen.class, Heart.class, ScoreManager.class, Item.class, Particle.class, Player.class);
    }

    // random spawning of items; hearts,apples,bombs
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
        
        // bombs are seperate  due to custom code
        if (ScoreManager.instance.score > 20){
            bombTimer++;
            if (bombTimer > 500){
                bombTimer = 0;
                spawnRandomBomb();
            }
        }
    }
    
    // Just the player ..
    public void populate()
    {
        addObject(new Player(), getWidth() / 2, 300);
    }
    
    // death screen
    public boolean failed;
    public void fail()
    {
        failed = true;
        addObject(new FailScreen(), getWidth() / 2, getHeight() / 2); 
        setBackground(new GreenfootImage("bg_fail.png"));
        Greenfoot.stop();
    }

    // spawns item at random position, heart if countUntilNonApple is less than zero otherwise apple
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
    
    // spawns an item.. duh
    public void spawnItem(Item.ItemType type, int x, int y, int velocity, int transparency){
        Item itemInstance = new Item(type);
        itemInstance.rotVelocity = random(-5, 5);
        itemInstance.yVelocity = velocity;
        
        addObject(itemInstance, x, y);
        itemInstance.setRotation(random(0, 360));
        itemInstance.getImage().setTransparency(transparency);
    }
     
    // spawns a bomb with random params
    public void spawnRandomBomb(){
        spawnBomb(random(0, getWidth()), 0, 0, 0);
    }
    
    // spawns a bomb.. duh
    public void spawnBomb(int x, int y, int velocity, int transparency){
        Bomb bombInstance = new Bomb();
        bombInstance.rotVelocity = random(-5, 5);
        bombInstance.yVelocity = velocity;
        
        addObject(bombInstance, x, y);
        bombInstance.setRotation(random(0, 360));
        bombInstance.getImage().setTransparency(transparency);
    }
}
