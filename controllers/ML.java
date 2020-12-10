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
	int canPutBlock = 1;
	int x = e.getX();
	int y = e.getY();
	int debug_counter=0;
	System.out.println("x "+ x+" y "+y);
	
	System.out.println("pl x "+ player.getPosition().getX()+" pl y "+player.getPosition().getY());
	//	blocks.add(new Block(Block.GROUND, (x+(20-World.getBlock_Metric_X()))/20,(y)/20-2)); РАБОТАЛО

	// Проверка с блоками
	for (Block b : blocks)
	    {debug_counter++;
		//	System.out.println("Блок №"+ debug_counter);
		//System.out.println("x " + (int) b.getPosition().getX());
		//System.out.println("y "+b.getPosition().getY());
		if (x>=(int) b.getPosition().getX()
		    && x<= (int) b.getPosition().getX()+b.getWidth()
		    && y >= (int) b.getPosition().getY()+40
		    //Я не понимаю почему это так, но работает корректно только с +40. Возможно это изза верхней рамки окна
		    && y <= (int) b.getPosition().getY()+b.getHeight()+40
		    )
		    canPutBlock=0;
		
	    }
	//Проверка с зоной взаимодействия

	if (World.getBlock_Metric_X()>=0)
	    if(x>(int)player.getPosition().getX()+player.getWidth()*20+60+World.getBlock_Metric_X()
	       || x< (int)player.getPosition().getX()-40-(20-World.getBlock_Metric_X())
	       || y-40< (int) player.getPosition().getY()-40+World.getBlock_Metric_Y()
	       || y-40> (int) player.getPosition().getY()-40+World.getBlock_Metric_Y()+player.getHeight()*20+120
	       )
		    canPutBlock=0;

			
	if (World.getBlock_Metric_X()<0)
	    if(x>(int)player.getPosition().getX()+player.getWidth()*20+60+20+World.getBlock_Metric_X()
	       || x < (int)player.getPosition().getX()-40+World.getBlock_Metric_X()
	       || y-40 < (int) player.getPosition().getY()-40+World.getBlock_Metric_Y()
	       || y-40 > (int) player.getPosition().getY()-40+World.getBlock_Metric_Y()+player.getHeight()*20+120
	       )
		canPutBlock=0;
		
	
	//Проверка с плеером
	
		if (x>=(int) player.getPosition().getX()
		    && x<= (int) player.getPosition().getX()+player.getWidth()*20
		    && y >= (int) player.getPosition().getY()+40
		    //Я не понимаю почему это так, но работает корректно только с +40. Возможно это изза верхней рамки окна
		    && y <= (int) player.getPosition().getY()+player.getHeight()*20+40
		    )
		    {
			canPutBlock=0;
			System.out.println("Попытка установить в плеера");
		    }
	
	
	if (canPutBlock==1){
	    if (World.getBlock_Metric_Y()>=0)
		blocks.add(new Block(Block.GROUND, (x+(20-World.getBlock_Metric_X()))/20,(y-(20+(World.getBlock_Metric_Y())))/20));
	    else
		blocks.add(new Block(Block.GROUND, (x+(20-World.getBlock_Metric_X()))/20,(y-(40+(World.getBlock_Metric_Y())))/20));
	}
	else
	    {System.out.println("Я не могу поставить блок");}
	
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
