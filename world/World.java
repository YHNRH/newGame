
package world;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class World extends JPanel
{
    CopyOnWriteArrayList<Block> blocks = new CopyOnWriteArrayList<>();

    public World (CopyOnWriteArrayList<Block> blocks)
    {
	this.blocks=blocks;
    }
    protected void paintComponent(Graphics g)
    {
	super.paintComponent(g);
	for (int i = 10; i<=500; i+=10)
	    g.drawLine(0,i,500,i);

	for (int i = 10; i<=500; i+=10)
	    g.drawLine(i,0,i,500);

	for(Block b : blocks)
	    {
		g.drawImage(b.getImage(), (int) b.getPosition().getX(), (int) b.getPosition().getY(), 10, 10, null);
	    }
	
    }
}
