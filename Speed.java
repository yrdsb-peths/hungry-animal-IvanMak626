import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Speed here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Speed extends Actor
{
    GreenfootImage speedImage = new GreenfootImage("images/gd 2x speed portal.png");
    
    int speed = 1;
    public void act()
    {
        int x = getX();
        int y = getY()+1;
        setLocation(x, y);
        speedImage.scale(50, 50);
        setImage(speedImage);
        
        // remove apple and draw game over when apple gets to bottom
        MyWorld world = (MyWorld) getWorld();
        if(getY() >= world.getHeight()){
            world.gameOver();
            world.removeObject(this);
        }
    }
    
    public void setSpeed(int spd)
    {
        speed = spd;
    }
}
