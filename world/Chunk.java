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
	
    }

    public int getX()
    {
	return nx;
    }

    public int getY()
    {
	return ny;
    }

    public void randomCreation()
    {
	for(int x=0; x<400;x+=20)
	    {
		for (int y=0; y<400; y+=20)
		    {
			int forTest = (int)(Math.random()*ny);
			if (forTest>=1)
			    {				
				blocks.add(new Block(
						     1, // Временно
						     x+nx*400,
						     y+ny*400
						     ));
			    }
		    }
	    }
    }

    public void addBlock(Block b)
    {
	blocks.add(b);
    }

    public CopyOnWriteArrayList<Block> getBlocks()
    {
	return blocks;
    }

    
}
