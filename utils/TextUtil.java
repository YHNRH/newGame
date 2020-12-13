package utils;

import world.ImgCol;
import java.awt.Graphics;

public class TextUtil
{
    public static void drawText(Graphics g, int x, int y, String str)
    {
	for (int i=0; i<str.length(); i++)
	    {
		g.drawImage(ImgCol.numbers[Integer.valueOf(str.charAt(i)+"")], x+i*10+2,y,10,15, null);
	    }
    }
}
