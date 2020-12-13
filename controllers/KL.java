package controllers;
import java.awt.event.*;
import world.Block;
import world.World;
import world.players.Player;
import world.interfac.Cell;
import java.util.concurrent.CopyOnWriteArrayList;
public class KL implements KeyListener
{
    CopyOnWriteArrayList<Block> blocks;
    CopyOnWriteArrayList<Cell> inventory;
    Player player;
    int lastKey = 0;
    public KL(CopyOnWriteArrayList<Block> blocks, CopyOnWriteArrayList<Cell> inventory, Player player)
    {
	this.blocks=blocks;
	this.player=player;
	this.inventory=inventory;
    }
    public void keyPressed(KeyEvent e)
    {
	int key = e.getKeyCode();
	if(key == 49) // 1
	    {
	        Cell cell = inventory.get(0);
		System.out.println("Выбрана ячейка");
				if(cell.getChosen()==true)
				    {
					cell.setChosen(false);
				    }
				else
				    {
					for (Cell cell1 : inventory)
					    {
						cell1.setChosen(false);
					    }
					cell.setChosen(true);
					player.setItem(cell);
				    }
	    }
	if(key == 50) // 2
	    {
	        Cell cell = inventory.get(1);
		System.out.println("Выбрана ячейка");
				if(cell.getChosen()==true)
				    {
					cell.setChosen(false);
				    }
				else
				    {
					for (Cell cell1 : inventory)
					    {
						cell1.setChosen(false);
					    }
					cell.setChosen(true);
					player.setItem(cell);
				    }
	    }
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
	if(key == 32) // SPACE
	    player.setJump(0);
    }

    public void keyTyped(KeyEvent e)
    {

    }
}
