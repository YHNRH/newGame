import javax.swing.*;
import java.awt.Point;
import world.*;
import world.players.*;
import controllers.*;
import java.util.concurrent.CopyOnWriteArrayList;
public class Game {

    // TODO
    // Установка блоков не в друг друга
    // 
    public static void main(String[] args)
    {
	CopyOnWriteArrayList<Block> blocks = new CopyOnWriteArrayList<>();
	
	blocks.add(new Block (Block.GROUND,200,1340));
	
	blocks.add(new Block (Block.GROUND,0,1340));
	for (int i=0;i<300;i+=20)
	    {
		blocks.add(new Block (Block.GROUND,i,1360));
	    }
	JFrame win = new JFrame();
	win.setSize(520, 558);
	
	
	Player player = new Player(new Point (240,240), ImgCol.player,2,3, blocks);

	World world = new World(blocks, player);
	win.setContentPane(world);
	
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
