import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SharedResources here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
