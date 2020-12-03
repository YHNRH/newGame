package controllers;
import java.awt.event.*;
import world.Block;
import world.World;
import java.util.concurrent.CopyOnWriteArrayList;
public class KL implements KeyListener
{
    CopyOnWriteArrayList<Block> blocks;
    public KL(CopyOnWriteArrayList<Block> blocks)
    {
	this.blocks=blocks;
    }
    public void keyPressed(KeyEvent e)
    {
	int key = e.getKeyCode();
	if(key == 68) //D
	    {
		for (Block b : blocks)
		    {
			b.setPosition(-1,0);
		    }
	    }

	if(key == 65) //A
	    {
		for (Block b : blocks)
		    {
			b.setPosition(1,0);
		    }
	    }
    }

    public void keyReleased(KeyEvent e)
    {

    }

    public void keyTyped(KeyEvent e)
    {

    }
}
