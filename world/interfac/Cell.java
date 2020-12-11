package world.interfac;

import world.ImgCol;
import world.Block;
import java.awt.image.BufferedImage;

public class Cell
{
    int height = 40;
    int width = 40;
    int x;
    int y;
    int item;
    boolean chosen = false;
    public Cell (int x, int y, int item)
    {
	this.x=x;
	this.y=y;
	this.item=item;	    
    }

    public int getHeight()
    {
	return height;
    }

    public int getWidth()
    {
	return width;
    }
    
    public int getX()
    {
	return x;
    }

    public int getY()
    {
	return y;
    }

    public int getItem()
    {
	return item; 
    }

    public boolean getChosen()
    {
	return chosen;
    }

    public void setChosen(boolean c)
    {
	chosen=c;
    }

    public void setItem(int item)
    {
	this.item=item;
    };

    public BufferedImage getItemImage()
    {
	BufferedImage res;
	switch(item)
	    {
	    case 50:
		res = ImgCol.picaxe; // Временно
		break;
	    case Block.GROUND:
	        res =  ImgCol.ground;
		break;
	    default:
	        res = null;
		break;
	    }
	return res;
    }
}
