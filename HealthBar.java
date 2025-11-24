/**
 * Write a description of class HealthBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HealthBar extends SharedResources
{
    /**
     * Act - do whatever the HealthBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public static HealthBar instance;
    public Heart[] hearts;
    
    public HealthBar(){
        instance = this;
        
        hearts = new Heart[]{
          new Heart(),
          new Heart(),
          new Heart()
        };
        
        for (int i=0; i<3; i++){
            Heart heart = hearts[i];
            CatchWorld.instance.addObject(heart, 25 + (i * 50), 25);
        }
    }
    
    public int health = 3;
    public void incrementHealth(int addition){
        health += addition;
        if (health > 3)
            health = 3;
        if (health < 0)
            health = 0;
        
        for (int i=0; i<3; i++){
            Heart heart = hearts[i];
            if (i < health){
                heart.healHeart();
            } else {
                heart.breakHeart();
            }
        }

        if (health <= 0)
            CatchWorld.instance.fail();
    }
    
    public static void initialize(){
        instance = new HealthBar();
    }
}
