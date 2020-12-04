package world;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImgCol {
    public static final BufferedImage ground;
    public static final BufferedImage[][] player = new BufferedImage[3][2];

    static {
	BufferedImage _ground;
	try {
	    _ground = ImageIO.read(new File("res/ground.jpg"));
	} catch (IOException e)
	    {
		  e.printStackTrace();
		  _ground = null;
	      }
	ground = _ground;
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
