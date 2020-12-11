package controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import world.World;
import world.players.Player;
import world.interfac.Cell;
import world.Block;
import java.util.concurrent.CopyOnWriteArrayList;

public class ML implements MouseListener
{
    CopyOnWriteArrayList<Block> blocks;
    CopyOnWriteArrayList<Cell> inventory;
    Player player;
    World world;
    public ML(CopyOnWriteArrayList<Block> blocks,CopyOnWriteArrayList<Cell> inventory, Player player, World world)
    {
	this.blocks=blocks;
	this.player=player;
	this.world = world;
	this.inventory=inventory;
    }

    public void mouseClicked(MouseEvent e) {
	int canPutBlock = 0;
	int x = e.getX();
	int y = e.getY();

	//	blocks.add(new Block(Block.GROUND, (x+(20-World.getBlock_Metric_X()))/20,(y)/20-2)); РАБОТАЛО

	// Пороверка на выбор предметов

	for (Cell cell : inventory)
	    {
			if (
			    x>= cell.getX()
			    && x<=  cell.getX()+cell.getWidth()
			    && y >=  cell.getY()
			    && y <=  cell.getY()+cell.getHeight()
			    )
			    {
				System.out.println("Выбрана ячейка");
				if(cell.getChosen()==true)
				    {
					cell.setChosen(false);
				    }
				else
				    {
					for (Cell cell1 : inventory)
					    {
						cell1.setChosen(false);
					    }
					cell.setChosen(true);
					player.setItem(cell.getItem());
				    }
				
			    }
	    }
	


	if(player.getItem()>0 && player.getItem()<50) // Установка блоков
	    {
			// Проверка на наличие блоков рядом

		for (Block b : blocks)
	    {
		if (World.getBlock_Metric_Y()>=0)
		    {
			if(
			   (
			    ((x+(20-World.getBlock_Metric_X()))/20)*20+World.getBlock_Metric_X()-20==(int)b.getPosition().getX()+b.getWidth()
			    &&
			    ((y-(20+(World.getBlock_Metric_Y())))/20)*20+World.getBlock_Metric_Y()%20+20==(int)b.getPosition().getY()
			    )// Справа
			   ||
			   (
			    ((x+(20-World.getBlock_Metric_X()))/20)*20+World.getBlock_Metric_X()-20+20==(int)b.getPosition().getX()
			    &&
			    ((y-(20+(World.getBlock_Metric_Y())))/20)*20+World.getBlock_Metric_Y()%20+20==(int)b.getPosition().getY()			    
			    ) // Слева
			   ||
			   (
			    ((y-(20+(World.getBlock_Metric_Y())))/20)*20+World.getBlock_Metric_Y()%20+20+20==(int)b.getPosition().getY()//+b.getHeight()
			    &&
			    ((x+(20-World.getBlock_Metric_X()))/20)*20+World.getBlock_Metric_X()-20==(int)b.getPosition().getX()
			    ) // Ставишь выше другого блока
			   ||
			   (
			    ((y-(20+(World.getBlock_Metric_Y())))/20)*20+World.getBlock_Metric_Y()%20==(int)b.getPosition().getY()
			    &&
			    ((x+(20-World.getBlock_Metric_X()))/20)*20+World.getBlock_Metric_X()-20==(int)b.getPosition().getX()
			    ) // Ставишь ниже другого блока
			   )
			    {
				canPutBlock=1;
				System.out.println("Есть блок рядом");
			    }
		    }
		else
		    {
		        if(
			   (
			    ((x+(20-World.getBlock_Metric_X()))/20)*20+World.getBlock_Metric_X()-20==(int)b.getPosition().getX()+b.getWidth()
			    &&
			    ((y-(40+(World.getBlock_Metric_Y())))/20)*20+World.getBlock_Metric_Y()%20+20==(int)b.getPosition().getY()
			    )// Справа
			   ||
			   (
			    ((x+(20-World.getBlock_Metric_X()))/20)*20+World.getBlock_Metric_X()-20+20==(int)b.getPosition().getX()
			    &&
			    ((y-(40+(World.getBlock_Metric_Y())))/20)*20+World.getBlock_Metric_Y()%20+20==(int)b.getPosition().getY()			    
			    ) // Слева
			   ||
			   (
			    ((y-(40+(World.getBlock_Metric_Y())))/20)*20+World.getBlock_Metric_Y()%20+20+20==(int)b.getPosition().getY()//+b.getHeight()
			    &&
			    ((x+(20-World.getBlock_Metric_X()))/20)*20+World.getBlock_Metric_X()-20==(int)b.getPosition().getX()
			    ) // Ставишь выше другого блока
			   ||
			   (
			    ((y-(40+(World.getBlock_Metric_Y())))/20)*20+World.getBlock_Metric_Y()%20==(int)b.getPosition().getY()
			    &&
			    ((x+(20-World.getBlock_Metric_X()))/20)*20+World.getBlock_Metric_X()-20==(int)b.getPosition().getX()
			    ) // Ставишь ниже другого блока
			   )
			    {
				canPutBlock=1;
				System.out.println("Есть блок рядом");
			    }
		    }
	    }
	
	// Проверка с блоками
	for (Block b : blocks)
	    {
		if (x>=(int) b.getPosition().getX()
		    && x<= (int) b.getPosition().getX()+b.getWidth()
		    && y >= (int) b.getPosition().getY()
		    //Я не понимаю почему это так, но работает корректно только с +40. Возможно это изза верхней рамки окна
		    && y <= (int) b.getPosition().getY()+b.getHeight()
		    )
		    {
			System.out.println("Попытка поставить в блок");
			canPutBlock=0;
		    }
		
	    }
	//Проверка с зоной взаимодействия

	if (World.getBlock_Metric_X()>=0)
	    if(x>(int)player.getPosition().getX()+player.getWidth()*20+60+World.getBlock_Metric_X()
	       || x< (int)player.getPosition().getX()-40-(20-World.getBlock_Metric_X())
	       || y< (int) player.getPosition().getY()-40+World.getBlock_Metric_Y()
	       || y> (int) player.getPosition().getY()-40+World.getBlock_Metric_Y()+player.getHeight()*20+120
	       )
		{
		    System.out.println("Вне зоны взаимодействия");
		    canPutBlock=0;
		}
			
	if (World.getBlock_Metric_X()<0)
	    if(x>(int)player.getPosition().getX()+player.getWidth()*20+60+20+World.getBlock_Metric_X()
	       || x < (int)player.getPosition().getX()-40+World.getBlock_Metric_X()
	       || y < (int) player.getPosition().getY()-40+World.getBlock_Metric_Y()
	       || y > (int) player.getPosition().getY()-40+World.getBlock_Metric_Y()+player.getHeight()*20+120
	       )
		{
		    System.out.println("Вне зоны взаимодействия");
		    canPutBlock=0;
		}
		
	
	//Проверка с плеером
	
	if (x>=(int) player.getPosition().getX()
	    && x<= (int) player.getPosition().getX()+player.getWidth()*20
	    && y >= (int) player.getPosition().getY()
	    //Я не понимаю почему это так, но работает корректно только с +40. Возможно это изза верхней рамки окна
	    && y <= (int) player.getPosition().getY()+player.getHeight()*20
	    )
	    {
		canPutBlock=0;
		System.out.println("Попытка установить в плеера");
	    }
	
	
	/*if (canPutBlock==1){
	  if (World.getBlock_Metric_Y()>=0)
	  blocks.add(new Block(Block.GROUND, (x+(20-World.getBlock_Metric_X()))/20,(y-(20+(World.getBlock_Metric_Y())))/20));
	  else
	  blocks.add(new Block(Block.GROUND, (x+(20-World.getBlock_Metric_X()))/20,(y-(40+(World.getBlock_Metric_Y())))/20));
	  }
	  else
	  {System.out.println("Я не могу поставить блок");}
	  РАБОТАЛО*/
	System.out.println("x="+x+" y="+y);
	System.out.println(World.getBlock_Metric_Y());
	System.out.println("real x= "+(((x+(20-World.getBlock_Metric_X()))/20)*20+World.getBlock_Metric_X()-20));
	if (canPutBlock==1)
	    {
		if (World.getBlock_Metric_Y()>=0)
		    {
			blocks.add(new Block(player.getItem(), ((x+(20-World.getBlock_Metric_X()))/20)*20+World.getBlock_Metric_X()-20,((y-(20+(World.getBlock_Metric_Y())))/20)*20+World.getBlock_Metric_Y()%20+20));
		    }
		else
		    {
			blocks.add(new Block(player.getItem(), ((x+(20-World.getBlock_Metric_X()))/20)*20+World.getBlock_Metric_X()-20,((y-(40+(World.getBlock_Metric_Y())))/20)*20+World.getBlock_Metric_Y()%20-20));
				
		    }
	    }
	else
	    {System.out.println("Я не могу поставить блок");}
	    }
	else if(player.getItem()>=50 && player.getItem()<60) // Разбивать блоки
	    {
	        
		for (Block b : blocks)
		    {
			if (
			    x>=(int) b.getPosition().getX()
			    && x<= (int) b.getPosition().getX()+b.getWidth()
			    && y >= (int) b.getPosition().getY()
			    && y <= (int) b.getPosition().getY()+b.getHeight()
			    )
			    {
				System.out.println("Блок удален");
				blocks.remove(b);
			        
			    }
			
			
		    }
		
	    }
		
		
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
