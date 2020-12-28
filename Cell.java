import java.awt.image.BufferedImage;

public class Cell
{
    int height = 40;
    int width = 40;
    int x;
    int y;
    int item;
    int amount;
    boolean chosen = false;
    public Cell (int x, int y, int item)
    {
	this.x=x;
	this.y=y;
	this.item=item;
	
    }

    public int getAmount()
    {
	return amount;
    }

    public boolean getCountable()
    {
	boolean c;
        if (item<50 && item>0)
	    c = true;
	else c = false;
	return c;
    }

    public void setAmount(int a)
    {
	amount+=a;
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
	return ImgCol.items[item];
    }
}
