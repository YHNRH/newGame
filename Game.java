import javax.swing.*;
import java.awt.Point;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.concurrent.CopyOnWriteArrayList;
public class Game {

    static CopyOnWriteArrayList<Chunk> chunks;
    // TODO
    // Установка блоков в плеера
    // Добавить счет пройденного растояния во все стороны(либо сохранять значения костыля ЧТО ПРЕДПОЧТИТЕЛЬНЕЕ)))))))))
    // 
    public static void main(String[] args)
    {
        chunks = new CopyOnWriteArrayList<>();
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
		
	

	GenerateUtil gen = new GenerateUtil();
	Thread t = new Thread(gen);
	t.start();
		while (t.isAlive()){}
	Player player = new Player(new Point ((int)sSize.getWidth()/20*10,(int)sSize.getHeight()/20*10), ImgCol.player,2,3, drops);
	
	World world = new World(inventory, drops, player);
	win.setContentPane(world);

	// Задаем размер
	win.setSize (sSize);

	win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	win.setUndecorated(true);
	win.setVisible(true);
	
	win.addKeyListener(new KL(inventory, player));
	win.addMouseListener(new ML(inventory, drops, player, world));


	while(true)
	    {
		win.repaint();
		try
		    {
			Thread.sleep(20);
		    }
		catch(Exception e)
		    {}
	    }
	
    }

    
}
