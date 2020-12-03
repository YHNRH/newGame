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
	Player player = new Player(new Point (240,240), ImgCol.player,2,3, blocks);
	JFrame win = new JFrame();
	World world = new World(blocks, player);
	win.setSize(520, 558);
	win.setVisible(true);
	win.setContentPane(world);
	win.addKeyListener(new KL(blocks, player));


	blocks.add(new Block (Block.GROUND,20,15));
	
	blocks.add(new Block (Block.GROUND,0,15));
	for (int i=0;i<20;i++)
	    {
		blocks.add(new Block (Block.GROUND,i,16));
	    }
	while(true)
	    {
		win.repaint();
		try
		    {
			Thread.sleep(10);
		    }
		catch(Exception e)
		    {}
	    }
	
    }
}
