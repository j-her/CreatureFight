import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import javax.swing.JOptionPane;
import java.util.List;

/**
 * Name: Jackson Hercina
 * Course: CS20S
 * Teacher: Mr. Hardman
 * Lab #1, Program #1
 * Date Last Modified: Thursday, September 28th, 2017 
 */
public class CreatureWorld extends World
{
    private Creature playerOneCreature;
    private Creature playerTwoCreature;
    /**
     * Default constructor for objects of class MyWorld.
     * 
     * @param There are no parameters
     * @return an object of class MyWorld
     */
    public CreatureWorld()
    {  
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(400, 400, 1); 
        playerOneCreature= new Charmander(this);
        playerTwoCreature= new Pikachu(this);
        prepareCreatures();
        
        
        Greenfoot.start();
    }
    
    private void prepareCreatures()
    {
        addObject(playerOneCreature, playerOneCreature.getImage().getWidth()/2, getHeight() - playerOneCreature.getImage().getHeight()/2);
        addObject( new Button(Color.RED,50), getWidth()/2, getHeight()-100);
        addObject(playerTwoCreature, getWidth() - playerTwoCreature.getImage().getWidth()/2, playerTwoCreature.getImage().getHeight()/2);
        addObject( new Button(Color.RED,50), getWidth()/2, 100);
        
    }
    public Creature getPlayerOne()
    {
        return playerOneCreature;
    }
    
    public Creature getPlayerTwo()
    {
        return playerTwoCreature;
    }
    
    /**
     * act will complete actions that the CreatureWorld object should
     * accomplish while the scenario is running
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public void act()
    {
       List allObjects=getObjects(null);
       
        if(playerOneCreature.getHealthBar().getCurrent()<=0)
        {
            removeObjects(allObjects);
            showText("playerTwo wins...",getWidth()/2,getHeight()/2);
            Greenfoot.stop();
        }
        
             if(playerTwoCreature.getHealthBar().getCurrent()<=0)
        {
            removeObjects(allObjects);
            showText("you win!...",getWidth()/2,getHeight()/2);
            Greenfoot.stop();
        }
    }
    
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        HealthBar healthbar = new HealthBar();
        addObject(healthbar,201,134);
        healthbar.setLocation(209,153);
        healthbar.setLocation(178,165);
        healthbar.setLocation(198,167);
        Button button = new Button();
        addObject(button,128,305);
        Button button2 = new Button();
        addObject(button2,293,310);
        removeObject(button);
        removeObject(button2);
        removeObject(healthbar);
    }
}
