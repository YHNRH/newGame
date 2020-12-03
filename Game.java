import javax.swing.*;
import java.awt.Point;
import world.*;
import world.players.*;
import java.util.concurrent.CopyOnWriteArrayList;
class Game {
    public static void main(String[] args)
    {
	CopyOnWriteArrayList<Block> blocks = new CopyOnWriteArrayList<>();
	Player player = new Player(new Point (0,0), ImgCol.player,2,3);
	JFrame win = new JFrame();
	World world = new World(blocks, player);
	win.setSize(500, 500);
	win.setVisible(true);
	win.setContentPane(world);

	for (int i=0;i<10;i++)
	    {
		blocks.add(new Block (Block.GROUND,i,10));
	    }
	
    }
}
