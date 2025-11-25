/**
 * Simple particle, like item but boring
 * 
 * @author Grayson G.
 * @version 1.0.0
 */

public class Particle extends SharedResources
{
    // velocity
    public float xVelocity;
    public float yVelocity;
    public float degVelocity;

    public int time;
    public boolean fade;
    public float gravity;

    // initializer to splatter all of those variables from up there
    public Particle(float xVelocity, float yVelocity, float degVelocity, int time, boolean fade, float gravity){
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;
        this.degVelocity = degVelocity;

        this.time = time;
        this.fade = fade;
        this.gravity = gravity;
    }

    // more gravity, time based transparency and such
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

        // destroy
        if (frame > time)
            destroy();
    }
}
