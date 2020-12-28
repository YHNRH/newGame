import java.awt.image.*;
import java.awt.Point;
import java.util.concurrent.CopyOnWriteArrayList;

public class Player extends Entity
{
    
    BufferedImage[][] img;
    int fly;
    int stepCount = 1;
    int dir       = 0;
    int jump;
    int vPrijke   = 0;
    int moveRight;
    Cell item;
    int moveLeft;
    int ostanovka_v_prijke; 
    static CopyOnWriteArrayList<Block> blocks;
    CopyOnWriteArrayList<Drop> drops;
    public Player(Point pos,
		  BufferedImage[][] img,
		  int width,
		  int height, 
		  CopyOnWriteArrayList<Drop> drops
		  )
    {
	
	this.pos=pos;
	this.img=img;
	this.width=width;
	this.height=height;
        this.drops=drops;
	//gravitation.start();
	t_jump.start();
	t_move.start();
    }
    /*
    Thread gravitation = new Thread(() ->
				    {
				        int speed = 99;
					int step;
					while (true)
					    {			    
						int gonnaFly  = 1;
						step = 0;
						int final_step = 0;
						if (vPrijke==0){
						    for (Block b : blocks)
							{
							    if((int) (pos.getX())>(int) (b.getPosition().getX())+20 //+width
							       ||
							       (int) (pos.getX())+(width*20)<(int) (b.getPosition().getX())
							       ) //Вне
								{}
							    else
								{
								    step=speed/100;
								    while(step>=0) //????????????????????????????
									{
									    if((int) (pos.getY())+(height*20)==(int) (b.getPosition().getY())-step
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
							    for (Block b : blocks)
								b.setPosition(0,-final_step);
							    fly      = 0;
							    speed    = 99;
							    World.kostyl_dlya_setki.setPositionToNol();
			
							}
						    if(gonnaFly==1)
							{
							    fly=1;
							    for (Block b : blocks)
								b.setPosition(0,-(speed/100));
							
							    if (speed<1000)
								speed+=2;
							}
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
    */
    Thread t_move = new Thread(()->
				   {
				       while (true)
					   {
					       if (moveLeft==1)
						   {
						       dir = 0; 
						       int move=1;
						       for (Block b : blocks)
							   if ((int) (this.getPosition().getY())>=(int)(b.getPosition().getY())+20
							       ||
							       (int) (this.getPosition().getY())+this.getHeight()*20<=(int)(b.getPosition().getY())
							       ||
							       (int) (this.getPosition().getX())+this.getWidth()*20<=(int) (b.getPosition().getX()))
			
							       {}
							   else
							       {
								   if ((int) this.getPosition().getX()<=b.getPosition().getX()+20)
								       move=0; //Нельзя ходить!
							       }

						       if(move==1)
							   {
							   for (Block b : blocks)
							       {
								   b.setPosition(3,0);
							}
							   for (Drop d : drops)
							       d.setPosition(3,0);
							
							   }
						         stepCount++;
							 if(stepCount>=29)
							     stepCount=0;
							       
								 
						   }
					       else if (moveRight==1)
						    {
							int move=1;
							dir = 1;
							for (Block b : blocks)
							    {
					        		if ((int) (this.getPosition().getY())>=(int)(b.getPosition().getY())+20
								    ||
								    (int) (this.getPosition().getY())+this.getHeight()*20<=(int)(b.getPosition().getY())
								    ||
								    (int) (this.getPosition().getX())>=(int) (b.getPosition().getX())+20)
			
								    {}
								else
								    {
									if ((int) this.getPosition().getX()+this.getWidth()*20>=b.getPosition().getX())
									    move=0; //Нельзя ходить!
								    }
							    }
							if(move==1)
							    {
								for (Block b : blocks)
								    b.setPosition(-3,0);
								for (Drop d : drops)
								    d.setPosition(-3,0);
								stepCount++;
								if(stepCount>=29)
								    stepCount=0;
							    }
						    }
						try
						   {
						       Thread.sleep(60);
						   }
					       catch (Exception e)
						   {System.out.println("EROOR IN PLAYER THREAD MOVE");}
					   }
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
	return img[stepCount/10][dir];
    }

    public void setJump(int i)
    {
	jump=i;
    }

    public Cell getItem()
    {
	return item;
    }

    public static void setBlocks(CopyOnWriteArrayList<Block> blockss)
    {
	blocks=blockss;
    }

    public void setItem(Cell item)
    {
	this.item=item;
    }

    public void setMoveRight(int a)
    {
	if(moveLeft==0)
	    moveRight=a;
    }

    public void setMoveLeft(int a)
    {
	if(moveRight==0)
	    moveLeft=a;
    }

    public int getVPrijke()
    {
	return vPrijke;
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
			    int step;
			    ostanovka_v_prijke = 0;
			    int final_step = 0;
			    while(co/7!=0)
				{
				    for(Block b : blocks)
					{
					    step=0;
					    if((int) (pos.getX())>=(int) (b.getPosition().getX())+20 //+width
					       ||
					       (int) (pos.getX())+(width*20)<=(int) (b.getPosition().getX())
					       ) //Вне
						{}
					    else
						{
					    
						    while(step<=co/7) //????????????????????????????
							{
							    if((int) (pos.getY())==(int) (b.getPosition().getY())+20+step
							       //   ||
							       // (int) (pos.getY())+(height*20)==(int) (b.getPosition().getY())-(int)(speed/10)-1
							       )
								{
								    ostanovka_v_prijke = 1;
								    final_step=step;
								}
							    step++;
							}
						}
					}
				    if (ostanovka_v_prijke==0)
					{
					    for(Block b : blocks)
						b.setPosition(0,co/7);
					    for(Drop d : drops)
						d.setPosition(0,co/7);
					}
				    else
					{
					    for(Block b : blocks)
						b.setPosition(0,final_step);
					    for(Drop d : drops)
						d.setPosition(0,final_step);
					}
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
			    Thread.sleep(20);
			}
		    catch(Exception ex)
			{ex.printStackTrace();}
				    
		}
    }
	);
    
}
