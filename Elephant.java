import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Elephant, our hero.
 * @author (Ivan Mak) 
 * @version (a version number or a date)
 */
public class Elephant extends Actor
{
    GreenfootSound elephantSound  = new GreenfootSound("elephantcub.mp3");
    GreenfootSound speedSound = new GreenfootSound("coin-upaif-14631.mp3");
    GreenfootImage[] idleRight = new GreenfootImage[8];
    GreenfootImage[] idleLeft = new GreenfootImage[8];
    
    int leftSpeed = -3;
    int rightSpeed = 3;
    // direction elephant is facing
    String facing = "right";
    SimpleTimer animationTimer = new SimpleTimer();
    
    public Elephant(){
        for(int i = 0; i < idleRight.length; i++)
        {
            idleRight[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            idleRight[i].scale(100, 100);
        }
        
        for(int i = 0; i < idleLeft.length; i++)
        {
            idleLeft[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            idleLeft[i].mirrorHorizontally();
            idleLeft[i].scale(100, 100);
        }
        
        animationTimer.mark();
        setImage(idleRight[0]);
    }
    
    
    int imageIndex = 0;
    public void animateElephant()
    {
        if(animationTimer.millisElapsed() < 100)
        {
            return;
        }
        animationTimer.mark();
        
        if(facing.equals("right"))
        {
            setImage(idleRight[imageIndex]);
            imageIndex = (imageIndex + 1) % idleRight.length;
        } else {
            setImage(idleLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % idleLeft.length;
        }
    }
    
    SimpleTimer speedTimer = new SimpleTimer();
    public void act()
    {
        if(speedTimer.millisElapsed() > 2500)
        {
            leftSpeed = -3;
            rightSpeed = 3;
        }
        
        if(Greenfoot.isKeyDown("a")){
            move(leftSpeed);
            facing = "left";
        }
        else if(Greenfoot.isKeyDown("d")){
            move(rightSpeed);
            facing = "right";
        }
        
        // remove apple if elephant eats it
        eat();
        
        animateElephant();
    }
    
    /*
         * Eat the apple and spawns a new apple if an apple is eaten
         */
        public void eat(){
            if(isTouching(Apple.class))
            {
                removeTouching(Apple.class);
                MyWorld world = (MyWorld) getWorld();
                world.createApple();
                world.increaseScore();
                elephantSound.play();
            }
            
            if(isTouching(Speed.class))
            {
                speedTimer.mark();
                removeTouching(Speed.class);
                leftSpeed = -5;
                rightSpeed = 5;
                MyWorld worldOne = (MyWorld) getWorld();
                worldOne.createSpeed();
                speedSound.play();
            }
        }
}
