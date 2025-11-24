/**
* Write a description of class Particle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Particle extends SharedResources
{
    public float xVelocity;
    public float yVelocity;
    public float degVelocity;

    public int time;
    public boolean fade;
    public float gravity;

    public Particle(float xVelocity, float yVelocity, float degVelocity, int time, boolean fade, float gravity){
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;
        this.degVelocity = degVelocity;

        this.time = time;
        this.fade = fade;
        this.gravity = gravity;
    }

    private int frame;
    public void act(){
        frame++;

        setRotation(getRotation() + (int)degVelocity);
        setLocation(getX() + (int)xVelocity, getY() + (int)yVelocity);

        yVelocity += gravity;

        int transparency = (int)(((float)frame / (float)time) * 255);
        transparency = 255 - transparency;
        
        if (transparency > 255)
            transparency = 255;
        if (transparency < 0)
            transparency = 0;

        getImage().setTransparency(transparency);

        if (frame > time)
            destroy();
    }
}
