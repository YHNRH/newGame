import javax.swing.*;
import java.awt.Point;
import world.*;
import world.players.*;
import controllers.*;
import java.util.concurrent.CopyOnWriteArrayList;
public class Game {
    
    public static void main(String[] args)
    {
	CopyOnWriteArrayList<Block> blocks = new CopyOnWriteArrayList<>();
	Player player = new Player(new Point (240,240), ImgCol.player,2,3);
	JFrame win = new JFrame();
	World world = new World(blocks, player);
	win.setSize(520, 558);
	win.setVisible(true);
	win.setContentPane(world);
	win.addKeyListener(new KL(blocks));
	    
	for (int i=0;i<10;i++)
	    {
		blocks.add(new Block (Block.GROUND,i,10));
	    }
	while(true)
	    {
		win.repaint();
		try
		    {
			Thread.sleep(50);
		    }
		catch(Exception e)
		    {}
	    }
	
    }
}
