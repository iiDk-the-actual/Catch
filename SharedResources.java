import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Common methods ran
 * 
 * @author Grayson G.
 * @version 1.0.0
 */
public class SharedResources extends Actor
{
    public void setX(int x){
        this.setLocation(x, this.getY());
    }
    public void setY(int y){
        this.setLocation(this.getX(), y);
    }
    
    public int random(int min, int max){// greenfoot's random method is terrible
        return min + Greenfoot.getRandomNumber(max - min);
    }

    public void destroy(){
        getWorld().removeObject(this);
    }
}
