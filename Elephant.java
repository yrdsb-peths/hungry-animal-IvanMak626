import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Elephant, our hero.
 * @author (Ivan Mak) 
 * @version (a version number or a date)
 */
public class Elephant extends Actor
{
    GreenfootSound elephantSound  = new GreenfootSound("elephantcub.mp3");
    public void act()
    {
        if(Greenfoot.isKeyDown("a")){
            move(-2);
        }
        if(Greenfoot.isKeyDown("d")){
            move(2);
        }
        
        // remove apple if elephant eats it
        eat();
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
        }
}
