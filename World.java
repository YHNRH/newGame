import javax.swing.*;
import java.awt.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class World extends JPanel
{
    static CopyOnWriteArrayList<Block> blocks;
    CopyOnWriteArrayList<Cell> inventory;
    CopyOnWriteArrayList<Drop> drops;
    Player player;
    Color red = new Color(255,0,0,100);
    Color blue = new Color(0,0,255,100);
    Color yellow = new Color(255,255,0,100);
    
    Color forDebug = new Color(0,255,0,100);
    Color black = new Color(0,0,0,255);
    static int block_metric_x = -20;
    static int block_metric_y;
    Block kostyl_dlya_setki;
    
    public World (CopyOnWriteArrayList<Cell> inventory, CopyOnWriteArrayList<Drop> drops, Player player)
    {
	
        this.player=player;
	this.inventory=inventory;
	this.drops=drops;
	kostyl_dlya_setki=GenerateUtil.getKostyl();
	gravitation.start();
    }
    protected void paintComponent(Graphics g)
    {
	super.paintComponent(g);

	// Отрисовка фона

	g.drawImage(ImgCol.background,-300,-300,2560,1440, null);
	
	// Отрисовка сетки
	if(block_metric_x<-20)
	    kostyl_dlya_setki.setPosition(20,0);
	    
	if(block_metric_x>20)
	    kostyl_dlya_setki.setPosition(-20,0);

	if(block_metric_y<-20)
	    kostyl_dlya_setki.setPosition(0,20);
	    
	if(block_metric_y>20)
	    kostyl_dlya_setki.setPosition(0,-20);
	
	block_metric_x = (int) kostyl_dlya_setki.getPosition().getX();
	
	block_metric_y = (int) kostyl_dlya_setki.getPosition().getY();
        for (int i = block_metric_y; i<=block_metric_y+540; i+=20)
	    g.drawLine((int)player.getPosition().getX()/2,(int)player.getPosition().getY()/2+i-10,(int)player.getPosition().getX()+(int)player.getPosition().getX()/2,(int)player.getPosition().getY()/2+i-10);

	for (int i = block_metric_x; i<=block_metric_x+540; i+=20)
	    g.drawLine((int)player.getPosition().getX()/2+(int)player.getPosition().getX()/4+i,(int)player.getPosition().getY()/2-50,
		       (int)player.getPosition().getX()/2+(int)player.getPosition().getX()/4+i,
		       (int)player.getPosition().getY()/2+(int)player.getPosition().getY()+50);


	// Отрисовка Дропов
	for (Drop drop : drops)
	    {
		g.drawImage(drop.getImage(), drop.getX(), drop.getY(),
			    drop.getWidth(), drop.getHeight(), null);
	    }
	
	// Отрисовка панели инвентaря
	for(Cell cell : inventory)
	    {
		g.setColor(blue);
		if(cell.getChosen()==true)
		    {
			g.setColor(yellow);
		    }
		g.fillRect(cell.getX(),cell.getY(),cell.getWidth(),cell.getHeight());
	
			
		if(cell.getItem()>0)
		    {
			g.drawImage(cell.getItemImage(),
				    cell.getX()+5,
				    cell.getY()+5,
				    cell.getWidth()/4*3,
				    cell.getHeight()/4*3, null );
		    }
		if (cell.getCountable()==true)
		    {
			TextUtil.drawText(g,
				       cell.getX()+cell.getWidth()*3/4,
				       cell.getY()+cell.getHeight()*3/4,
				       cell.getAmount()+"");
		    }
	    }
	// Отрисовка области взаимодействия

	g.setColor(red);

	// Вправо
	if(block_metric_x>=0)
	g.fillRect((int)player.getPosition().getX()+player.getWidth()*20,(int) player.getPosition().getY()-40+block_metric_y,60+block_metric_x,player.getHeight()*20+120);

	if(block_metric_x<0)
	g.fillRect((int)player.getPosition().getX()+player.getWidth()*20,(int) player.getPosition().getY()-40+block_metric_y,60+20+block_metric_x,player.getHeight()*20+120);

	//Влево
	if(block_metric_x>=0)
	    g.fillRect((int)player.getPosition().getX()-40-(20-block_metric_x),(int) player.getPosition().getY()-40+block_metric_y,(int) 100-block_metric_x,player.getHeight()*20+120);
	
	if(block_metric_x<0)
	    g.fillRect((int)player.getPosition().getX()-40+block_metric_x,(int) player.getPosition().getY()-40+block_metric_y,(int) 80-block_metric_x,player.getHeight()*20+120);

	// Отрисовка блоков
	
	for(Block b : blocks)
	    {
		g.drawImage(b.getImage(), (int) b.getPosition().getX(), (int) b.getPosition().getY(), 20, 20, null);
	    }
	// Отрисовка персонажей
	g.drawImage(player.getImage(),  (int) player.getPosition().getX(), (int) player.getPosition().getY(), player.getWidth()*20, player.getHeight()*20, null);


    }

    public static int getBlock_Metric_X()
    {
	return block_metric_x;
    }

    
    public static void setBlocks(CopyOnWriteArrayList<Block> blockss)
    {
	blocks=blockss;
    }

    public static int getBlock_Metric_Y()
    {
	return block_metric_y;
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
						if (player.getVPrijke()==0){
						    for (Block b : blocks)
							{
							    if((int) (player.getPosition().getX())>=(int) (b.getPosition().getX())+20 //+width
							       ||
							       (int) (player.getPosition().getX())+(player.getWidth()*20)<=(int) (b.getPosition().getX())
							       ) //Вне
								{}
							    else
								{
								    step=speed/100;
								    while(step>=0) //????????????????????????????
									{
									    if((int) (player.getPosition().getY())+(player.getHeight()*20)==(int) (b.getPosition().getY())-step
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
							    for (Drop d : drops)
								d.setPosition(0,-final_step);
							    player.setFly(0);
							    speed    = 99;
							    kostyl_dlya_setki.setPositionToNol();
			
							}
						    if(gonnaFly==1)
							{
							    player.setFly(1);
							    for (Block b : blocks)
								b.setPosition(0,-(speed/100));
							for (Drop d : drops)
								d.setPosition(0,-(speed/100));
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

						// Обработка Дропов

						//	for (Drop d : drops)
						//{ Пока рано
							
						//  }
					    }
				    });
}
