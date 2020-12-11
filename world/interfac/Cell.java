package world.interfac;

public class Cell
{
    int x;
    int y;
    int item;
    public Cell (int x, int y, int item)
    {
	this.x=x;
	this.y=y;
	this.item=item;	    
    }

    public int getX()
    {
	return x;
    }

    public int getY()
    {
	return y;
    }
}
