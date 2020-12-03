package world.players;
import java.awt.*;
import java.awt.image.*;
class Entity
{
    Point pos;
    BufferedImage img;
    int width;
    int height;

    public BufferedImage getImage()
    {
	return img;
    }
    public Point getPosition()
    {
	return pos;
    }

    public int getWidth()
    {
	return width;
    }

    public int getHeight()
    {
	return height;
    }
}
