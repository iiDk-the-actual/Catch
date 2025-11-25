import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Score manager from FlyingBirdWorld
 * 
 * @author Grayson G.
 * @version 1.0.1
 */
public class ScoreManager extends SharedResources
{
    // initializer
    public static ScoreManager instance;
    public int score;
    
    public ScoreManager()
    {
        instance = this;
        resetScore();
    }

    public static void initialize(){
        instance = new ScoreManager();
        CatchWorld.instance.addObject(instance, CatchWorld.instance.getWidth() / 2, 30);
    }

    // image holding the score
    private GreenfootImage scoreImage = new GreenfootImage(68, 30);
    public void resetScore()
    {
        score = 0;
        incrementScore(0);
    }

    // score incrementer and string updater
    public void incrementScore(int score)
    {
        this.score += score;
        
        scoreImage.clear();
        scoreImage.setColor(new greenfoot.Color(0, 0, 0, 0));
        scoreImage.fill();
        
        Font impact = new Font("Arial", 32);
        scoreImage.setFont(impact);
        scoreImage.setColor(greenfoot.Color.BLACK);
        scoreImage.drawString(""+this.score, 2, 30); // ew
        scoreImage.setColor(greenfoot.Color.WHITE);
        scoreImage.drawString(""+this.score, 0, 30);
        setImage(scoreImage);
    }
}
