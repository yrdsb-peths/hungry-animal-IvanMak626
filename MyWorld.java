import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * the world
 * 
 * @author (Ivan Mak) 
 * @version (a version number or a date)
 */


public class MyWorld extends World
{
    public int score = 0;
    Label scoreLabel;
    int level = 2;
    Speed speed = new Speed();
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false);
        
        // create the elephant object
        Elephant elephant = new Elephant();
        addObject(elephant, 300, 300);
        
        scoreLabel = new Label(0, 80);
        addObject(scoreLabel, 30, 40);
        // spawns a new apple
        createApple();
        addObject(speed, Greenfoot.getRandomNumber(600), 0);
        createSpeed();
    }
    
    /*
     * End the game and draw a giant "Game Over"
     */
    public void gameOver(){
        Label gameOverLabel = new Label("Game Over", 100);
        addObject(gameOverLabel, 300, 200);
    }
    
    /*
     * Increases score
     */
    public void increaseScore(){
        score++;
        scoreLabel.setValue(score);
        
        if(score % 5 == 0)
        {
            level += 1;
        }
    }
    
    public void createApple(){
        Apple apple = new Apple();
        apple.setSpeed(level);
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(apple, x, y);
        
    }
    
    

    SimpleTimer lastAdded = new SimpleTimer();
    public void createSpeed()
    {
        speed.setSpeed(1);
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(speed, x, y);
        
    }
}
