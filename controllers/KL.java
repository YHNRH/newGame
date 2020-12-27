package controllers;
import java.awt.event.*;
import world.*;
import world.players.Player;
import world.interfac.Cell;
import utils.GenerateUtil;
import java.util.concurrent.CopyOnWriteArrayList;
public class KL implements KeyListener
{
    static CopyOnWriteArrayList<Block> blocks;
    CopyOnWriteArrayList<Cell> inventory;
    Player player;
    public KL( CopyOnWriteArrayList<Cell> inventory, Player player)
    {
	
        this.player=player;
	this.inventory=inventory;
    }

    public void keyPressed(KeyEvent e)
    {
	int key = e.getKeyCode();
	if (key==8) // BACKSPASE??
	    {
		System.out.println("SAVED");
		GenerateUtil.save();
	    }
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
	try{
	    Thread.sleep(20);
	}
	catch (InterruptedException ex)
	    {
		System.out.println("Ошибка клавиатуры");
	    }
    }

    public void keyTyped(KeyEvent e)
    {

    }

    
    public static void setBlocks(CopyOnWriteArrayList<Block> blockss)
    {
	blocks=blockss;
    }
}
