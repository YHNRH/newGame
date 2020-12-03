package world.players;

import world.Block;
import java.awt.image.*;
import java.awt.Point;
import java.util.concurrent.CopyOnWriteArrayList;

public class Player extends Entity
{
    
    BufferedImage[][] img;
    int fly;
    int jump;
    int vPrijke;
    CopyOnWriteArrayList<Block> blocks;
    public Player(Point pos,
		  BufferedImage[][] img,
		  int width,
		  int height, 
		  CopyOnWriteArrayList<Block> blocks
		  )
    {
	this.pos=pos;
	this.img=img;
	this.width=width;
	this.height=height;
	this.blocks=blocks;
	gravitation.start();
	t_jump.start();
    }
    Thread gravitation = new Thread(() ->
    {
        double speed = 10;
	int step;
	while (true)
	    {
		int gonnaFly  = 1;
		step = 0;
		int final_step = 0;
		int gonnaStop = 0; 
		for (Block b : blocks)
		    {
			
		if((int) (pos.getX())>(int) (b.getPosition().getX())+20 //+width
		   ||
		   (int) (pos.getX())+(width*20)<(int) (b.getPosition().getX())) //Вне
		    {}
		else
		    {
			while(step<=10)
			    {
				if((int) (pos.getY())+(height*20)==(int) (b.getPosition().getY())-step)
				    {
					gonnaStop= 1;
				        final_step=step;
				    }
				step++;
			    }
			
		    }
		    }
		if (gonnaStop==1 && vPrijke==0)
		    {
			for (Block b : blocks)
			    b.setPosition(0,-final_step);
			gonnaFly = 0;
			fly      = 0;
			speed    = 10;
			
		    }
		if(gonnaFly==1)
		    {
			fly=1;
			if (speed<100)
			speed+=0.1;
			for (Block b : blocks)
			    b.setPosition(0,-(int)speed/10);
		    }
	    	try
	    {
		Thread.sleep(10);
	    }
	catch (Exception e)
	{}}
    });

    public int getFly()
    {
	return fly;
    }
    public void setFly(int fly)
    {
	this.fly=fly;
    }
    public BufferedImage getImage()
    {
	return img[1][1];
    }

    public void setJump(int i)
    {
	jump=i;
    }

    Thread t_jump = new Thread(()->{
	    while (true)
		{
		    if(this.getFly()==0 && jump==1) // Не в полете
			{
			    jump=0;
			    vPrijke = 1;
			    this.setFly(1);
			    int co = 30;
			    while(co/7!=0)
				{
				    for(Block b : blocks)
					b.setPosition(0,co/5);
				    try
					{
					Thread.sleep(10);
					}
				    catch(Exception ex)
					{ex.printStackTrace();}
				    co--;
				    
				}
			    vPrijke=0;
			}
		    try
					{
					Thread.sleep(30);
					}
				    catch(Exception ex)
					{ex.printStackTrace();}
				    
		}
    }
	    );
    
}
