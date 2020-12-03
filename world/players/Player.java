package world.players;

import java.awt.image.*;
import java.awt.Point;

public class Player extends Entity
{
    
    BufferedImage[][] img;
    public Player(Point pos, BufferedImage[][] img, int width, int height)
    {
	this.pos=pos;
	this.img=img;
	this.width=width;
	this.height=height;
    }
    public BufferedImage getImage()
    {
	return img[1][1];
    }
}
