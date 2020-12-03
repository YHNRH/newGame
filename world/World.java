
package world;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.CopyOnWriteArrayList;
import world.players.Player;

public class World extends JPanel
{
    CopyOnWriteArrayList<Block> blocks;
    Player player;
    public World (CopyOnWriteArrayList<Block> blocks, Player player)
    {
	this.blocks=blocks;
	this.player=player;
    }
    protected void paintComponent(Graphics g)
    {
	super.paintComponent(g);
	for (int i = 20; i<=500; i+=20)
	    g.drawLine(0,i,500,i);

	for (int i = 20; i<=500; i+=20)
	    g.drawLine(i,0,i,500);

	for(Block b : blocks)
	    {
		g.drawImage(b.getImage(), (int) b.getPosition().getX(), (int) b.getPosition().getY(), 20, 20, null);
	    }
	g.drawImage(player.getImage(),  (int) player.getPosition().getX(), (int) player.getPosition().getY(), player.getWidth()*20, player.getHeight()*20, null);
	
    }
}
