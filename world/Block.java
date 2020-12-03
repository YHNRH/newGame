package world;


import java.awt.image.BufferedImage;
import world.ImgCol;
import java.awt.Point;

public class Block
{
    
    public static final int GROUND = 0;
    
    int type, x, y;
    public Block(int t,int x, int y)
    {
	type = t;
	this.x=x;
	this.y=y;
    }

    public Point getPosition()
    {
	return new Point(x*10,y*10);
    }

    public BufferedImage getImage()
    {
	return ImgCol.ground;
    }
}
