package world;

import world.Block;
import java.util.concurrent.CopyOnWriteArrayList;
import java.awt.image.BufferedImage;

public class Drop
{
    int x, y, height, width, item;
    CopyOnWriteArrayList<Block> blocks;
    
    public Drop(int x, int y, int width, int height, int item, CopyOnWriteArrayList<Block> blocks)
    {
	this.x=x;
	this.y=y;
	this.blocks=blocks;
	this.width=width;
	this.item=item;
	this.height=height;
	gravitation.start();
    }
    Thread gravitation = new Thread(() ->
				    {
				        int speed = 99;
					int step;
					while (true)
					    {			    
						int gonnaFly  = 1;
						step = 0;
						int final_step = 0;
					        
						    for (Block b : blocks)
							{
							    if( x>(int) (b.getPosition().getX())+20 //+width
							       ||
							       x+(width)<(int) (b.getPosition().getX())
							       ) //Вне
								{}
							    else
								{
								    step=speed/100;
								    while(step>=0) //????????????????????????????
									{
									    if(y+(height)==(int) (b.getPosition().getY())-step
				        				       )
										{
										    gonnaFly= 0;
										    final_step=step;
										}
									    step--;
									}
								}
							}
						    if (gonnaFly==0)
							{
							    
							        this.y+=final_step;
					        	    speed    = 99;
							    
			
							}
						    if(gonnaFly==1)
							{
					        	    
								this.y+=speed/100;
							
							    if (speed<1000)
								speed+=2;
							}
						
					
						try
						    {
							Thread.sleep(20);
						    }
						catch (Exception e)
						    {
						    }
					    }
				    });


    public int getX()
    {
	return x;
    }

    public int getY()
    {
	return y;
    }

    public int getWidth()
    {
	return width;
    }

    public void setPosition(int x, int y)
    {
	this.x+=x;
	this.y+=y;
    }

    public int getHeight()
    {
	return height;
    }

    public BufferedImage getImage()
    {
	return ImgCol.items[item];
    }

}
