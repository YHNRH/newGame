package world;


import java.util.concurrent.CopyOnWriteArrayList;
public class Chunk
{
    int nx;
    CopyOnWriteArrayList<Block> blocks = new CopyOnWriteArrayList<>();
    int ny;

    public Chunk (int nx, int ny)
    {
	this.nx=nx;
	this.ny=ny;
	for(int x=0; x<200;x+=20)
	    {
		for (int y=0; y<200; y+=20)
		    {
			blocks.add(new Block(
					     (int)(Math.random()*ny), // Временно
					     x,
					     y
					     ));
		    }
	    }
    }

    
}
