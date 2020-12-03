import javax.swing.*;
import world.*;
import java.util.concurrent.CopyOnWriteArrayList;
class Game {
    public static void main(String[] args)
    {
	CopyOnWriteArrayList<Block> blocks = new CopyOnWriteArrayList<>();
	JFrame win = new JFrame();
	World world = new World(blocks);
	win.setSize(500, 500);
	win.setVisible(true);
	win.setContentPane(world);

	for (int i=0;i<10;i++)
	    {
		blocks.add(new Block (Block.GROUND,i,10));
	    }
    }
}
