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

    public void setPosition(int x, int y)
    {
	pos.move((int)(pos.getX()+x),(int) (pos.getY()+y));
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
