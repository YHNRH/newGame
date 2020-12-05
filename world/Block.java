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
	if (World.getBlock_Metric_X()>=0)
	    pos = new Point(x*20+World.getBlock_Metric_X()-20,y*20);
	else
	    pos = new Point(x*20+World.getBlock_Metric_X()-20,y*20);
    }

    public Point getPosition()
    {
	
	return pos;
    }
    
    public void setPosition(int x, int y)
    {
	pos.move((int)(pos.getX()+x),(int) (pos.getY()+y));
    }

    public BufferedImage getImage()
    {
	return ImgCol.ground;
    }
}
