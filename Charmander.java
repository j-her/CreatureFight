import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class charmander here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Charmander extends Creature
{
    public Charmander(World w)
    {
        super(700,1);
        getImage().scale( 150, 100);
        w.addObject(getHealthBar(),300,w.getHeight()-50);
    }
    /**
     * Act - do whatever the charmander wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        CreatureWorld playerWorld=(CreatureWorld) getWorld();
        if(getHealthBar().getCurrent()<=0)
        {
            getWorld().showText("Charmander has fainted...",getWorld().getWidth()/2,getWorld().getHeight()/2+26);
            Greenfoot.delay(30);
        }
    }
}

