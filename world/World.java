
package world;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.CopyOnWriteArrayList;
import world.players.Player;

public class World extends JPanel
{
    CopyOnWriteArrayList<Block> blocks;
    Player player;
    Color c4ov = new Color(255,0,0,100);
    
    Color forDebug = new Color(0,255,0,100);
    Color black = new Color(0,0,0,255);
    static int block_metric_x = -20;
    int block_metric_y;
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
	// Отрисовка сетки
	block_metric_x = (int) kostyl_dlya_setki.getPosition().getX();
	if(block_metric_x<-20)
	    kostyl_dlya_setki.setPosition(20,0);
	    
	if(block_metric_x>20)
	    kostyl_dlya_setki.setPosition(-20,0);

	block_metric_y = (int) kostyl_dlya_setki.getPosition().getY();
        
	if(block_metric_y<-20)
	    kostyl_dlya_setki.setPosition(0,20);
	    
	if(block_metric_y>20)
	    kostyl_dlya_setki.setPosition(0,-20);
	    
	for (int i = block_metric_y; i<=block_metric_y+540; i+=20)
	    g.drawLine(0,i,520,i);

	for (int i = block_metric_x; i<=block_metric_x+540; i+=20)
	    g.drawLine(i,0,i,520);
	// Отрисовка области взаимодействия
	//g.setColor(forDebug);                                                                                                         DEBUG!!!!!
	//System.out.println(block_metric_y);
	
	//g.fillRect((int)player.getPosition().getX()+player.getWidth()*20,(int) player.getPosition().getY()-20,40,player.getHeight()*20+40);
	
	g.setColor(c4ov);

	// Вправо
	if(block_metric_x>=0)
	g.fillRect((int)player.getPosition().getX()+player.getWidth()*20,(int) player.getPosition().getY(),40+block_metric_x,player.getHeight()*20);

	if(block_metric_x<0)
	g.fillRect((int)player.getPosition().getX()+player.getWidth()*20,(int) player.getPosition().getY(),40+20+block_metric_x,player.getHeight()*20);

	//Влево
	if(block_metric_x>0)
	    g.fillRect((int)player.getPosition().getX()-40-(20-block_metric_x),(int) player.getPosition().getY(),(int) 100-block_metric_x,player.getHeight()*20);
	
	if(block_metric_x<=0)
	    g.fillRect((int)player.getPosition().getX()-40+block_metric_x,(int) player.getPosition().getY(),(int) 80-block_metric_x,player.getHeight()*20);

	for(Block b : blocks)
	    {
		g.drawImage(b.getImage(), (int) b.getPosition().getX(), (int) b.getPosition().getY(), 20, 20, null);
	    }
	g.drawImage(player.getImage(),  (int) player.getPosition().getX(), (int) player.getPosition().getY(), player.getWidth()*20, player.getHeight()*20, null);
	
    }

    public static int getBlock_Metric_X()
    {
	return block_metric_x;
    }
}
