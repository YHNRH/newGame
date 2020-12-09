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
	//	blocks.add(new Block(Block.GROUND, (x+(20-World.getBlock_Metric_X()))/20,(y)/20-2)); РАБОТАЛО
	if (World.getBlock_Metric_Y()>=0)
	blocks.add(new Block(Block.GROUND, (x+(20-World.getBlock_Metric_X()))/20,(y-(20+(World.getBlock_Metric_Y())))/20));
	else
	    blocks.add(new Block(Block.GROUND, (x+(20-World.getBlock_Metric_X()))/20,(y-(40+(World.getBlock_Metric_Y())))/20));
	
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
