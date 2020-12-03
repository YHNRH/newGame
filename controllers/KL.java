package controllers;
import java.awt.event.*;
import world.Block;
import world.World;
import world.players.Player;
import java.util.concurrent.CopyOnWriteArrayList;
public class KL implements KeyListener
{
    CopyOnWriteArrayList<Block> blocks;
    Player player;
    int lastKey = 0;
    public KL(CopyOnWriteArrayList<Block> blocks, Player player)
    {
	this.blocks=blocks;
	this.player=player;
    }
    public void keyPressed(KeyEvent e)
    {
	int key = e.getKeyCode();
	if(key == 32) // SPACE
	    {
		player.setJump(1);
	    }
	if(key == 68) //D
	    {
		player.setMoveRight(1);
	    }

	if(key == 65) //A
	    {
		player.setMoveLeft(1);
	    }
    }

    public void keyReleased(KeyEvent e)
    {
        int key = e.getKeyCode();
	if (key == 68) //D
	    player.setMoveRight(0);
	if (key == 65) //A
	    player.setMoveLeft(0);
    }

    public void keyTyped(KeyEvent e)
    {

    }
}
