package world;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImgCol {
    public static final int GROUND = 1;
    public static final int PICAXE = 50;
    public static final BufferedImage items[] = new BufferedImage[100];
    public static final BufferedImage numbers[] = new BufferedImage[10];
    public static final BufferedImage[][] player = new BufferedImage[3][2];

    static {
	BufferedImage full_numbers;
	try {
	    full_numbers = ImageIO.read(new File("res/numbers.png"));
	    for(int i=0;i<10;i++)
	    {
		numbers[i]=full_numbers.getSubimage(45*i,0,45,60);
	    }
	} catch (IOException e)
	    {
		  e.printStackTrace();
		  full_numbers = null;
	      }
	
	
	BufferedImage _ground;
	try {
	    _ground = ImageIO.read(new File("res/ground.jpg"));
	} catch (IOException e)
	    {
		  e.printStackTrace();
		  _ground = null;
	      }
        items[GROUND] = _ground;

	BufferedImage _picaxe;
	try {
	    _picaxe = ImageIO.read(new File("res/picaxe.png"));
	} catch (IOException e)
	    {
		  e.printStackTrace();
		  _picaxe = null;
	      }
        items[PICAXE] = _picaxe;
	
	BufferedImage player_full;
	try
	    {
		int i = 0;
		player_full = ImageIO.read(new File("res/pers.png"));
		for (int stolb=292;stolb<421;stolb+=36)
		    {
			int j=0;
			for (int stroka = 93; stroka<231; stroka+=64)
			    {
				player[i][j] = player_full.getSubimage(stolb, stroka, 36, 64);
				j++;
				stroka+=10;
		    }
			i++;
			stolb+=8;
		    }
	    }
	catch (IOException e)
	    {
		player_full = null;
		e.printStackTrace();
        }
	
    }
    
}
