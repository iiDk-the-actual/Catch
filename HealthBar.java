/**
 * Shows health bar with health and hearts
 * 
 * @author Grayson G.
 * @version 1.0.0
 */
public class HealthBar extends SharedResources
{
    public static HealthBar instance;
    public Heart[] hearts;
    
    // initializer
    public HealthBar(){
        instance = this;
        
        // create hearts, ugly code
        hearts = new Heart[]{
          new Heart(),
          new Heart(),
          new Heart()
        };
        
        // hardcoded count, also ugly
        for (int i=0; i<3; i++){
            Heart heart = hearts[i];
            CatchWorld.instance.addObject(heart, 25 + (i * 50), 25);
        }
    }

    public static void initialize(){
        instance = new HealthBar();
    }
    
    // code to increment health and show it
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
}
