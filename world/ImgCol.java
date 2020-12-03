package world;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImgCol {
    public static final BufferedImage ground;
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
    }
}
