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
