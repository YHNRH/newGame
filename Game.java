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

    static CopyOnWriteArrayList<Chunk> chunks;
    // TODO
    // Установка блоков в плеера
    public static void main(String[] args)
    {
        chunks = new CopyOnWriteArrayList<>();

	generateChunks();
	CopyOnWriteArrayList<Cell> inventory = new CopyOnWriteArrayList<>();
	CopyOnWriteArrayList<Drop> drops = new CopyOnWriteArrayList<>();
	
	for (int i = 0; i<10; i++)
	    {
		Cell cell = new Cell(60+i*60,40,0);
		if(i==0)
		    {
			cell.setItem(1);
			cell.setAmount(50);
		    }
		if(i==1)
		    cell.setItem(50);
		inventory.add(cell);
	    }
	
	
	JFrame win = new JFrame();
	Dimension sSize = Toolkit.getDefaultToolkit ().getScreenSize ();
		
	Player player = new Player(new Point ((int)sSize.getWidth()/20*10,(int)sSize.getHeight()/20*10), ImgCol.player,2,3, chunks, drops);
        
	World world = new World(chunks, inventory, drops, player);
	win.setContentPane(world);

	// Задаем размер
	win.setSize (sSize);

	win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	win.setUndecorated(true);
	win.setVisible(true);
	
	win.addKeyListener(new KL(chunks, inventory, player));
	win.addMouseListener(new ML(chunks, inventory, drops, player, world));


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

    static void generateChunks()
    {
	for(int x=0;x<3;x++)
	    {
		for(int y=0;y<3;y++)
		    {
			chunks.add(new Chunk(x,y));
		    }
		
	    }
    }
}
