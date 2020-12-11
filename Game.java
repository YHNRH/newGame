import javax.swing.*;
import java.awt.Point;

import java.awt.Dimension;
import java.awt.Toolkit;
import world.*;
import world.interfac.Cell;
import world.players.*;
import controllers.*;
import java.util.concurrent.CopyOnWriteArrayList;
public class Game {

    // TODO
    // Установка блоков в плеера
    // Объеденить потоки перемещения плеера
    // Переключение между 2 режимами (ставить и сносить) - прототип инвентаря
    public static void main(String[] args)
    {
	CopyOnWriteArrayList<Block> blocks = new CopyOnWriteArrayList<>();
	CopyOnWriteArrayList<Cell> inventory = new CopyOnWriteArrayList<>();

	for (int i = 0; i<10; i++)
	    {
		inventory.add(new Cell(60+i*60,40,0));
	    }
	
	blocks.add(new Block (Block.GROUND,200,1340));
	
	blocks.add(new Block (Block.GROUND,0,1340));
	for (int i=0;i<1000;i+=20)
	    {
		blocks.add(new Block (Block.GROUND,i,1360));
	    }
	JFrame win = new JFrame();
	//win.setSize(520, 558);
	Dimension sSize = Toolkit.getDefaultToolkit ().getScreenSize ();
		
	Player player = new Player(new Point ((int)sSize.getWidth()/20*10,(int)sSize.getHeight()/20*10), ImgCol.player,2,3, blocks);
        
	World world = new World(blocks, inventory, player);
	win.setContentPane(world);

	// Задаем размер
	win.setSize (sSize);

	win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	win.setUndecorated(true);
	win.setVisible(true);
	
	win.addKeyListener(new KL(blocks, player));
	win.addMouseListener(new ML(blocks, player, world));


	while(true)
	    {
		win.repaint();
		try
		    {
			Thread.sleep(5);
		    }
		catch(Exception e)
		    {}
	    }
	
    }
}
