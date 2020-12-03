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
    public KL(CopyOnWriteArrayList<Block> blocks, Player player)
    {
	this.blocks=blocks;
	this.player=player;
    }
    public void keyPressed(KeyEvent e)
    {
	int key = e.getKeyCode();
	if(key == 32)
	    {
		player.setJump(1);
	    }
		if(key == 68) //D
		    {
		int move=1;
		for (Block b : blocks)
		    if ((int) (player.getPosition().getY())>=(int)(b.getPosition().getY())+20
			||
			(int) (player.getPosition().getY())+player.getHeight()*20<=(int)(b.getPosition().getY())
			||
			(int) (player.getPosition().getX())>=(int) (b.getPosition().getX())+20)
			
			{}
		    else
			{
			    if ((int) player.getPosition().getX()+player.getWidth()*20+1>=b.getPosition().getX())
				move=0; //Нельзя ходить!
			}

		if(move==1)
		    for (Block b : blocks)
			{
			    b.setPosition(-1,0);
			}
	    }

	if(key == 65) //A
	    {
		int move=1;
		for (Block b : blocks)
		    if ((int) (player.getPosition().getY())>=(int)(b.getPosition().getY())+20
			||
			(int) (player.getPosition().getY())+player.getHeight()*20<=(int)(b.getPosition().getY())
			||
			(int) (player.getPosition().getX())+player.getWidth()*20<=(int) (b.getPosition().getX()))
			
			{}
		    else
			{
			    if ((int) player.getPosition().getX()-1<=b.getPosition().getX()+20)
				move=0; //Нельзя ходить!
			}

		if(move==1)
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
