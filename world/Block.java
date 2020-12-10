package world;


import java.awt.image.BufferedImage;
import world.ImgCol;
import java.awt.Point;

public class Block
{
    
    public static final int GROUND = 0;
    
    int type;
    Point pos;
    public Block(int t,int x, int y)
    {
	type = t;
	//pos = new Point(x*20+World.getBlock_Metric_X()-20,y*20+World.getBlock_Metric_Y()%20-20);
	// Работало
	pos = new Point(x,y);
    }

    public Point getPosition()
    {
	
	return pos;
    }
    
    public void setPosition(int x, int y)
    {
	pos.move((int)(pos.getX()+x),(int) (pos.getY()+y));
    }

    public void setPositionToNol() // По игрику
    {
	pos.move((int)pos.getX(),0);
    }

    public BufferedImage getImage()
    {
	return ImgCol.ground;
    }

    public int getHeight()
    {
	switch (type)
	    {
	    case GROUND:
		return 20;
	    default:
		return 20;
	    }
    }

    public int getWidth()
    {
	switch (type)
	    {
	    case GROUND:
		return 20;
	    default:
		return 20;
	
	    }
    }
}
