
package world;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.CopyOnWriteArrayList;
import world.players.Player;

public class World extends JPanel
{
    CopyOnWriteArrayList<Block> blocks;
    Player player;
    static int block_metric_x = -20;
    public static Block kostyl_dlya_setki = new Block (Block.GROUND,0,0);
    
    public World (CopyOnWriteArrayList<Block> blocks, Player player)
    {
	this.blocks=blocks;
	this.player=player;
	this.blocks.add(kostyl_dlya_setki);
    }
    protected void paintComponent(Graphics g)
    {
	super.paintComponent(g);
	for (int i = 20; i<=520; i+=20)
	    g.drawLine(0,i,520,i);

	// Сетка столбики

	block_metric_x = (int) kostyl_dlya_setki.getPosition().getX();
	System.out.println(block_metric_x);
	if(block_metric_x<-20)
	    kostyl_dlya_setki.setPosition(20,0);
	    
	if(block_metric_x>20)
	    kostyl_dlya_setki.setPosition(-20,0);
	    
	for (int i = block_metric_x; i<=block_metric_x+540; i+=20)
	    g.drawLine(i,0,i,520);

	for(Block b : blocks)
	    {
		g.drawImage(b.getImage(), (int) b.getPosition().getX(), (int) b.getPosition().getY(), 20, 20, null);
	    }
	g.drawImage(player.getImage(),  (int) player.getPosition().getX(), (int) player.getPosition().getY(), player.getWidth()*20, player.getHeight()*20, null);
	
    }
}
