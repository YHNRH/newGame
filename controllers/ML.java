package controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import world.World;
import world.players.Player;
import world.Block;
import java.util.concurrent.CopyOnWriteArrayList;

public class ML implements MouseListener
{
    CopyOnWriteArrayList<Block> blocks;
    Player player;
    World world;
    public ML(CopyOnWriteArrayList<Block> blocks, Player player, World world)
    {
	this.blocks=blocks;
	this.player=player;
	this.world = world;
    }

    public void mouseClicked(MouseEvent e) {
	int x = e.getX();
	int y = e.getY();
	System.out.println(x + " " + y);
	System.out.println((x)/20*20+" "+(y)/20*20);
	System.out.println(world.getBlock_Metric_X());
	System.out.println();
	blocks.add(new Block(Block.GROUND, (x+(20-World.getBlock_Metric_X()))/20,(y)/20-2));
    }
 
    public void mouseEntered(MouseEvent e) {
    }
 
    public void mouseExited(MouseEvent e) {
    }
 
    public void mousePressed(MouseEvent e) {
    }
 
    public void mouseReleased(MouseEvent e) {
    }

}
