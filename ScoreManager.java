import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ScoreManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreManager extends SharedResources
{
    /**
     * Act - do whatever the ScoreManager wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
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

    private GreenfootImage scoreImage = new GreenfootImage(68, 30);
    public void resetScore()
    {
        score = 0;
        incrementScore(0);
    }

    public void incrementScore(int score)
    {
        this.score += score;
        
        scoreImage.clear();
        scoreImage.setColor(new greenfoot.Color(0, 0, 0, 0));
        scoreImage.fill();
        
        Font impact = new Font("Arial", 32);
        scoreImage.setFont(impact);
        scoreImage.setColor(greenfoot.Color.BLACK);
        scoreImage.drawString(""+this.score, 2, 30);
        scoreImage.setColor(greenfoot.Color.WHITE);
        scoreImage.drawString(""+this.score, 0, 30);
        setImage(scoreImage);
    }
}
